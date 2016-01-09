package main.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * Clase de prueba que utiliza la librería {@link MessageDigest} de java para la
 * encriptación de una entrada dada
 *
 * @author Yohanna Lisnichuk
 * @since 1.0
 * @version 1.0 9/1/2016
 *
 */
public class EncryptExample {

    /***
     *
     * Convierte un arreglo de bytes a String usando valores hexadecimales
     *
     * @param digest
     *            arreglo de bytes a convertir
     *
     * @return String creado a partir de <code>digest</code>
     */

    private static String toHexadecimal(byte[] digest) {

        String hash = "";

        for (byte aux : digest) {

            int b = aux & 0xff;

            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }

            hash += Integer.toHexString(b);

        }

        return hash;

    }

    /***
     * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje. Es
     * una clase estática ya que para que pueda ser un procedimiento pljava el
     * método debe ser estático y retornar null si cualquier parametro de
     * entrada recibido es null
     *
     *
     * @param message
     *            texto a encriptar
     * @param algorithm
     *            algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1,
     *            SHA-256, SHA-384, SHA-512
     * @return mensaje encriptado
     */
    public static String getStringMessageDigest(String message, String algorithm) {

        if (message == null || algorithm == null) {
            return null;
        }
        byte[] digest = null;

        byte[] buffer = message.getBytes();

        try {

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            messageDigest.reset();

            messageDigest.update(buffer);

            digest = messageDigest.digest();

        } catch (NoSuchAlgorithmException ex) {

            System.out.println("Error creando Digest");

        }

        return toHexadecimal(digest);

    }
}
