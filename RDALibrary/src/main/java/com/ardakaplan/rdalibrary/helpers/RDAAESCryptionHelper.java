package com.ardakaplan.rdalibrary.helpers;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class RDAAESCryptionHelper {

    //RDAAESCryptionHelper-ObjC uses CBC and PKCS7Padding
    private static final String AES_MODE = "AES/CBC/PKCS7Padding";
    private static final String CHARSET = "UTF-8";

    //RDAAESCryptionHelper-ObjC uses SHA-256 (and so a 256-bit key)
    private static final String HASH_ALGORITHM = "SHA-256";

    //RDAAESCryptionHelper-ObjC uses blank IV (not the best security, but the aim here is compatibility)
    private static final byte[] ivBytes = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};


    private RDAAESCryptionHelper() {
    }

    /**
     * Generates SHA256 hash of the password which is used as key
     *
     * @param password used to generated key
     * @return SHA256 of the password
     */
    private static SecretKeySpec generateKey(final String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        final MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);

        byte[] bytes = password.getBytes(CHARSET);

        digest.update(bytes, 0, bytes.length);

        byte[] key = digest.digest();

        return new SecretKeySpec(key, "AES");
    }

    public static String encrypt(String key, String text) throws GeneralSecurityException, UnsupportedEncodingException {

        SecretKeySpec secretKeySpec = generateKey(key);

        Cipher cipher = Cipher.getInstance(AES_MODE);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] cipherText = cipher.doFinal(text.getBytes(CHARSET));

        //NO_WRAP is important as was getting \n at the end
        return Base64.encodeToString(cipherText, Base64.NO_WRAP);
    }

    public static String decrypt(String key, String base64EncodedCipherText) throws GeneralSecurityException, UnsupportedEncodingException {

        SecretKeySpec secretKeySpec = generateKey(key);

        byte[] decodedCipherText = Base64.decode(base64EncodedCipherText, Base64.NO_WRAP);

        Cipher cipher = Cipher.getInstance(AES_MODE);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] decryptedBytes = cipher.doFinal(decodedCipherText);

        return new String(decryptedBytes, CHARSET);
    }
}