package semillero.pruebasUnitarias;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.enums.TematicaEnum;

import junit.framework.Assert;

/**
 * 
 * <b>Descripción:<b> Clase de pruebas unitarias para la creacion de comics
 * <b>Caso de Uso:<b> hbt semillero
 * 
 * @author Manuel Vallejo
 * @version
 */
public class CreacionComicTest {

	private final static Logger log = Logger.getLogger(CreacionComicTest.class);

	/**
	 * Atributo que determina la lista de comics
	 */
	public ArrayList<ComicDTO> listaComic = new ArrayList<>();
	public ArrayList<ComicDTO> listaComicActivos;
	public ArrayList<ComicDTO> listaComicInactivos;

	/**
	 * Metodo encargado de inicializar pruebas 
	 */
	@BeforeTest
	public void inicializar() {
		if (listaComic.isEmpty()) {
			llenarComic();
		}
		this.listaComicActivos = separarActivos();
		this.listaComicInactivos = separarInactivos();
		BasicConfigurator.configure();// inicializa el logger con una config basica
		log.info(":::::::::INICIAN PRUEBAS UNITARIAS:::::::::");
	}

	/**
	 * Metodo encargado de retornar el array de comics activos
	 */
	private ArrayList<ComicDTO> separarActivos() {
		ArrayList<ComicDTO> listaTemp = new ArrayList<>();
		for (ComicDTO comicDTO : listaComic) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.ACTIVO) {
				listaTemp.add(comicDTO);
			}
		}
		return listaTemp;
	}

	/**
	 * Metodo encargado de retornar el array de comics inactivos
	 */
	private ArrayList<ComicDTO> separarInactivos() {
		ArrayList<ComicDTO> listaTemp = new ArrayList<>();
		for (ComicDTO comicDTO : listaComic) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) {
				listaTemp.add(comicDTO);
			}
		}
		return listaTemp;
	}

	private void llenarComic() {
		/**
		 * Metodo que llena el array de comics
		 */
		LocalDate localDate = LocalDate.now();

		
		ComicDTO comic01 = new ComicDTO(01L, "One Piece", "editorial", TematicaEnum.AVENTURAS, "coleccion", 1000,
				new BigDecimal(10000000), "autor", true, localDate, EstadoEnum.ACTIVO, 1000L);
		ComicDTO comic02 = new ComicDTO(02L, "Hunter X Hunter", "editorial", TematicaEnum.AVENTURAS, "coleccion", 100,
				new BigDecimal(9000000), "autor", true, localDate, EstadoEnum.INACTIVO, 900L);
		ComicDTO comic03 = new ComicDTO(03L, "Dragon Ball Z", "editorial", TematicaEnum.DEPORTIVO, "coleccion", 200,
				new BigDecimal(8000000), "autor", true, localDate, EstadoEnum.ACTIVO, 800L);
		ComicDTO comic04 = new ComicDTO(04L, "Fairy Tail", "editorial", TematicaEnum.FANTASTICO, "coleccion", 300,
				new BigDecimal(7000000), "autor", true, localDate, EstadoEnum.INACTIVO, 700L);
		ComicDTO comic05 = new ComicDTO(05L, "Eigthy six", "editorial", TematicaEnum.HISTORICO, "coleccion", 350,
				new BigDecimal(6000000), "autor", true, localDate, EstadoEnum.ACTIVO, 600L);
		ComicDTO comic06 = new ComicDTO(06L, "Nanatsu no taizai", "editorial", TematicaEnum.AVENTURAS, "coleccion", 250,
				new BigDecimal(5000000), "autor", false, localDate, EstadoEnum.INACTIVO, 500L);
		ComicDTO comic07 = new ComicDTO(07L, "Dororo", "editorial", TematicaEnum.AVENTURAS, "coleccion", 150,
				new BigDecimal(4000000), "autor", false, localDate, EstadoEnum.ACTIVO, 400L);
		ComicDTO comic08 = new ComicDTO(10L, "High School of the Dead", "editorial", TematicaEnum.DEPORTIVO, "coleccion", 50,
				new BigDecimal(3000000), "autor", false, localDate, EstadoEnum.INACTIVO, 300L);
		ComicDTO comic09 = new ComicDTO(11L, "Full Metal Alchemist", "editorial", TematicaEnum.HISTORICO, "coleccion", 25,
				new BigDecimal(2000000), "autor", false, localDate, EstadoEnum.ACTIVO, 200L);
		ComicDTO comic10 = new ComicDTO(12L, "Akame Ga Kill", "editorial", TematicaEnum.CIENCIA_FICCION, "coleccion",
				40, new BigDecimal(1000000), "autor", false, localDate, EstadoEnum.INACTIVO, 100L);
		
		/**
		 * añade los comics al array
		 */
		
		listaComic.add(comic01);
		listaComic.add(comic02);
		listaComic.add(comic03);
		listaComic.add(comic04);
		listaComic.add(comic05);
		listaComic.add(comic06);
		listaComic.add(comic07);
		listaComic.add(comic08);
		listaComic.add(comic09);
		listaComic.add(comic10);
		
	}

	/**
	 * Metodo encargado de validar los comics activos
	 */
	@Test
	public void validarActivos() {

		log.info("Inicia ejecucion del metodo validarActivos()");

		Assert.assertNotNull(listaComicActivos);
		for (ComicDTO comicDTO : listaComicActivos) {
			if (comicDTO.getEstadoEnum() == EstadoEnum.ACTIVO) {
				System.out.println(comicDTO.toString());
			}
		}

		log.info("Finaliza la ejecucion del metodo validarActivos()");
	}

	@Test
	public void validarInactivos() {

		log.info("Inicia ejecucion del metodo validarInactivos()");
		ArrayList<String> lstTemp = new ArrayList<>();
		
		Assert.assertNotNull(lstTemp);
		try {
			
			for (ComicDTO comicDTO : listaComicInactivos) {
				if (comicDTO.getEstadoEnum() == EstadoEnum.INACTIVO) {
					lstTemp.add(comicDTO.getNombre());
				}
			}	
			
			throw new Exception("Se genero una excepcion");				
			
		} catch (Exception e) {
			Assert.assertEquals(e.getMessage(),"Se genero una excepcion");
			System.out.println("Se ha detectado que de " + listaComic.size() + " comics se encontraron que "
					+ listaComicActivos.size() + " se encuentran activos y " + listaComicInactivos.size()
					+ " inactivos. Los comics inactivos son:" + lstTemp.toString());
		}

		log.info("Finaliza la ejecucion del metodo validarInactivos()");
	}

	@AfterTest
	public void finalizaPruebasUnitarias() {
		log.info(":::::::::FINALIZA PRUEBAS UNITARIAS:::::::::");
	}
}
