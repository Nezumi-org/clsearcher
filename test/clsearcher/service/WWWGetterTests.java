package clsearcher.service;

import clsearcher.service.WWWGetter;
import junit.framework.TestCase;

public class WWWGetterTests extends TestCase {
	
	WWWGetter page;

	protected void setUp() throws Exception {
		super.setUp();
		 page = new WWWGetter("http://seattle.craigslist.org/sno/bab/");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testGetPage(){
		String res =  page.getPage();
		assertNotNull(res); 
		
	}

}
