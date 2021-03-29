package com.example.coursehomeworkfive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

class DrawClass extends View {
    private static final String COLOR_HEX = "#ffa500";
    private final Paint p;
    private float x;
    private float y;
    private float radius;
    private float strokeWidth;
    private float eyeRadius;
    private float eyeY;
    private float leftEyeX;
    private float rightEyeX;

    public DrawClass(Context context) {
        super(context);
        p = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        strokeWidth = 20;

        p.setColor(Color.parseColor(COLOR_HEX));
        p.setStrokeWidth(strokeWidth);
        p.setStyle(Paint.Style.STROKE);

        x = 540;
        y = 600;
        radius = 500;
        canvas.drawCircle(x, y, radius, p);

        eyeRadius = 90;

        eyeY = (float) (y/1.2);

        leftEyeX = x/2;

        rightEyeX = x + leftEyeX;

        canvas.drawCircle(leftEyeX, eyeY, eyeRadius, p);

        canvas.drawCircle(rightEyeX, eyeY, eyeRadius, p);

        RectF oval = new RectF(leftEyeX, 600, rightEyeX, 900);

        canvas.drawArc(oval, 0, 180, false, p);
    }
}
