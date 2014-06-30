package controller;

import model.WebServiceTestService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebServiceTestController {
	private static Logger log = Logger.getLogger( WebServiceTestController.class );

	@Autowired
	WebServiceTestService service;

	@RequestMapping("/WebServiceTestURL/RUT")
	@ResponseBody
	public String consultaRUT( @RequestParam("RUT") String RUT,@RequestParam("cv") String cv, Model model ){
		log.debug( "Procesando /WebServiceTest/RUT.form" );
		return service.getValidarRUTRequest(RUT,cv);
	}
	
	@RequestMapping("/WebServiceTestURL/password")
	@ResponseBody
	public String consultaPassword( @RequestParam("password") String password, Model model ){
		log.debug( "Procesando /WebServiceTest/password.form" );
		return service.getNivelSeguridadPasswordRequest(password);
	}
	
	
	
	
}
