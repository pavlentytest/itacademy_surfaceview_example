package ru.samsung.itschool.mdev.myapplication;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import java.util.Random;

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

    public void setRunning(boolean f) {
        this.flag = f;
    }

    @Override
    public void run() {
        Canvas canvas;
        startTime = getTime();
        while(flag) {
            long currTime = getTime();
            long elapsedTime = currTime - buffRedrawTime;
            if(elapsedTime < 50000) {
                continue;
            }
            // логика SurfaceView
            canvas = holder.lockCanvas();
            // рисуем
            doDraw(canvas);
            // показываем
            holder.unlockCanvasAndPost(canvas);
            
            buffRedrawTime = getTime();
        }

    }

    public long getTime() {
        return System.nanoTime()/1000; // микросек.
    }

    public void doDraw(Canvas canvas) {
        int centerX = canvas.getWidth()/2;
        int centerY = canvas.getHeight()/2;
        canvas.drawColor(Color.BLACK); // фон
        int maxRadius = Math.min(canvas.getHeight(),canvas.getWidth())/2;
        long currentTime = getTime();
        float fraction = (float)(currentTime%FRACTION_TIME)/FRACTION_TIME; // от 0 до 1
        Log.d("RRR fraction=",Float.toString(fraction));
        //Random r = new Random();
        int color = (int)argbEvaluator.evaluate(fraction, Color.BLACK, Color.RED);
        //Color.rgb(r.nextInt(255),r.nextInt(255),r.nextInt(255));
        Log.d("RRR color=",Integer.toString(color));
        paint.setColor(color);
        canvas.drawCircle(centerX,centerY,maxRadius*fraction,paint);
    }
}
