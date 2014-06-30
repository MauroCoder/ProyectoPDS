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
public class GeoIPService {
	private static Logger log = Logger.getLogger( GeoIPService.class );

	@Autowired
	@Qualifier("webServiceTemplate")
    private WebServiceTemplate wsTemplate;

	public String getGetGeoIP(String IPAddress){
		log.debug( "Consultando WebService GeoIp. Operación: GetGeoIP" );
		StringWriter sw = new StringWriter();
		String mensaje = "<GetGeoIP xmlns=\"http://www.webservicex.net/\"><IPAddress>"+IPAddress+"</IPAddress></GetGeoIP>";
		wsTemplate.sendSourceAndReceiveToResult( "http://www.webservicex.net/geoipservice.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}

}
