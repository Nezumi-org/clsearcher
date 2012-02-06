package clsearcher.web;

import javax.servlet.ServletException;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import clsearcher.service.SearchManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//this is a static page so a regular html is enough in real app.
//use AbstractController for read-only page and simple requests.
public class HomeController extends AbstractController {
    
    private static final int FIVE_MINUTES = 5*60;
    
    private SearchManager searchManager;
  
    
    public HomeController() {
        setSupportedMethods(new String[]{METHOD_GET});//respond only to GET since this is a read-only page
        setCacheSeconds(FIVE_MINUTES);
    }
    public void setSearchManager(SearchManager searchManager) {
        this.searchManager = searchManager;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req,
            HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("home");
         return mav;
    }

}

