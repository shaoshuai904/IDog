package com.maple.idog;

import android.app.Application;
import android.os.Environment;


import com.maple.idog.utils.L;

import java.io.File;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;

public class IDogApp extends Application {
    private static IDogApp app;

    public static String rootPath = "/iDog/";
    public static String errorPath = "/iDog/error.txt";

    @Override
    public void onCreate() {
        app = this;
        super.onCreate();

        initPath();


        // 设置异常的处理类
//        Thread.currentThread().setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
    }


    private void initPath() {
        String ROOT = "";// /storage/emulated/0
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            ROOT = Environment.getExternalStorageDirectory().getPath();
            L.e("app", "系统方法：" + ROOT);
            //  ROOT = StorageUtils.getSdcardPath(this);
        }
        rootPath = ROOT + rootPath;
        errorPath = ROOT + errorPath;

        File lrcFile = new File(rootPath);
        if (!lrcFile.exists()) {
            lrcFile.mkdirs();
        }
    }


    private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            System.out.println("捕获了一个异常");
            PrintStream err;
            try {
                err = new PrintStream(new File(errorPath));
                ex.printStackTrace(err);
            } catch (Exception e) {
                e.printStackTrace();
            }
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }


    public static IDogApp app() {
        return app;
    }


}
