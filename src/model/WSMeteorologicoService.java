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
public class WSMeteorologicoService {
	private static Logger log = Logger.getLogger( WSMeteorologicoService.class );
	
	@Autowired
	@Qualifier("webServiceTemplate")
	private WebServiceTemplate wsTemplate;

	public String getEfemerides(){
		log.debug( "Consultando WebService WSMeteorologico. Operación: Efemerides" );
		StringWriter sw = new StringWriter();
		String mensaje = "<Efemerides xmlns=\"http://tempuri.org/\" />";
		wsTemplate.sendSourceAndReceiveToResult( new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}

	public String getPronosticoPorCiudad(){
		log.debug( "Consultando WebService WSMeteorologico. Operación: Efemerides" );
		StringWriter sw = new StringWriter();
		String mensaje = "<PronosticoPorCiudad xmlns=\"http://tempuri.org/\" />";
		wsTemplate.sendSourceAndReceiveToResult( new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}
}
