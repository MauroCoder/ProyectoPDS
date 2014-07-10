function consultaWS1(){
	limpiar();
	loadimage();
	$.get( "./WSMeteorologico/PronosticoPorCiudad.form", function( data ) {
		  $( "#resultado" ).text(  $.xml2json( $.xml2json( data ).PronosticoPorCiudadResult ).COMENTARIO );
		}
	);
}

function consultaWS2(){
	limpiar();
	loadimage();
	if( $("#ws2-o1").hasClass( "active" ) ){
		$.get( "./CurrencyServer/getProviderList.form", function( data ) {
			  $( "#resultado" ).text( $.xml2json( data ) );
			}
		);
	}else if( $("#ws2-o2").hasClass( "active" ) ){
		$.get( "./CurrencyServer/getDollarValue.form", { provider: $("#ws2-o2-p1").val(), currency:$("#ws2-o2-p2").val() }, function( data ) {
			  $( "#resultado" ).text(  $.xml2json( data ));
			}
		);
	}else if( $("#ws2-o3").hasClass( "active" ) ){
		$.get( "./CurrencyServer/getDataSet.form", { provider: $("#ws2-o3-p1").val() }, function( data ) {
			  $( "#resultado" ).text( JSON.stringify( $.xml2json( data ), null, 2 ) );
			}
		);
	}
}

function consultaWS3(){
	limpiar();
	loadimage();
	if( $("#ws3-o1").hasClass( "active" ) ){
		$.get( "./CambioDivisa/ConversionRate.form", { FromCurrency: $("#ws3-o1-p1").val(),ToCurrency: $("#ws3-o1-p2").val() }, function( data ) {
			  $( "#resultado" ).text( '1 '+ $("#ws3-o1-p1").val() + ' = ' + $.xml2json( data ).ConversionRateResult + ' ' +$("#ws3-o1-p2").val() );
			}
		);
	}
}

function consultaWS4(){
	limpiar();
	loadimage();
	if( $("#ws4-o1").hasClass( "active" ) ){
		$.get( "./GeoIp/getGetGeoIP.form", { IPAddress: $("#ws4-o1-p1").val()},function( data ) {
			var result = $.xml2json( data ).GetGeoIPResult;
			var data = result.CountryName;
			  $( "#resultado" ).text(  data  );
			}
		);
	}
}

function consultaWS5(){
	limpiar();
	loadimage();
	if( $("#ws5-o1").hasClass( "active" ) ){
		$.get( "./WebServiceTestURL/RUT.form", { RUT: $("#ws5-o1-p1").val(), cv:$("#ws5-o1-p2").val() }, function( data ) {
				  $( "#resultado" ).text( 'El rut es ' + $.xml2json( data ) );
			}
		);
	}else if( $("#ws5-o2").hasClass( "active" ) ){
		$.get( "./WebServiceTestURL/password.form", { password: $("#ws5-o2-p1").val() }, function( data ) {
			  $( "#resultado" ).text( 'Nivel de Seguridad: '+ $.xml2json( data )+'%' );
			}
		);
	}else if( $("#ws5-o3").hasClass( "active" ) ){
		$.get( "./WebServiceTestURL/email.form", { email: $("#ws5-o3-p1").val() }, function( data ) {
			  $( "#resultado" ).text( 'El email es  '+ $.xml2json( data ) );
			}
		);
	}
}


function consultaWS6(){
	limpiar();
	loadimage();
	if( $("#ws6-o1").hasClass( "active" ) ){
		$.get( "./Victor/sumar.form", { primero: $("#ws6-o1-p1").val(), segundo:$("#ws6-o1-p2").val() }, function( data ) {
			console.log($.xml2json( data ));
			$( "#resultado" ).text( 'El resultado es: ' + $.xml2json( data ).return );
			}
		);
	}
}

function loadimage(){
	$("#resultado").html('<img src="./img/11.gif" />');
}

function limpiar(){
	$( "#resultado" ).text( "" );
}
