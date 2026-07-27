package com.brkat.tunnel.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.brkat.tunnel.models.Server;
from com.google.gson.Gson;
from com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * FileUtils - أداة التعامل مع الملفات
 * تدعم استيراد وتصدير ملفات .brkat
 */
public class FileUtils {

    private static final String BRKAT_FILE_EXTENSION = ".brkat";
    private static final String BRKAT_MIME_TYPE = "application/x-brkat";

    /**
     * حفظ السيرفر في ملف .brkat
     */
    public static File saveServerToFile(Context context, Server server, String fileName) throws IOException {
        if (!fileName.endsWith(BRKAT_FILE_EXTENSION)) {
            fileName = fileName + BRKAT_FILE_EXTENSION;
        }

        File file = new File(context.getExternalFilesDir(null), fileName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(server);

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(json.getBytes());
        fos.close();

        return file;
    }

    /**
     * حفظ قائمة السيرفرات في ملف واحد
     */
    public static File saveServersToFile(Context context, List<Server> servers, String fileName) throws IOException {
        if (!fileName.endsWith(BRKAT_FILE_EXTENSION)) {
            fileName = fileName + BRKAT_FILE_EXTENSION;
        }

        File file = new File(context.getExternalFilesDir(null), fileName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(servers);

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(json.getBytes());
        fos.close();

        return file;
    }

    /**
     * مشاركة الملف
     */
    public static void shareFile(Context context, File file) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType(BRKAT_MIME_TYPE);
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        context.startActivity(Intent.createChooser(shareIntent, "مشاركة الإعدادات"));
    }

    /**
     * حذف الملف
     */
    public static boolean deleteFile(File file) {
        return file != null && file.delete();
    }

    /**
     * التحقق من وجود الملف
     */
    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }
}