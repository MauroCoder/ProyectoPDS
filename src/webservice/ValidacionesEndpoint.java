package webservice;

import java.io.ByteArrayInputStream;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.Namespace;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.XPathParam;

import webservice.service.ValidacionesService;

@Endpoint
public class ValidacionesEndpoint {
	private static Logger log = Logger.getLogger( ValidacionesEndpoint.class );
	private final ValidacionesService validacionesService;
	
	@Autowired
	public ValidacionesEndpoint( ValidacionesService validacionesService ){
		this.validacionesService = validacionesService;
	}

	@PayloadRoot(localPart = "ValidarEmailRequest", namespace = "http://www.example.org/validaciones/")
	@Namespace(prefix = "s", uri="http://www.example.org/validaciones/")
	@ResponsePayload
	public Source validarEmail( @XPathParam("/s:ValidarEmailRequest/email/text()") String email ){
		log.debug( "Procesando ValidarEmailRequest.." );
		String respuesta = "<ValidarEmailResponse xmlns=\"http://www.example.org/validaciones/\">" + validacionesService.validarEmail( email ) + "</ValidarEmailResponse>";
		log.debug( "Respuesta: " + respuesta );
		return new StreamSource( new ByteArrayInputStream( respuesta.getBytes() ) );
	}

	@PayloadRoot(localPart = "ValidarRUTRequest", namespace = "http://www.example.org/validaciones/")
	@Namespace(prefix = "s", uri="http://www.example.org/validaciones/")
	@ResponsePayload
	public Source validarRUT( @XPathParam("/s:ValidarRUTRequest/RUT/text()") int rut, @XPathParam("/s:ValidarRUTRequest/cv/text()") String cv ){
		log.debug( "Procesando ValidarRUTRequest.." );
		String respuesta = "<ValidarRUTResponse xmlns=\"http://www.example.org/validaciones/\">" + validacionesService.validarRUT( rut, cv.charAt( 0 ) ) + "</ValidarRUTResponse>";
		log.debug( "Respuesta: " + respuesta );
		return new StreamSource( new ByteArrayInputStream( respuesta.getBytes() ) );
	}

	@PayloadRoot(localPart = "NivelSeguridadPasswordRequest", namespace = "http://www.example.org/validaciones/")
	@Namespace(prefix = "s", uri="http://www.example.org/validaciones/")
	@ResponsePayload
	public Source nivelSeguridadPassword( @XPathParam("/s:NivelSeguridadPasswordRequest/password/text()") String password ){
		log.debug( "Procesando NivelSeguridadPasswordRequest.." );
		String respuesta = "<NivelSeguridadPasswordResponse xmlns=\"http://www.example.org/validaciones/\">" + validacionesService.getNivelSeguridadPassword( password ) + "</NivelSeguridadPasswordResponse>";
		log.debug( "Respuesta: " + respuesta );
		return new StreamSource( new ByteArrayInputStream( respuesta.getBytes() ) );
	}
}