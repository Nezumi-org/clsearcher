package clsearcher.service;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import clsearcher.domain.CommandSearchCriteria;
import java.util.regex.*;

/**
 *Implements SearchManger specific to CraigList
 */
public class CraigListSearchManager implements SearchManager{
    private List<CraigListUrl> urls = new ArrayList<CraigListUrl>();
    private WWWGetter wwwget;
    private List<Item> items = new ArrayList<Item>(); //all items
    private List<Item> matchedItems = new ArrayList<Item>();
    private String searchWord;
    private String regSearchWord;
    private String nextPageRegex= "index(.+).html";
    private String hrefRegex = "<a href=\"(.+)\">(.+)</a> -";
    //private String pageContent;

    protected final Log logger = LogFactory.getLog(getClass());

     public void buildUrls(CommandSearchCriteria criteria){
    	 //scjp book says don't assert args to public method 
    	 //Assert.notNull(criteria); //to enable at runtime, java -ea classname
    	 setSearchWord(criteria.getSearchWord());
    		
    	 //build a list of CraigListUrl	 
        for(String r: criteria.getRegions()){
        	for(String c: criteria.getCategories()){
        		CraigListUrl url = new CraigListUrl(r, c);
        		urls.add(url);
            }
         }
    }
    public List<CraigListUrl> getUrls(){
    	return urls;
    }
    public boolean isListEmpty(){
    	if (matchedItems.isEmpty()) return true;
    	else return false;
    }
    public void emptyList(){
    	if (matchedItems.isEmpty() == false) matchedItems.clear();
    }
    public List<Item> search()  {
    	
    	searchHelper(); //get a list of items containing the searchWord 
    	Item matchedItem;
    	Pattern searchItemObj = Pattern.compile(regSearchWord, Pattern.CASE_INSENSITIVE);
   		for(Item i: items){
				Matcher mItem = searchItemObj.matcher(i.getTitle());
				if(mItem.find()){
					matchedItem = new Item(i.getHref(), i.getTitle(), i.getRegion());
					matchedItems.add(matchedItem);
	           	}
			}
		 return matchedItems;
    }
    private void searchHelper(){
    	Pattern nextPageObj = Pattern.compile(nextPageRegex);
    	Pattern hrefObj = Pattern.compile(hrefRegex);
    	Item item;
    	String region;
    	String pageContent;
    	
    	for(CraigListUrl url : urls){
    	    region = url.getPath1();
    		wwwget= new WWWGetter(url.getFullPath());
    		pageContent = wwwget.getPage();
    		Matcher mNextPageLink = nextPageObj.matcher(pageContent);
    		while(true){
    			Matcher mTitle = hrefObj.matcher(pageContent);
    			while (mTitle.find()){
    				item = new Item(mTitle.group(1), mTitle.group(2), region);
    				//logger.info("Adding "+ mTitle.group(1)+ "...."+ mTitle.group(2));
    				items.add(item);
    			}
    			mNextPageLink = nextPageObj.matcher(pageContent);
	    		if (mNextPageLink.find()){
	        		String nextPage = url.getFullPath() + mNextPageLink.group();//get the next page's content
	        		wwwget = new WWWGetter(nextPage);
	        		pageContent = wwwget.getPage();
	            	logger.info("Visiting next page .." + nextPage);
	        	}else{
	        		logger.info("No more next page. End of "+ url.getFullPath());
	               break;
	    			}
    		}//end of while
       	}//end of for
    }
    public void setSearchWord(String searchWord){
   	    fixSearchWord(this.searchWord);
   	 }
    private String fixSearchWord(String searchWord){
    	String newSearchWord;
     	StringBuffer buffer = new StringBuffer();
     	buffer.append( "\\b" + searchWord + "\\b");
     	newSearchWord = buffer.toString();
     	return newSearchWord;
    	 
     }
    
}
    

 