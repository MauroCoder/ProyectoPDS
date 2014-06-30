package controller;

import model.CambioDivisaService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CambioDivisaController {
	private static Logger log = Logger.getLogger( CambioDivisaController.class );

	@Autowired
	CambioDivisaService service;
	
	@RequestMapping("/CambioDivisa/ConversionRate")
	@ResponseBody
	public String consultaConversionRate( @RequestParam("FromCurrency") String FromCurrency, @RequestParam("ToCurrency") String ToCurrency, Model model ){
		log.debug( "Procesando /CambioDivisa/ConversionRate.form" );
		return service.getConversionRate( FromCurrency,ToCurrency );
	}

}
