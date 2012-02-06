package clsearcher.web;
import clsearcher.domain.CommandSearchCriteria;
import clsearcher.service.SearchManager;
import clsearcher.service.Item;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import javax.servlet.http.HttpServletResponse;
// xterm -e "cd /opt/tomcat6/logs ; tail -f *"&


public class SearchController extends SimpleFormController {
	    
	protected final Log logger = LogFactory.getLog(getClass());
	private SearchManager searchManager;      
	
   public SearchController(){
		setCommandClass(CommandSearchCriteria.class);
		setCommandName("CommandSearchCriteria");
		setFormView("criteriaform");
		setSuccessView("criteriasuccess");
		logger.info("Leaving SearchController constroctor... " );
	}
   public void setSearchManager(SearchManager searchManager) {
       
	   this.searchManager = searchManager;
       logger.info("Leaving setCraigListSearchManager... " );
     }
 	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
    	CommandSearchCriteria criteria = new CommandSearchCriteria();
    	
    	//criteria.setRegions(new String []{"Snohomish"});
    	//criteria.setCategories(new String []{"Toy"});
    	criteria.setSearchWord("star wars");
 
		return criteria;
 	}
 	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)throws Exception {
 		
 		if ( searchManager.isListEmpty() == false ) searchManager.emptyList();
 		logger.info("Entering onSubmit " );
		// 入力クラスをキャストし、メッセージを取り出す
     	CommandSearchCriteria criteria = (CommandSearchCriteria) command;
     	// 業務ロジックを実行する
     	//should delete buildUrls and search(criteria) to make interface simple
     	logger.info("Retrieved criteria... " );
       searchManager.buildUrls(criteria);
       logger.info("builtUrls done.... " );
       List<Item> searchResult = searchManager.search(); 
       logger.info("searchResult list obtained.... " );
        
       logger.info("returning from Form view to " + getSuccessView());
       ModelAndView mav = new ModelAndView(getSuccessView());
       mav.addObject("items", searchResult); //items get referred in jsp view 
       mav.addObject("commandSearchCriteria", criteria);
       return mav;
       	}
 	@Override
 	protected Map<String, String[]> referenceData(HttpServletRequest request) throws Exception {
		
 		Map referenceData = new HashMap();
       
 		List<String> webregionList = new ArrayList<String>();
       webregionList.add("Seattle");
       webregionList.add("EastSide");
       webregionList.add("Snohomish");
       referenceData.put("webregionList", webregionList);

       List<String> webcategoryList = new ArrayList<String>();
		webcategoryList.add("Baby");
		webcategoryList.add("Toy");
		referenceData.put("webcategoryList", webcategoryList);

       logger.info("Leaving referenceData...");
        return referenceData;
 	}

}
	


