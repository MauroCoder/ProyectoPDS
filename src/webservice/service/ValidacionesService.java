package webservice.service;

public interface ValidacionesService {
	public String validarEmail( String email );
	public String validarRUT( int rut, char cv );
	public int getNivelSeguridadPassword( String pass );
}