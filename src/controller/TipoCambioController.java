package controller;

import model.TipoCambioService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TipoCambioController {
	private static Logger log = Logger.getLogger( TipoCambioController.class );

	@Autowired
	TipoCambioService service;
	
	@RequestMapping("/TipoCambio/VariablesDisponibles")
	@ResponseBody
	public String consultaVariablesDisponibles( Model model ){
		log.debug( "Procesando /TipoCambio/VariablesDisponibles.form" );
        return service.getVariablesDisponibles();
	}

	@RequestMapping("/TipoCambio/Variables")
	@ResponseBody
	public String consultaVariables( @RequestParam("variable") String variable, Model model ){
		log.debug( "Procesando /TipoCambio/Variables.form" );
		return service.getaVariables( variable );
	}
}
