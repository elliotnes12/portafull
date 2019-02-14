package mx.xpd.cfdi.mvc;

import mx.xpd.cfdi.repo.RegimenFiscalDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/rest/regimenFiscal")
public class RegimenFiscalRestController
{	
    @Autowired
    private RegimenFiscalDao regimenFiscalDao;

    @RequestMapping(value="/eliminar/{id}", method=RequestMethod.GET)
    public @ResponseBody boolean eliminar(@PathVariable("id") Long id) {
		return regimenFiscalDao.remove(id);
    }
    
    @RequestMapping(value="/existe/{clave}", method=RequestMethod.GET)
    public @ResponseBody Boolean existe(@PathVariable("clave") String clave) {
		if (regimenFiscalDao.findByClave(clave) != null) {
			return true;
		}  
		return false;
    }	
    
}
