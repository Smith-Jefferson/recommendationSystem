package Recommendtion.bean;

import java.sql.Timestamp;

public class Tag {

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	private int userid;
	private int movieid;
	private String tag;
	private Timestamp timestamp;
	private int count=0;
	public Tag(){}
	public Tag(String tag){
		this.tag=tag;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Tag(String tag,int userid,Timestamp timestamp){
		this(tag);
		this.userid=userid;
		this.timestamp=timestamp;
	}
	public Tag(String tag,int count){
		this(tag);
		this.count=count;
	}
	public Tag(String tag,int movieid,int count){
		this(tag,count);
		this.movieid=movieid;
	}
	public Tag(String tag,int movieid,int userid,Timestamp timestamp){
		this(tag,userid,timestamp);
		this.movieid=movieid;
	}
	@Override
	public boolean equals(Object other){
		if(this==other)
			return true;
		if(other==null)
			return false;
		if(!(other instanceof Tag) )
			return false;
		final Tag tag=(Tag)other;
		if(!(getTag().equals(tag.getTag())))
			return false;
	
		return true;
	}
}
