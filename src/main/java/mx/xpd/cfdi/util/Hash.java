package mx.xpd.cfdi.util;

import java.security.MessageDigest;

/**
 * Creates a hash value from a given string.
 * @author Alberto Carlos Calixto Gutierrez
 */
public class Hash {
    
    /**
     * Implements SHA-1 hashing algorithm.
     * @param message The message to be hashed.
     * @return The hash value.
     */ 
    public static String sha1(String message) 
    {
        MessageDigest md;
        byte[] buffer, digest;
        String hash = "";

        try 
        {
            buffer = message.getBytes("UTF-8");
            md = MessageDigest.getInstance("SHA1");
        } 
        catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
        md.update(buffer);
        digest = md.digest();

        for(byte aux : digest) 
        {
            int b = aux & 0xff;
            String s = Integer.toHexString(b);
            if (s.length() == 1) hash += "0";
            hash += s;
        }

        return hash;
    }
}
