package controller;

import model.GeoIPService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeoIPController {
	private static Logger log = Logger.getLogger( GeoIPController.class );

	@Autowired
	GeoIPService service;
	
	@RequestMapping("/GeoIp/getGetGeoIP")
	@ResponseBody
	public String consultaConversionRate( @RequestParam("IPAddress") String IPAddress, Model model ){
		log.debug( "Procesando /GeoIp/getGetGeoIP.form" );
		return service.getGetGeoIP( IPAddress );
	}

}
