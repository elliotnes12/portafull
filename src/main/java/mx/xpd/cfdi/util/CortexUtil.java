package mx.xpd.cfdi.util;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;

public class CortexUtil {
private String iv = "aaaaaaaaaaaaaaaa";// Dummy iv (CHANGE IT!)
private IvParameterSpec ivspec;
private SecretKeySpec keyspec;
private Cipher cipher;

private String SecretKey = "bbbbbbbbbbbbbbbb";// Dummy secretKey (CHANGE
                                                // IT!)

public CortexUtil() {
    ivspec = new IvParameterSpec(iv.getBytes());

    keyspec = new SecretKeySpec(SecretKey.getBytes(), "AES");

    try {
        cipher = Cipher.getInstance("AES/CBC/NoPadding");
    } catch (NoSuchAlgorithmException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (NoSuchPaddingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public String encrypt(String text) throws Exception {
    if (text == null || text.length() == 0)
        throw new Exception("Empty string");
    text = new String(Base64.encodeBase64(text.getBytes("UTF-8")));
    byte[] encrypted = null;

    try {
        cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);

        encrypted = cipher.doFinal(padString(text).getBytes());
    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception("[encrypt] " + e.getMessage());
    }

    return bytesToHex(encrypted);
}

public String decrypt(String code) throws Exception {
    if (code == null || code.length() == 0)
        throw new Exception("Empty string");

    byte[] decrypted = null;

    try {
        cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

        decrypted = cipher.doFinal(hexToBytes(code));
    } catch (Exception e) {
        throw new Exception("[decrypt] " + e.getMessage());
    }
    return new String(Base64.decodeBase64(decrypted), "UTF-8");
}

public static String bytesToHex(byte[] data) {
    if (data == null) {
        return null;
    }

    int len = data.length;
    String str = "";
    for (int i = 0; i < len; i++) {
        if ((data[i] & 0xFF) < 16)
            str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
        else
            str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
    }
    return str;
}

public static byte[] hexToBytes(String str) {
    if (str == null) {
        return null;
    } else if (str.length() < 2) {
        return null;
    } else {
        int len = str.length() / 2;
        byte[] buffer = new byte[len];
        for (int i = 0; i < len; i++) {
            buffer[i] = (byte) Integer.parseInt(
                    str.substring(i * 2, i * 2 + 2), 16);
        }
        return buffer;
    }
}


private static String padString(String source) {
    char paddingChar = ' ';
    int size = 16;
    int x = source.length() % size;
    int padLength = size - x;

    for (int i = 0; i < padLength; i++) {
        source += paddingChar;
    }

    return source;
}

public static void main(String []args) throws Exception {
    String tenant = "CCC1007293K1";

    CortexUtil c = new CortexUtil();
    String enc = c.encrypt(tenant);
    System.out.println(enc);
    System.out.println(c.decrypt(enc));
}
} 