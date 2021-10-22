package com.hbt.semillero.enums;
/**
 * 
 * <b>Descripción:<b> Clase que determina el enum de estado para determinar si es activo o inactivo
 * <b>Caso de Uso:<b> hbt semillero
 * @author Manuel Vallejo
 * @version
 */
public enum EstadoEnum{
	
	ACTIVO("enum.estado.activo"), 
	INACTIVO("enum.estado.inactivo");
	
	
	/**
	 * Atributo que determina el estado de un comic
	 */
	private String estado;

	/**
	 * Constructor que recibe como parametro el estado de un comic
	 * 
	 * @param estado, define el estado de un comic
	 */
	EstadoEnum(String estado) {
		this.estado = estado;
	}

	/**
	 * Metodo que retorna el valor del estado de un comic
	 * @return El estado del comic
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Metodo que modifica el valor del estado de un comic
	 * @param estado El nuevo estado de un comic.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	

}
