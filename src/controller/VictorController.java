package controller;

import model.VictorService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VictorController {
	private static Logger log = Logger.getLogger( VictorController.class );

	@Autowired
	VictorService service;

	@RequestMapping("/Victor/sumar")
	@ResponseBody
	public String consultaSuma( @RequestParam("primero") String primero,@RequestParam("segundo") String segundo, Model model ){
		log.debug( "Procesando /Victor/sumar.form" );
		return service.getSumar(primero,segundo);
	}

	
	
	
	
}
