package recommendation.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Recommendtion.bean.Item;
import Recommendtion.bean.Tag;
import recommendation.util.split.CalculateUtils;
import recommentdation.sql.ConnectPool;
import recommentdation.sql.SqlUtil;


public class movielens {
	/**
	 * 获取所有的标签
	 * @return
	 * @throws SQLException 
	 */
	private Connection conn;
	public ArrayList<Tag> getTags() throws SQLException{
		String query="SELECT  tag ,count(tag) as count from tags GROUP BY tag ORDER BY tag";
		conn=ConnectPool.instance().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet set= null;
		try{
			set= pstmt.executeQuery();
			ArrayList<Tag> taglist= new ArrayList<Tag>(set.getRow());
			while(set.next()){
				taglist.add(new Tag(set.getString("tag"),set.getInt("count")));
			}
			return taglist;
		}
		finally{
			SqlUtil.free(set,pstmt,conn);
		}
	}
	
	public ArrayList<Item> getMovies() throws SQLException{
		String query="SELECT DISTINCT movieid from tags  ";
		conn=ConnectPool.instance().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet set= null;
		try{
			set= pstmt.executeQuery();
			ArrayList<Item> itemlist= new ArrayList<>(set.getRow());
			while(set.next()){
				itemlist.add(new Item(set.getInt("movieid")));
			}
			return itemlist;
		}
		finally{
			SqlUtil.free(set,pstmt,conn);
		}
	}
	
	public Item movieTags(Item item) throws SQLException{
		int movieid=item.getMovieid();
		String query="SELECT tag from tags  where movieid="+movieid+" order by tag";
		conn=ConnectPool.instance().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet set= null;
		try{
			set= pstmt.executeQuery();
			ArrayList<Tag> taglist= new ArrayList<>(set.getRow());
			while(set.next()){
				taglist.add(new Tag(set.getString("tag")));
			}
			item.setTags(taglist);
			return item;
		}
		finally{
			SqlUtil.free(set,pstmt,conn);
		}
	}
	
	public HashMap<Item,ArrayList<Tag>> moviesTagsMatrix() throws SQLException{
		movielens model=new movielens();
		List<Tag> taglist=model.getTags();
		List<Item> movielist=model.getMovies();
		int msize=(int) (taglist.size()*movielist.size());
		HashMap<Item,ArrayList<Tag>> matrix=new HashMap<>(msize);
		ArrayList<Tag> tagcount=new ArrayList<>();
		int count=0;
		boolean flag=false;
		for(Item iMovie:movielist){
			iMovie=model.movieTags(iMovie);
			for(Tag tag:taglist){
				tag.setCount(0);
				count=0;
				flag=false;
				for(Tag jTag:iMovie.getTags()){
					if(tag.equals(jTag)){
						++count;
						flag=true;
						continue;
					}else if(flag){
						break;
					}	
				}
				tag.setCount(count);
				tagcount.add(tag);
			}
			iMovie.getTags().clear();
			matrix.put(iMovie, tagcount);
		}
		return matrix;
	}
	
	public HashMap<Set<Item>,Double> computeSimMatrix(HashMap<Item,ArrayList<Tag>> moviesTagsMatrix){
		if(!(moviesTagsMatrix==null)){
			HashMap<Set<Item>,Double> moivesSimMatrix=new HashMap<>();
			Set<Entry<Item, ArrayList<Tag>>> Matrix=moviesTagsMatrix.entrySet();
			int flag=0;//定义一个哨兵
			for(Entry<Item, ArrayList<Tag>> moiveTags : Matrix){
 				for(Entry<Item, ArrayList<Tag>> othermoiveTags : Matrix){
 					if(flag>0){
 						--flag;
 						continue;
					}
 					double sim=CalculateUtils.cosineSim(moiveTags, othermoiveTags);
 					Set<Item> set=new HashSet<Item>();
 					set.add(moiveTags.getKey());
 					set.add(othermoiveTags.getKey());
 					moivesSimMatrix.put(set, sim);
 				}
 				++flag;
				
			}
			return moivesSimMatrix;
		}
		
		return null;
		
		
	}
	
}
