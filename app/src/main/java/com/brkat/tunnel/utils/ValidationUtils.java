package com.brkat.tunnel.utils;

import java.util.regex.Pattern;

/**
 * ValidationUtils - أداة التحقق من صحة البيانات
 */
public class ValidationUtils {

    private static final Pattern IP_PATTERN = Pattern.compile(
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"
    );

    private static final Pattern DOMAIN_PATTERN = Pattern.compile(
            "^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,}$"
    );

    private static final Pattern UUID_PATTERN = Pattern.compile(
            "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$"
    );

    /**
     * التحقق من صحة عنوان IP
     */
    public static boolean isValidIpAddress(String address) {
        if (address == null || address.isEmpty()) {
            return false;
        }
        return IP_PATTERN.matcher(address).matches();
    }

    /**
     * التحقق من صحة اسم النطاق
     */
    public static boolean isValidDomain(String domain) {
        if (domain == null || domain.isEmpty()) {
            return false;
        }
        return DOMAIN_PATTERN.matcher(domain).matches();
    }

    /**
     * التحقق من صحة عنوان (IP أو Domain)
     */
    public static boolean isValidAddress(String address) {
        return isValidIpAddress(address) || isValidDomain(address);
    }

    /**
     * التحقق من صحة المنفذ
     */
    public static boolean isValidPort(int port) {
        return port > 0 && port < 65536;
    }

    /**
     * التحقق من صحة UUID
     */
    public static boolean isValidUUID(String uuid) {
        if (uuid == null || uuid.isEmpty()) {
            return false;
        }
        return UUID_PATTERN.matcher(uuid.toLowerCase()).matches();
    }

    /**
     * التحقق من عدم ترك الحقول فارغة
     */
    public static boolean isNotEmpty(String... values) {
        for (String value : values) {
            if (value == null || value.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}