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
public class WebServiceTestService {
	private static Logger log = Logger.getLogger( WebServiceTestService.class );

	@Autowired
	@Qualifier("webServiceTemplate2")
    private WebServiceTemplate wsTemplate;

	public String getValidarRUTRequest( String RUT, String cv ){
		log.debug( "Consultando WebService WebServiceTestService. Operación: getValidarRUTRequest" );
		StringWriter sw = new StringWriter();
		String mensaje = "<val:ValidarRUTRequest xmlns:val=\"http://www.example.org/validaciones/\"><RUT>"+RUT+"</RUT><cv>"+cv+"</cv></val:ValidarRUTRequest>";
		wsTemplate.sendSourceAndReceiveToResult( new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}
	
	public String getNivelSeguridadPasswordRequest( String password ){
		log.debug( "Consultando WebService WebServiceTestService. Operación: getNivelSeguridadPasswordRequest" );
		StringWriter sw = new StringWriter();
		String mensaje = "<val:NivelSeguridadPasswordRequest xmlns:val=\"http://www.example.org/validaciones/\"><password>"+password+"</password></val:NivelSeguridadPasswordRequest>";
		wsTemplate.sendSourceAndReceiveToResult( new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}
	
	
	
	
	
	
	
    


}
