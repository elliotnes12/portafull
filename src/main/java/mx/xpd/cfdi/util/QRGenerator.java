package mx.xpd.cfdi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRGenerator {

	private static Logger log = LoggerFactory.getLogger(QRGenerator.class);
	
	public static InputStream getQR(String textQR) {
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bitMatrix = null;
		InputStream in = new ByteArrayInputStream(new byte[0]);
		try {
			bitMatrix = writer.encode(textQR, BarcodeFormat.QR_CODE, 300, 300);
		    ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		    MatrixToImageWriter.writeToStream(bitMatrix, "png", out);
		    in = new ByteArrayInputStream(out.toByteArray());
		} catch(Exception e) {
			in = new ByteArrayInputStream(new byte[0]);
			e.printStackTrace();
		}
		return in;
	}
}
