package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.QueryParam;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.dto.ConsultaLengthNombreComicDTO;
import com.hbt.semillero.dto.ConsultaNombrePrecioComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;

/**
 * 
 * <b>Descripción:<b> Clase que gestiona metodo para compra del comic
 * <b>Caso de Uso:<b> 
 * @author mavt9
 * @version
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic {
	
	@PersistenceContext
	public EntityManager em;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO comprarComic(CompraComicDTO compraComicDTO) throws Exception {
		String consulta = "SELECT cm from Comic cm WHERE cm.id = :idComic ";
		Comic comic = new Comic();
		ResultadoDTO resultado = new ResultadoDTO();
		try {
			Query consultaNativa = em.createQuery(consulta);
			consultaNativa.setParameter("idComic", compraComicDTO.getId());
			if (comic.getCantidad() >= compraComicDTO.getCantidad()) {
				if (comic.getEstadoEnum().equals(EstadoEnum.ACTIVO)){
					comic.setCantidad(comic.getCantidad() - compraComicDTO.getCantidad());
					comic.setFechaVenta(LocalDate.now());
					if(comic.getCantidad() == compraComicDTO.getCantidad()) {
						comic.setEstadoEnum(EstadoEnum.INACTIVO);
					}
					em.merge(comic);
					resultado.setExitoso(true);
					resultado.setMensajeEjecucion("La compra del comic nombreComic fue exitosa");
				}else {
					throw new Exception("El comic seleccionado no cuenta con stock en bodega ");
				}
			}else {
				throw new Exception("La cantidad existente del comic es: " + comic.getCantidad() + ", y supera la ingresada ");
			}
		} catch (Exception e) {
			  resultado.setExitoso(false);
			  resultado.setMensajeEjecucion("Fallo la compra: " + e.getMessage());
			  return resultado;
		}
		return resultado;
	}
}
