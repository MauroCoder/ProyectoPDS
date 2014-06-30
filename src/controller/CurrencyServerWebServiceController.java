package controller;

import model.CurrencyServerWebServiceService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CurrencyServerWebServiceController {
	private static Logger log = Logger.getLogger( CurrencyServerWebServiceController.class );

	@Autowired
	CurrencyServerWebServiceService service;
	
	@RequestMapping("/CurrencyServer/getDataSet")
	@ResponseBody
	public String consultaDataSet( @RequestParam("provider") String provider, Model model ){
		log.debug( "Procesando /CurrencyServer/getDataSet.form" );
        return service.getDataSet( provider );
	}

	@RequestMapping("/CurrencyServer/getDollarValue")
	@ResponseBody
	public String consultaDollarValue( @RequestParam("provider") String provider, @RequestParam("currency") String currency, Model model ){
		log.debug( "Procesando /CurrencyServer/getDollarValue.form" );
        return service.getDollarValue( provider, currency );
	}

	@RequestMapping("/CurrencyServer/getProviderList")
	@ResponseBody
	public String consultaProviderList( Model model ){
		log.debug( "Procesando /CurrencyServer/getProviderList.form" );
        return service.getProviderList();
	}
}
