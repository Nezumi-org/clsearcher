package clsearcher.service;

import java.util.ArrayList;
import java.util.List;
import clsearcher.domain.CommandSearchCriteria;
import junit.framework.TestCase;

public class CraigListSearchManagerTests extends TestCase {
	
	private CraigListSearchManager craigListSearchManager;
	private List<CraigListUrl> urls;
	private CraigListUrl url;
	private CommandSearchCriteria criteria;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		criteria = new CommandSearchCriteria();
		String[] regions  = new String[] {"Seattle","Snohomish", "EastSide"};
		criteria.setRegions(regions);
		String[] categories  = new String[] {"Toy","Baby"};
		criteria.setCategories(categories);
		String searchWord = "Table";
		criteria.setSearchWord(searchWord);
		
		craigListSearchManager = new CraigListSearchManager();
		craigListSearchManager.buildUrls(criteria);
		}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
   public void testGetUrls(){
		
		List<CraigListUrl> urls = craigListSearchManager.getUrls();
		assertNotNull(urls);
		CraigListUrl url = urls.get(0);
		assertEquals("http://seattle.craiglist.org/see/tag/", url.getFullPath());
		url = urls.get(1);
		assertEquals("http://seattle.craiglist.org/see/bab/", url.getFullPath());
		url = urls.get(2);
		assertEquals("http://seattle.craiglist.org/sno/tag/", url.getFullPath());
		url = urls.get(3);
		assertEquals("http://seattle.craiglist.org/sno/bab/", url.getFullPath());
		url = urls.get(4);
		assertEquals("http://seattle.craiglist.org/est/tag/", url.getFullPath());
		url = urls.get(5);
		assertEquals("http://seattle.craiglist.org/est/bab/", url.getFullPath());
		
	}
	public void testSearch(){
		List<Item> re = craigListSearchManager.search();
		//for (Item s: re){
			//System.out.println(s);
		//}
		
	}
}
