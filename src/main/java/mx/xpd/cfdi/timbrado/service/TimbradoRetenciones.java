package mx.xpd.cfdi.timbrado.service;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;

import javax.activation.DataHandler;

import org.apache.axiom.attachments.ByteArrayDataSource;
import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub.RespuestaTimbrado;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub.Timbrar;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub.TimbrarE;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub.TimbrarResponse;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub.TimbrarResponseE;

public class TimbradoRetenciones {
	
	private Logger log = LoggerFactory.getLogger(Timbrado.class);
	
	private String usuario;
	private String password;
	private String endPoint;

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RespuestaTimbrado timbrarFactura(String xml)  {
		RespuestaTimbrado respuesta = null;
		try {
			TimbradoWSServiceStub stub = new TimbradoWSServiceStub(this.getEndPoint());
			Timbrar t = new Timbrar();
			DataHandler dh = new DataHandler(new ByteArrayDataSource(xml.getBytes()));
			
			t.setUsuario(this.getUsuario());
			t.setContrasena(this.getPassword());
			t.setCfdi(dh);
			
			TimbrarE tE = new TimbrarE();
			tE.setTimbrar(t);
			
			TimbrarResponseE responseE = stub.timbrar(tE);
			TimbrarResponse response = responseE.getTimbrarResponse();
			respuesta = response.get_return();
			
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return respuesta;
	}

}
