package com.brkat.tunnel.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * EncryptionUtils - أداة التشفير
 * توفر طرق التشفير وفك التشفير بخوارزمية AES-256-GCM
 */
public class EncryptionUtils {

    private static final String ALGORITHM = "AES";
    private static final String MODE = "AES/GCM/NoPadding";
    private static final int GCM_NONCE_LENGTH = 12; // 96 bits
    private static final int GCM_TAG_LENGTH = 128;  // bits
    private static final int KEY_SIZE = 256;        // bits

    /**
     * توليد مفتاح جديد
     */
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(KEY_SIZE);
        return keyGenerator.generateKey();
    }

    /**
     * تشفير البيانات
     */
    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(MODE);
        byte[] iv = new byte[GCM_NONCE_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, gcmSpec);

        byte[] plainBytes = plaintext.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedBytes = cipher.doFinal(plainBytes);

        // دمج IV مع البيانات المشفرة
        ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + encryptedBytes.length);
        byteBuffer.put(iv);
        byteBuffer.put(encryptedBytes);

        return Base64.getEncoder().encodeToString(byteBuffer.array());
    }

    /**
     * فك تشفير البيانات
     */
    public static String decrypt(String ciphertext, SecretKey key) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(ciphertext);
        ByteBuffer byteBuffer = ByteBuffer.wrap(decodedBytes);

        byte[] iv = new byte[GCM_NONCE_LENGTH];
        byteBuffer.get(iv);
        byte[] encryptedBytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(encryptedBytes);

        Cipher cipher = Cipher.getInstance(MODE);
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, key, gcmSpec);

        byte[] plainBytes = cipher.doFinal(encryptedBytes);
        return new String(plainBytes, StandardCharsets.UTF_8);
    }
}