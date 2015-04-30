package com.example.candynut.fungame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/**
 * Created by CandyNUT on 2015/4/29.
 */
public class FishPanel extends SurfaceView implements SurfaceHolder.Callback, KeyEvent.Callback, Runnable
{
    private SurfaceHolder sfh;
    private Bitmap bg = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
    private Bitmap myfish = BitmapFactory.decodeResource(getResources(), R.drawable.myfish);
    private int bg_x, bg_y;
    private MyFish myFish;
    private Recti rect;
    private Canvas canvas;
    private Paint paint;
    private Thread thread;
    private int screen_w, screen_h;
    private long startTime, endTime;
    private String info;
    public static int level, score, miss;
    public static boolean flag;


    public FishPanel(Context context)
    {
        super(context);
        sfh = this.getHolder();
        sfh.addCallback(this);
        score = 0;
        level = 1;
        miss = 0;
        rect.speed = 60;
        myFish = new MyFish(myfish);
        rect = new Recti();
        canvas = new Canvas();
        paint = new Paint();
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        screen_w = this.getWidth();
        screen_h = this.getHeight();
        flag = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        flag = false;
    }

    public void myDraw()
    {
        canvas = sfh.lockCanvas();
        if(canvas != null)
        {
            final float bgScaleX = 0.5f;//getWidth()/screen_w;
            final float bgScaleY = 0.53f;//getHeight()/screen_h;
            canvas.scale(bgScaleX, bgScaleY);
            canvas.drawBitmap(bg, 0, 0, paint);
            Paint paint1 = new Paint();
            paint1.setTextSize(40);
            paint1.setColor(Color.RED);
            canvas.drawText(info, 50, 50, paint1);
            myFish.draw(canvas, paint);
            rect.draw(canvas, paint);
        }
        sfh.unlockCanvasAndPost(canvas);
    }

    @Override
    public void run()
    {
        while(flag)
        {
            startTime = System.currentTimeMillis();
            info = "Sore: " + score + "; " + "Speed: " + rect.speed + "; " + "Level: " + level + "; " + myFish.fish_x + " : " + myFish.fish_y;
            rect.rectMove();
            if(rect.rect_y > 11000 || rect.rect_x > 8000)
            {
                rect.generateRect();
            }
            if(isCollision(myFish.fish_x, myFish.fish_y, myFish.fish_w, myFish.fish_h, rect.rect_x, rect.rect_y, rect.rect_w, rect.rect_h))
            {
                MyFish.fishScale += 0.01;
                score++;
                if(score % 3 == 0)
                {
                    rect.speed += 5;
                }
                if(score > 5 && score <= 10)
                {
                    level = 2;
                }
                else if(score > 10 && score <= 15)
                {
                    level = 3;
                }

                rect.generateRect();
            }
            endTime = System.currentTimeMillis();
            try{
                if(endTime - startTime < 50){
                    Thread.sleep(50 - (endTime - startTime));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myDraw();
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        invalidate();
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_W && myFish.fish_y >= 50)
        {
            myFish.fish_y -= 60;
        }
        else if(keyCode == KeyEvent.KEYCODE_S && myFish.fish_y + myFish.fish_h <= 110400)
        {
            myFish.fish_y += 60;
        }
        else if(keyCode == KeyEvent.KEYCODE_A && myFish.fish_x >= 50)
        {
            myFish.fish_x -= 60;
        }
        else if(keyCode == KeyEvent.KEYCODE_D && myFish.fish_x + myFish.fish_w <= 8500)
        {
            myFish.fish_x += 60;
        }
        else if(keyCode == KeyEvent.KEYCODE_SPACE)
        {
            flag = true;
            thread.start();
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean isCollision(float x1, float y1, float w1, float h1, float x2, float y2, float w2, float h2)
    {
        if(x1 >= x2 && x1 >= x2 + w2)
        {
            return false;
        }
        else if(x1 <= x2 && x1 + w1 <= x2)
        {
            return false;
        }
        else if(y1 >= y2 && y1 >= y2 + h2)
        {
            return false;
        }
        else if(y1 <= y2 && y1 + h1 <= y2)
        {
            return false;
        }
        miss = 0;
        return true;
    }
}
