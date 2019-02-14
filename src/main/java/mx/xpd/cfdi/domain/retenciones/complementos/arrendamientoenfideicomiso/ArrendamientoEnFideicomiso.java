package mx.xpd.cfdi.domain.retenciones.complementos.arrendamientoenfideicomiso;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Arrendamientoenfideicomiso")
public class ArrendamientoEnFideicomiso {

	private String version = "1.0";
	private String pagProvEfecPorFiduc;
	private String rendimFideicom;
	private String deduccCorresp;
	private String montTotRetArr;
	private String montResFiscDistFibras;
	private String montOtrosConceptDistr;
	private String descrMontOtrosConceptDistr;
	
	public ArrendamientoEnFideicomiso() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "PagProvEfecPorFiduc")
	public String getPagProvEfecPorFiduc() {
		return pagProvEfecPorFiduc;
	}

	public void setPagProvEfecPorFiduc(String pagProvEfecPorFiduc) {
		this.pagProvEfecPorFiduc = pagProvEfecPorFiduc;
	}

	@XmlAttribute(name = "RendimFideicom")
	public String getRendimFideicom() {
		return rendimFideicom;
	}

	public void setRendimFideicom(String rendimFideicom) {
		this.rendimFideicom = rendimFideicom;
	}

	@XmlAttribute(name = "DeduccCorresp")
	public String getDeduccCorresp() {
		return deduccCorresp;
	}

	public void setDeduccCorresp(String deduccCorresp) {
		this.deduccCorresp = deduccCorresp;
	}

	@XmlAttribute(name = "MontTotRet")
	public String getMontTotRetArr() {
		return montTotRetArr;
	}

	public void setMontTotRetArr(String montTotRetArr) {
		this.montTotRetArr = montTotRetArr;
	}

	@XmlAttribute(name = "MontResFiscDistFibras")
	public String getMontResFiscDistFibras() {
		return montResFiscDistFibras;
	}

	public void setMontResFiscDistFibras(String montResFiscDistFibras) {
		this.montResFiscDistFibras = montResFiscDistFibras;
	}

	@XmlAttribute(name = "MontOtrosConceptDistr")
	public String getMontOtrosConceptDistr() {
		return montOtrosConceptDistr;
	}

	public void setMontOtrosConceptDistr(String montOtrosConceptDistr) {
		this.montOtrosConceptDistr = montOtrosConceptDistr;
	}

	@XmlAttribute(name = "DescrMontOtrosConceptDistr")
	public String getDescrMontOtrosConceptDistr() {
		return descrMontOtrosConceptDistr;
	}

	public void setDescrMontOtrosConceptDistr(String descrMontOtrosConceptDistr) {
		this.descrMontOtrosConceptDistr = descrMontOtrosConceptDistr;
	}


	
}
