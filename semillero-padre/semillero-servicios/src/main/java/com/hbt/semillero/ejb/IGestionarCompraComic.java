package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.dto.ConsultaLengthNombreComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 * 
 * <b>Descripción:<b> Clase interface que gestiona la compro de un comic
 * <b>Caso de Uso:<b> 
 * @author mavt9
 * @version
 */
@Local
public interface IGestionarCompraComic {
	public ResultadoDTO comprarComic(CompraComicDTO compraComicDTO) throws Exception;
}
