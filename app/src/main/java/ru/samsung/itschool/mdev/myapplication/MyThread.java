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

    



    @Override
    public void run() {

    }
}
