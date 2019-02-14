package mx.xpd.cfdi.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

@RequestMapping(value = "/comprobante")
public class EmitirController {

	@RequestMapping(value = "/emitir/{tipoComprobante}", method = RequestMethod.GET)
	public String emitir() {
		return "comprobante/emitir";
	}
	
}
