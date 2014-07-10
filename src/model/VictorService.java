package model;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class VictorService {
	private static Logger log = Logger.getLogger( VictorService.class );

	@Autowired
	@Qualifier("webServiceTemplate3")
    private WebServiceTemplate wsTemplate;

	public String getSumar( String primero, String segundo ){
		log.debug( "Consultando WebService VictorService. Operación: sumar" );
		StringWriter sw = new StringWriter();
		String mensaje = "<sumar xmlns=\"http://enteroenorme.com/\"><primero xmlns=\"\">"+primero+"</primero><segundo xmlns=\"\">"+segundo+"</segundo></sumar>";
		wsTemplate.sendSourceAndReceiveToResult( new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}
	

	
	
	
	
	
	
    


}
