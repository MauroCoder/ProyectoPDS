package controller;

import model.WSMeteorologicoService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WSMeteorologicoController {
	private static Logger log = Logger.getLogger( WSMeteorologicoController.class );

	@Autowired
	WSMeteorologicoService service;
	
	@RequestMapping("/WSMeteorologico/Efemerides")
	@ResponseBody
	public String consultaEfemerides( Model model ){
		log.debug( "Procesando /WSMeteorologico/Efemerides.form" );
		return service.getEfemerides();
	}

	@RequestMapping("/WSMeteorologico/PronosticoPorCiudad")
	@ResponseBody
	public String consultaPronosticoPorCiudad( Model model ){
		log.debug( "Procesando /WSMeteorologico/PronosticoPorCiudad.form" );
		return service.getPronosticoPorCiudad();
	}
}
