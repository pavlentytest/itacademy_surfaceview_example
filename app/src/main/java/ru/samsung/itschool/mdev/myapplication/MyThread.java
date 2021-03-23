package ru.samsung.itschool.mdev.myapplication;

import android.animation.ArgbEvaluator;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class MyThread extends Thread {

    // константа для интерполяции
    public static final int FRACTION_TIME = 1000;

    // переменная для интерполяции
    private ArgbEvaluator argbEvaluator;

    private Paint paint;

    // указатель для SurfaceView
    private SurfaceHolder holder;

    private boolean flag;

    private long startTime;
    private long buffRedrawTime;

    MyThread(SurfaceHolder h) {
        this.flag = false;
        this.holder = h;
        this.paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        argbEvaluator = new ArgbEvaluator();
    }



    @Override
    public void run() {

    }
}
