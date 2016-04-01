package Recommendtion.bean;

import java.util.ArrayList;

public class Item {

	private int movieid;
	private String title;
	private String genres;
	private ArrayList<Tag> tags;

	public ArrayList<Tag> getTags() {
		return tags;
	}
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}
	public Item(){}
	public Item(int movieid){
		this.movieid=movieid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public Item(int movieid,String title){
		this(movieid);
		this.title=title;
	}
	public Item(int movieid,String title,String genres){
		this(movieid,title);
		this.genres=genres;
	}
	@Override
	public boolean equals(Object other){
		if(this==other)
			return true;
		if(other==null)
			return false;
		if(!(other instanceof Item) )
			return false;
		final Item item=(Item)other;
		if(!(getMovieid()==item.getMovieid()))
			return false;
	
		return true;
	}
	
}
