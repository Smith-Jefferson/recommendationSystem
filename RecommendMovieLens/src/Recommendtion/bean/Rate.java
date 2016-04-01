package Recommendtion.bean;

import java.sql.Timestamp;

public class Rate {

	private int userid;
	private int movieid;
	private float rate;
	private Timestamp timestamp;
	public Rate(){}
	public Rate(int movieid,float rate){
		this.movieid=movieid;
		this.rate=rate;
	}
	public Rate(int movieid,int userid,float rate){
		this.movieid=movieid;
		this.userid=userid;
	}
	public Rate(int movieid,int userid,float rate,Timestamp timestamp){
		this(movieid,userid,rate);
		this.timestamp=timestamp;
	}
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
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
}
