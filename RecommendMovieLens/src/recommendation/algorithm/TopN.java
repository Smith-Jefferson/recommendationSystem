package recommendation.algorithm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Recommendtion.bean.Item;
import Recommendtion.bean.Tag;
import Recommendtion.bean.User;
import recommendation.data.movielens;

public class TopN {

	private static movielens Model;
	public List<Item> GetRecommendation(User user,int N){
		return null;
	}
	
	public static ArrayList<Item> getTopN(){
		Model=new movielens();
		HashMap<Item, ArrayList<Tag>> moviesTagsMatrix;
		HashMap<Set<Item>,Double> SimMatrix;
		try {
			moviesTagsMatrix = Model.moviesTagsMatrix();
			SimMatrix=Model.computeSimMatrix(moviesTagsMatrix);
			System.out.println(SimMatrix);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void main(String[] args){
		List<Item> itemlist=new ArrayList<>();
		itemlist=getTopN();
	}
}
