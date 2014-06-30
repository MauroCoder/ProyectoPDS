package webservice.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ValidacionesServiceImpl implements ValidacionesService {
	private static Logger log = Logger.getLogger( ValidacionesServiceImpl.class );

	@Override
	public String validarEmail(String email) {
		log.debug( "Validando el email: " + email );
        Pattern pattern = Pattern.compile( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" );
        Matcher matcher = pattern.matcher( email );
        boolean valido = matcher.matches();
        log.debug( "Email valido: " + valido );
		return valido ? "VALIDO" : "INVALIDO";
	}

	@Override
	public String validarRUT(int rut, char cv) {
		log.debug( "Validando RUT: " + rut + " -- Caracter Verificador: " + cv );
		int m = 0, s = 1;
        for (; rut != 0; rut /= 10)
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        boolean valido = (cv == (char)( s != 0 ? s + 47 : 75 ) );
        log.debug( "RUT valido: " + valido );
		return valido ? "VALIDO" : "INVALIDO";
	}

	@Override
	public int getNivelSeguridadPassword(String pass) {
		log.debug( "Validando nivel del Password: " + pass );
		int nivel = 0;
		if( !pass.isEmpty() ){
			boolean mayusculas = false;
			boolean minisculas = false;
			boolean digito = false;
			boolean especial = false;
			char c;
			for( int i=0; i<pass.length(); i++ ){
				c = pass.charAt( i );
				if( ( c >= 48 ) && ( c <= 57 ) )
					digito = true;
				else if( ( c >= 65 ) && ( c <= 90 ) )
					mayusculas = true;
				else if( ( c >= 97 ) && ( c <= 122 ) )
					minisculas = true;
				else if( ( c >= 33 ) && ( c <= 126 ) )
					especial = true;
			}
			if( ( mayusculas || minisculas ) && digito )
				nivel += 20;
			if( mayusculas && minisculas )
				nivel += 20;
			if( especial )
				nivel += 30;
			if( ( pass.length() >= 4 ) && ( pass.length() <= 5 ) )
				nivel += 10;
			else if( ( pass.length() >= 6 ) && ( pass.length() <= 8 ) )
				nivel += 20;
			else if( pass.length() >= 9 )
				nivel += 30;
		}
        log.debug( "Nivel del password: " + nivel );
		return nivel;
	}

}
