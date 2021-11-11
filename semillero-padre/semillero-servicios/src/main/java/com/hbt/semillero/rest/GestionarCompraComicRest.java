package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ConsultaLengthNombreComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ConsultarComicTamanioNombreDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * 
 * <b>Descripción:<b> Clase que gestiona la compra de un comic
 * <b>Caso de Uso:<b> 
 * @author mavt9
 * @version
 */
@Path("/gestionarCompraComic")
public class GestionarCompraComicRest {
	
	@EJB
	private IGestionarComicLocal gestionarComicLocal;

	@POST
	@Path("/comprarComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO comprarComic(CompraComicDTO compraComicDTO) {
		ResultadoDTO comicDTOResult = new ComicDTO();
		try {
			
		}  catch (Exception e) {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("El comic seleccionado no cuenta con stock en bodega " + e.getMessage());
		}
		return comicDTOResult;
	}
}
