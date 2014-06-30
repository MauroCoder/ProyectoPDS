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
public class PhoneNotifyService {
	private static Logger log = Logger.getLogger( PhoneNotifyService.class );

	@Autowired
	@Qualifier("webServiceTemplate")
    private WebServiceTemplate wsTemplate;

	public String getVoices(){
		log.debug( "Consultando WebService PhoneNotify. Operación: getVoices" );
		StringWriter sw = new StringWriter();
		String mensaje = "<getVoices xmlns=\"http://ws.cdyne.com/NotifyWS/\" />";
		wsTemplate.sendSourceAndReceiveToResult( "http://ws.cdyne.com/NotifyWS/phonenotify.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}

	public String getResponseCodes(){
		log.debug( "Consultando WebService PhoneNotify. Operación: GetResponseCodes" );
		StringWriter sw = new StringWriter();
		String mensaje = "<GetResponseCodes xmlns=\"http://ws.cdyne.com/NotifyWS/\" />";
		wsTemplate.sendSourceAndReceiveToResult( "http://ws.cdyne.com/NotifyWS/phonenotify.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}
}
