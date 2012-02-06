package clsearcher.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**Obtain the content of a URL urlString*/
public class WWWGetter {
        private String urlString;//
        private String page;
        private URLConnection conn;
        
        protected final Log logger = LogFactory.getLog(getClass());

        WWWGetter(String urlString){
        	
        	this.urlString = urlString;
        	logger.info("urlString: ... "+ urlString );
            
        	try{
        	URL url = new URL( urlString );
            Object content = url.getContent();
            logger.info("LEFT url.getContent()... " );
            if( content instanceof InputStream ) {
                BufferedReader reader
                   = new BufferedReader(
                       new InputStreamReader( (InputStream)content ) );
                String line;
                logger.info("LEFT reader ... " );
                
                StringBuffer buffer = new StringBuffer();
                while( ( line = reader.readLine() ) != null ) {
                    System.out.println( line );
                    buffer.append(line +"\n");
		           }
                this.page = buffer.toString();
                reader.close();
            } else {
                System.out.println( "This content is " + content.toString() );
	    }
        }
        catch( ArrayIndexOutOfBoundsException e ){
            System.err.println( "Usage: java URLTextContent URL" );
            System.exit(-1);
        }
        catch( IOException e ){
            System.err.println( "Network error!" );
            System.exit(-1);
        }
        
    }
        public String getPage(){
	        	return page;
	}
	  
	        
    }
