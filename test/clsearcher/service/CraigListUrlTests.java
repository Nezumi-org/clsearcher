package clsearcher.service;
import junit.framework.TestCase;
import clsearcher.service.CraigListUrl;

public class CraigListUrlTests extends TestCase {
	
	private CraigListUrl testObject;
	private CraigListUrl testObject2;
	private CraigListUrl testObject3;
	private CraigListUrl testObject4;
	private CraigListUrl testObjectBad1;
	private CraigListUrl testObjectBad2;
	protected void setUp() throws Exception {
		super.setUp();
		testObject = new CraigListUrl("Seattle","Toy");
		testObject2 = new CraigListUrl("Seattle","Baby");
		testObject3 = new CraigListUrl("EastSide","Toy");
		testObject4 = new CraigListUrl("EastSide","Baby");
		}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testGetFullPath(){
		assertEquals( "http://seattle.craiglist.org/see/tag/", testObject.getFullPath());
		assertEquals( "http://seattle.craiglist.org/see/bab/", testObject2.getFullPath());
		assertEquals( "http://seattle.craiglist.org/est/tag/", testObject3.getFullPath());
		assertEquals( "http://seattle.craiglist.org/est/bab/", testObject4.getFullPath());
		
	}
	//the use of assert in the CraigListUrl not working
	public void testGetFullPathWrongPath1() throws Exception{
		String fullpath;
		try{
			testObjectBad1 = new CraigListUrl("EastSid","Toy");
			fullpath = testObjectBad1.getFullPath();
			fail("Should have thrown exception");
		}catch(IllegalArgumentException e){
		assertEquals( "Argument path1 must be EastSide", e.getMessage());
		}
	}

}
