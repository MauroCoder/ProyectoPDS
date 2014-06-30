package controller;

import model.PhoneNotifyService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PhoneNotifyController {
	private static Logger log = Logger.getLogger( PhoneNotifyController.class );

	@Autowired
	PhoneNotifyService service;
	
	@RequestMapping("/PhoneNotify/getVoices")
	@ResponseBody
	public String consultaVariablesDisponibles( Model model ){
		log.debug( "Procesando /PhoneNotify/getVoices.form" );
        return service.getVoices();
	}

	@RequestMapping("/PhoneNotify/getResponseCodes")
	@ResponseBody
	public String consultaResponseCodes( Model model ){
		log.debug( "Procesando /PhoneNotify/getResponseCodes.form" );
        return service.getResponseCodes();
	}
}
