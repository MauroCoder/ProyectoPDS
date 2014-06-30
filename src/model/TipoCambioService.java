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
public class TipoCambioService {
	private static Logger log = Logger.getLogger( TipoCambioService.class );

	@Autowired
	@Qualifier("webServiceTemplate")
    private WebServiceTemplate wsTemplate;

	public String getVariablesDisponibles(){
		log.debug( "Consultando WebService TipoCambio. Operación: VariablesDisponibles" );
		StringWriter sw = new StringWriter();
		String mensaje = "<VariablesDisponibles xmlns=\"http://www.banguat.gob.gt/variables/ws/\" />";
		wsTemplate.sendSourceAndReceiveToResult( "http://www.banguat.gob.gt/variables/ws/TipoCambio.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
		return sw.toString();
	}

	public String getaVariables( String variable ){
		log.debug( "Consultando WebService TipoCambio. Operación: Variables" );
		log.debug( "Parametros: variable --> " +variable );
		StringWriter sw = new StringWriter();
		String mensaje = "<Variables xmlns=\"http://www.banguat.gob.gt/variables/ws/\"><variable>" + variable + "</variable></Variables>";
		wsTemplate.sendSourceAndReceiveToResult( "http://www.banguat.gob.gt/variables/ws/TipoCambio.asmx", new StreamSource( new StringReader( mensaje ) ), new StreamResult( sw ) );
		log.debug( "Resultado: " + sw.toString() );
        return sw.toString();
	}
}
