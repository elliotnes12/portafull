package mx.xpd.cfdi.mvc;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/sync")
public class SyncController {

	@Secured ("ROLE_ANNONYMOUS") 
	@RequestMapping(value="/", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody String index() {
		return "1";
	}
	
	@Secured("permitAll")
	@RequestMapping(value="/clientes/{rfc}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody String clientes(@PathVariable("rfc") String rfc) {
		return rfc;
	}
	
}
