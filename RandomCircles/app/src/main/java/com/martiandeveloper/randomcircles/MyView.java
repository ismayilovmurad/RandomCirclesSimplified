package com.martiandeveloper.randomcircles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class MyView extends View {

    private Paint paint;

    private int maxX;
    private int maxY;

    private List<Integer> colorList;

    private int circleCount;

    public MyView(@Nullable Context context) {
        super(context);
    }

    public MyView(@Nullable Context context, int maxX, int maxY, int circleCount) {
        super(context);

        paint = new Paint();
        paint.setStyle(Style.FILL);

        this.maxX = maxX - 32;
        this.maxY = maxY - 32;

        setColorList();

        this.circleCount = circleCount;
    }

    private void setColorList() {
        colorList = new ArrayList<>();
        colorList.add(Color.BLUE);
        colorList.add(Color.BLACK);
        colorList.add(Color.CYAN);
        colorList.add(Color.DKGRAY);
        colorList.add(Color.GRAY);
        colorList.add(Color.GREEN);
        colorList.add(Color.LTGRAY);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.RED);
        colorList.add(Color.YELLOW);
    }

    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < circleCount; i++) {
            paint.setColor(colorList.get(new Random().nextInt(10)));
            canvas.drawCircle(generateRandomXAndY()[0], generateRandomXAndY()[1], 32, paint);
        }

    }

    private int[] generateRandomXAndY() {
        int x, y;
        Random rn = new Random();
        int diff = maxX - 32;
        x = rn.nextInt(diff + 1);
        x += 32;

        rn = new Random();
        diff = maxY - 32;
        y = rn.nextInt(diff + 1);
        y += 32;
        return new int[]{x, y};
    }

}
