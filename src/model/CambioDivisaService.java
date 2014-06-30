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
public class CambioDivisaService {
	private static Logger log = Logger.getLogger( CambioDivisaService.class );

	@Autowired
	@Qualifier("webServiceTemplate")
    private WebServiceTemplate wsTemplate;

	public String getConversionRate(String FromCurrency , String ToCurrency){
		log.debug( "Consultando WebService CambioDivisa. Operación: ConversionRate" );
		StringWriter sw = new StringWriter();
		String mensaje = "<ConversionRate xmlns=\"http://www.webserviceX.NET/\"><FromCurrency>"+FromCurrency+"</FromCurrency><ToCurrency>"+ToCurrency+"</ToCurrency></ConversionRate>";
		wsTemplate.sendSourceAndReceiveToResult( "http://www.webservicex.com/CurrencyConvertor.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}

}
