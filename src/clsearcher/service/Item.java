package clsearcher.service;

/**Represents an Item retrieved from the SearchManager */
public class Item {
	private String href;
	private String title;
	private String region;
	
	Item(String href, String title, String region){
		this.href = href;
		this.title = title;
		this.region = region;
	}
	public void setHref(String href){
		this.href = href;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getHref(){
		return href;
	}
	public String getTitle(){
		return title;
	}
	public String getRegion(){
		return region;
	}
	public String toString(){
		return( "href-> " + href +  "\nRegion-> " + region + "\ntitle-> " + title );
	}
}

