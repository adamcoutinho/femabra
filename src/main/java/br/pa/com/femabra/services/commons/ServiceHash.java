package br.pa.com.femabra.services.commons;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@Service
public class ServiceHash {

    public static String apply(String word) {

//
//        System.out.println(stringHexa(gerarHash(word, "MD5")));
//        System.out.println(stringHexa(gerarHash(word, "SHA-1")));
//        System.out.println(stringHexa(gerarHash(word, "SHA-256")));


        return stringHexa(gerarHash(word, "SHA-256"));
    }

    private static String stringHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) s.append('0');
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }
    public static byte[] gerarHash(String frase, String algoritmo) {
        try {
            MessageDigest md = MessageDigest.getInstance(algoritmo);
            md.update(frase.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
