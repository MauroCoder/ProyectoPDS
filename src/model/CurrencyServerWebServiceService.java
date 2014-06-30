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
public class CurrencyServerWebServiceService {
	private static Logger log = Logger.getLogger( CurrencyServerWebServiceService.class );

	@Autowired
	@Qualifier("webServiceTemplate")
    private WebServiceTemplate wsTemplate;

	public String getDataSet( String provider ){
		log.debug( "Consultando WebService CurrencyServerWebService. Operación: getDataSet" );
		StringWriter sw = new StringWriter();
		String mensaje = "<getDataSet xmlns=\"http://www.daenet.de/webservices/CurrencyServer\"><provider>" + provider + "</provider></getDataSet>";
		wsTemplate.sendSourceAndReceiveToResult( "http://www.currencyserver.de/webservice/currencyserverwebservice.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}

	public String getDollarValue( String provider, String currency ){
		log.debug( "Consultando WebService CurrencyServerWebService. Operación: getDollarValue" );
		StringWriter sw = new StringWriter();
		String mensaje = "<getDollarValue xmlns=\"http://www.daenet.de/webservices/CurrencyServer\"><provider>" + provider + "</provider><currency>" + currency + "</currency></getDollarValue>";
		wsTemplate.sendSourceAndReceiveToResult( "http://www.currencyserver.de/webservice/currencyserverwebservice.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}

	public String getProviderList(){
		log.debug( "Consultando WebService CurrencyServerWebService. Operación: getProviderList" );
		StringWriter sw = new StringWriter();
		String mensaje = "<getProviderList xmlns=\"http://www.daenet.de/webservices/CurrencyServer\"></getProviderList>";
		wsTemplate.sendSourceAndReceiveToResult( "http://www.currencyserver.de/webservice/currencyserverwebservice.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}
}
