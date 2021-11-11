package com.hbt.semillero.dto;

import java.util.ArrayList;

/**
 * <b>Descripción:<b> Clase que guarda los nombres de los comics que superan o no el valor
 * 					  del parametro lengthComic.
 * @author mavt9
 * @version
 */
public class ConsultarComicTamanioNombreDTO extends ResultadoDTO{
	
	ArrayList<String> ListaComicsSuperan; 
	ArrayList<String> ListaComicsNoSuperan;
	
	public ArrayList<String> getListaComicsSuperan() {
		return ListaComicsSuperan;
	}
	public void setListaComicsSuperan(ArrayList<String> listaComicsSuperan) {
		ListaComicsSuperan = listaComicsSuperan;
	}
	public ArrayList<String> getListaComicsNoSuperan() {
		return ListaComicsNoSuperan;
	}
	public void setListaComicsNoSuperan(ArrayList<String> listaComicsNoSuperan) {
		ListaComicsNoSuperan = listaComicsNoSuperan;
	} 	
}
