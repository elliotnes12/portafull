package mx.xpd.cfdi.mvc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.Empleado;
import mx.xpd.cfdi.domain.map.MapEmpleado;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.CatalogoUsoCFDIDao;
import mx.xpd.cfdi.repo.ComprobanteDao;
import mx.xpd.cfdi.repo.EmpleadoDao;
import mx.xpd.cfdi.repo.PaisEstadoDao;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping(value="/empleado")
public class EmpleadoController {
	
	private Logger log = Logger.getLogger(EmpleadoController.class);
	
	private final static String riesgoPuesto = "riesgoPuesto";
	private final static String tipoRegimen = "tipoRegimen";
	private final static String banco = "banco";
	private final static String tipoContrato = "tipoContrato";
	private final static String tipoJornada = "tipoJornada";
	private final static String periodicidadPago = "periodicidadPago";
	
	@Autowired
	private EmpleadoDao empleadoDao;
	@Autowired
	private PaisEstadoDao paisEstadosDao;
	@Autowired
	private ComprobanteDao comprobanteDao;
	@Autowired
	private CatalogoUsoCFDIDao catalogoUsoCFDIDao;
		
	
	@RequestMapping(value="/find/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MapEmpleado> findById(@PathVariable("id") String id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");	
		return empleadoDao.findByRazonSocial(tenantID, id);

    }
	
	@RequestMapping(value="/findID/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody Empleado findById(@PathVariable("id") Long id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");	
		return empleadoDao.find(tenantID, id);
    }

	
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model, HttpServletRequest request) {
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		Empleado empleado = new Empleado();
		
		String msg = (String)request.getParameter("msg");
		String error = (String)request.getParameter("error");
		
		if(msg != null && msg.length() > 0) {
			model.addAttribute("msg", msg);
			model.addAttribute("error", error);
		}
		model.addAttribute("empleado", empleado);
		model.addAttribute("empleados", empleadoDao.find(tenantID));
		
		model.addAttribute("regimenContratacion", comprobanteDao.findCatalogoNomina(tipoRegimen));
		model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogoNomina(riesgoPuesto));
		model.addAttribute("banco", comprobanteDao.findCatalogoNomina(banco));
		model.addAttribute("tipoContrato", comprobanteDao.findCatalogoNomina(tipoContrato));
		model.addAttribute("tipoJornada", comprobanteDao.findCatalogoNomina(tipoJornada));
		model.addAttribute("periodicidadPago", comprobanteDao.findCatalogoNomina(periodicidadPago));
		model.addAttribute("periodicidadPago", comprobanteDao.findCatalogoNomina(periodicidadPago));
		model.addAttribute("claveEntFed", paisEstadosDao.findAllEstado());
		model.addAttribute("usosCFDI", catalogoUsoCFDIDao.findAll());
		model.addAttribute("tenant_id", tenantID);
		
		return "empleado/mostrar";
	}
	
		
	
	
	@RequestMapping(value="/subirEmpleados", method=RequestMethod.POST)
	public String editar(Model model, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		log.info(file.getOriginalFilename().toLowerCase());
		ByteArrayOutputStream st = new ByteArrayOutputStream();
		InputStream isFile = null;
		FileOutputStream output_file = null; 
		FileInputStream inputDocument = null; 
		
		Empleado empleado = null;
		int totalFilas = 0;
		int index = 0;
		
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		Cell cell = null;
		Iterator<Row> rowIterator = null;
		
				
		HSSFWorkbook wb = null;
        HSSFSheet sheet2 = null;	    
	    Row row = null;
		
		
	    // Errores	    
	    XSSFWorkbook wError = null;
	    CellStyle style = null;
	    CellStyle newCell = null;
	    
	    XSSFCellStyle style2 = null;
	    
	    Date fechaIni = null;
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			inputDocument = (FileInputStream) file.getInputStream();
			
			IOUtils.copy(file.getInputStream(), st);
			
			isFile = new ByteArrayInputStream(st.toByteArray());
			
			if(file.getOriginalFilename().endsWith("xlsx")) {
				
				System.out.println(file.getOriginalFilename());
				workbook = new XSSFWorkbook(isFile);
				wError = new XSSFWorkbook(inputDocument);
				
				style = wError.createCellStyle();
				newCell = wError.createCellStyle();
				style2 = wError.createCellStyle();
				
				style2.setFillForegroundColor(IndexedColors.RED.getIndex());
				style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
				
				//style.setFillBackgroundColor(IndexedColors.RED.getIndex());
				style.setFillForegroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				
				//sheet = workbook.getSheetAt(1);					
				sheet = wError.getSheetAt(1);
				
				rowIterator = sheet.iterator();
				
				
				if(!rowIterator.hasNext()) {
					return "redirect:/empleado/";
				}
				
				index = 0;
				
				rowIterator.next(); 
				rowIterator.next(); 
				
				index = 3;
				int errores = 0;
				int globalErrors = 0;
				
				while(rowIterator.hasNext()) {
					
					log.info("[Leyendo fila " + index + "]");
			    	
			    	String d;
					row = rowIterator.next();
									
					empleado = new Empleado();
												    
					empleado.setTenantId(tenantID);
										
					// antiguedad
					cell = row.getCell(0);					
					if(cell != null) {
						d = cell.toString();
						if (d != null && !d.equals("")) {
							empleado.setAntiguedad(d);
						}
					}
						
					// banco
					cell = row.getCell(1);
					if (cell != null) {
						d = cell.toString();
						if (d != null && !d.equals("")) {
							d = cell.toString().trim().substring(0,3);
							empleado.setBanco(d);
						}
					}
						
					// clabe
					cell = row.getCell(2);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						empleado.setCuentaBancaria(cell.toString());
					}
					
					
					// curp obligatorio --------------------------------------------------------------------------------
					cell = row.getCell(3);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						empleado.setCurp(cell.toString());
						if(!validaCurp(empleado.getCurp())) {
							errores++;
							cell.setCellStyle(style);
						}
					} else {
						errores++;
						row.createCell(3).setCellStyle(style);
						break;
					}
					
					// departamento
					cell = row.getCell(4);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						empleado.setDepartamento(cell.toString());
					}
					
					
					// fechaInicioRelLaboral
					cell = row.getCell(5);
					if (cell != null) {
						d = cell.toString();
						if (d != null && !d.equals("")) {
							empleado.setFechaInicioRelLaboral(cell == null ? null : sdf.format(cell.getDateCellValue()));
						}
					}
					
	
					
					// numDiasPagados obligatorio -----------------------------------------------------------------------
					cell = row.getCell(6);
					if(cell != null) {
						d = cell.toString().trim();
						if (d != null && !d.equals("")) {
							empleado.setNumDiasPagados(new Double(d));
						} else {
							errores++;
							cell.setCellStyle(style);
						}
					} else {
						errores++;
						cell = row.createCell(6);
						cell.setCellStyle(style);
					}
					
					// numEmpleado obligatorio ---------------------------------------------------------------------------
					cell = row.getCell(7);
					if(cell != null) {
						d = cell.toString().trim();
						if (d != null  && !d.equals("")) {
							empleado.setNumEmpleado(String.format("%03d",(new Double(d).intValue())));
						} else {
							errores++;
							cell.setCellStyle(style);
						}
					} else {
						errores++;
						row.createCell(7).setCellStyle(style);
					}
					
					// numSeguridadSocial
					cell = row.getCell(8);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						empleado.setNumSeguridadSocial(cell.toString());
					}
					
					// periodicidadPago obligatorio -----------------------------------------------------------------------
					cell = row.getCell(9);
					if(cell != null) {
						d = cell.toString().trim().substring(0,2);
						if (d != null && !d.equals("")) {
							empleado.setPeriodicidadPago(""+d);
						}
					} else {
						errores++;
						row.createCell(9).setCellStyle(style);
					}
					
				    // puesto
					cell = row.getCell(10);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						empleado.setPuesto(cell.toString());
					}
					
						
					// riesgoPuesto
					cell = row.getCell(11);
					if (cell != null) {
						d = cell.toString();
						if (d != null && !d.equals("")) {
							d = cell.toString().trim().substring(0,1);
							if (d != null && !d.equals("")) {
								empleado.setRiesgoPuesto(d);
							}
						}
					}
					
					// salarioBaseCotApor
					cell = row.getCell(12);
					if(cell != null) {
						d = cell.toString().trim();
						if (d != null && !d.equals("")) {
							empleado.setSalarioBaseCotApor(new Double(d));
						}
					}
					
					// salarioDiarioIntegrado
					cell = row.getCell(13);
					if(cell != null) {
						d = cell.toString().trim();
						if (d != null && !d.equals("")) {
							empleado.setSalarioDiarioIntegrado(new Double(d));
						}
					}
					
					
					// tipoContrato
					cell = row.getCell(14);
					if(cell != null ) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						d = cell.toString().trim().substring(0,2);
						if (d != null && !d.equals("")) {
							empleado.setTipoContrato(d);
						}
					}
					
					
					// tipoJornada
					cell = row.getCell(15);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						d = cell.toString().trim().substring(0,2);
						if (d != null && !d.equals("")) {
							empleado.setTipoJornada(d);
						}
					}
					
					
					// tipoRegimen obligatorio --------------------------------------------------------------------------
					cell = row.getCell(16);
					if(cell != null && !cell.toString().equals("")) {
						d = cell.toString().trim().substring(0,2);
						if (d != null && !d.equals("")) {
							empleado.setTipoRegimen(d);
						} else {
							errores++;
							cell.setCellStyle(style);
						}
					} else {
						errores++;
						row.createCell(16).setCellStyle(style);
					}
					
					// nombre
					cell = row.getCell(17);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						empleado.setNombre(cell.toString());
					}
					
					
					// rfc obligatorio -----------------------------------------------------------------------------------
					cell = row.getCell(18);
					if(cell != null) {
						empleado.setRfc(cell.toString());
						if(!validaRfc(empleado.getRfc())){
							errores++;
							cell.setCellStyle(style);
						}
					} else {
						errores++;
						row.createCell(18).setCellStyle(style);
					}
					
					// email
					cell = row.getCell(19);
					if(cell != null) {
						empleado.setEmail(cell.toString());
					}
					
					// entidad Federativa obligatorio --------------------------------------------------------------------------
					cell = row.getCell(20);
					if(cell != null && !cell.toString().equals("")) {
						d = cell.toString().trim();
						d = d.substring(0, d.indexOf(" "));
						if (d != null && !d.equals("")) {
							empleado.setClaveEntFed(d);
						} else {
							errores++;
							cell.setCellStyle(style);
						}
					} else {
						errores++;
						row.createCell(20).setCellStyle(style);
					}
					
					// sindicalizado
					cell = row.getCell(21);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						d = cell.toString().trim();
						if (d != null && !d.equals("")) {
							empleado.setSindicalizado(d);
						}
					}
					
					// uso cfdi
					cell = row.getCell(22);
					if(cell != null) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						d = cell.toString().trim();
						d = d.substring(0, d.indexOf(" "));
						if (d != null && !d.equals("")) {
							empleado.setUsoCFDI(d);
						} else {
							errores++;
							cell.setCellStyle(style);
						}
					} else {
						errores++;
						row.createCell(22).setCellStyle(style);
					}

					
					totalFilas++;
					
					if(totalFilas%10 == 0) {
						log.info("Filas leidas: " + totalFilas );
					}
					
					log.info("Guardando Empleado...");				
					
					
					// Antes de generar un nuevo empleado verificar que el empleado de la lista no exista en la base de datos y que no contenga errores en el excel
					
					if(!empleadoDao.exists(tenantID, empleado.getNumEmpleado(), empleado.getRfc(), empleado.getCurp()) && errores == 0) {
					
						empleadoDao.add(empleado);
						
						log.info("Empleado guardado con exito");
					
					} else {
						
						log.info("[ tenantID " + tenantID + " numEmpleado " + empleado.getNumEmpleado() + " RFC " + empleado.getRfc() + " CURP " + empleado.getCurp() + " existe o tiene errores ]");
						
					}
			    	
			    	index++;
			
			    	log.info( "[Se econtraron " + errores + " errores en la fila " + totalFilas + "]");
			    	
			    	globalErrors += errores;
			    	errores = 0;
			    }
				
				// cerrores.clear();
				
				if(globalErrors > 0) {
					
					log.info("[Se encontraron " + globalErrors +" errores en el documento " + file.getOriginalFilename() + " ]");
					
					inputDocument.close();
					
					
					// Escribir en excel
					output_file = new FileOutputStream(new File("/home/cfdi/tmp/"+tenantID+".xlsx"));
	                // write changes
					wError.write(output_file);
	                // close the stream
	                output_file.close();
	                
	                request.setAttribute("totalErroresEmpleado", globalErrors);
	                request.setAttribute("totalRegistrosEmpleado", index-5);
				}
				
			} else {
				
				System.out.println(file.getOriginalFilename());
				wb = new HSSFWorkbook(isFile);
				sheet2 = wb.getSheetAt(1);
				rowIterator = sheet2.iterator();
				if(!rowIterator.hasNext()) {
					return "redirect:/empleado/";
				}
				
				index = 0;
				
				// Primeras filas son titulos
		    	rowIterator.next();
		    	rowIterator.next();
		    	
				while(rowIterator.hasNext()) {
					
			    	// Comienzan los datos de empleados
			    	row = rowIterator.next();			    	
			    	
			    	
			    	System.out.println(index);
			    }
				
			}			
		
		} catch (IOException e) {
			
			log.error(e);
			e.printStackTrace();
		}		
		
		return listar(model, request);
	}
	
	private boolean validaCurp(String curp) {
		curp=curp.toUpperCase().trim();
		return curp.matches("[A-Z][A,E,I,O,U,X][A-Z]{2}[0-9]{2}[0-1][0-9][0-3][0-9][M,H][A-Z]{2}[B,C,D,F,G,H,J,K,L,M,N,Ñ,P,Q,R,S,T,V,W,X,Y,Z]{3}[0-9,A-Z][0-9]");
	}
	
	private boolean validaRfc(String rfc) {
		rfc=rfc.toUpperCase().trim();
		return rfc.matches("[A-Z,Ñ,&]{3,4}[0-9]{2}[0-1][0-9][0-3][0-9][A-Z,0-9]?[A-Z,0-9]?[0-9,A-Z]?");
	}
	
	private XSSFWorkbook crearRespuesta() {
		XSSFWorkbook workBook = null;
		try {
			workBook = new XSSFWorkbook(new FileInputStream("/home/cfdi/files/layout.xlsx"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
		return workBook;
	}
	
	@RequestMapping(value = "/errores" ,method = RequestMethod.GET)
	public void errores(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=sample.xlsx");
		
		Path xls = Paths.get("/home/cfdi/tmp/" + tenantID + ".xlsx");
		
		byte []data = Files.readAllBytes(xls);
		response.getOutputStream().write(data);
		
	}

	@RequestMapping(value="/agregar", method = RequestMethod.POST)
	public String Agregar( @Valid @ModelAttribute("empleado") Empleado nuevoEmpleado, BindingResult result, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		if (!result.hasErrors()) {
			empleadoDao.add(nuevoEmpleado);
			String url = "";
			String msg = "Empleado guardado correctamente";
			String error = "0";
			url = "?msg=" + msg + "&error=" + error;
		return "redirect:/empleado/" + url;
		}else {
			model.addAttribute("empleados", empleadoDao.find(tenantID));
			return "empleado/mostrar";
		}
	}
	
	@RequestMapping(value="/detalle/{id}", method=RequestMethod.GET)
	public String detalle(@PathVariable Long id, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		Empleado empleado = empleadoDao.find(tenantID, id);
		if (empleado == null) {
			return "redirect:/empleado/";
		}
		model.addAttribute("empleado", empleado);
		model.addAttribute("regimenContratacion", comprobanteDao.findCatalogoNomina(tipoRegimen));
		model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogoNomina(riesgoPuesto));
		model.addAttribute("banco", comprobanteDao.findCatalogoNomina(banco));
		model.addAttribute("tipoContrato", comprobanteDao.findCatalogoNomina(tipoContrato));
		model.addAttribute("tipoJornada", comprobanteDao.findCatalogoNomina(tipoJornada));
		model.addAttribute("periodicidadPago", comprobanteDao.findCatalogoNomina(periodicidadPago));
		model.addAttribute("claveEntFed", paisEstadosDao.findAllEstado());
		model.addAttribute("usosCFDI", catalogoUsoCFDIDao.findAll());
		return "empleado/detalle";
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable Long id, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		Empleado empleado = empleadoDao.find(tenantID,id);
		if (empleado == null) {
			return "redirect:/empleado/";
		}
		
		model.addAttribute("empleado", empleado);
		model.addAttribute("regimenContratacion", comprobanteDao.findCatalogoNomina(tipoRegimen));
		model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogoNomina(riesgoPuesto));
		model.addAttribute("banco", comprobanteDao.findCatalogoNomina(banco));
		model.addAttribute("tipoContrato", comprobanteDao.findCatalogoNomina(tipoContrato));
		model.addAttribute("tipoJornada", comprobanteDao.findCatalogoNomina(tipoJornada));
		model.addAttribute("periodicidadPago", comprobanteDao.findCatalogoNomina(periodicidadPago));
		model.addAttribute("claveEntFed", paisEstadosDao.findAllEstado());
		model.addAttribute("usosCFDI", catalogoUsoCFDIDao.findAll());
		return "empleado/editar";
	}
		
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("empleado") Empleado empleado, BindingResult result, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		empleadoDao.update(empleado);
		return "redirect:/empleado/";
	}
	
}
