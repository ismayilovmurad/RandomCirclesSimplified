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

    // bu ekrana cekilendi, qelem kimi dusunun, rengini filan deyismek olur
    private Paint paint;

    // Cekilenler ekrandan qiraga cixmasin deye, maximum ve minimum ekran olcusunu cunku random x ve y hisseleri yaradacagiq.
    private int maxX;
    private int maxY;

    // Rengler listi
    private List<Integer> colorList;

    // Nece eded daire cekileceyi
    private int circleCount;

    // Constructor yeni class yaradildiqda cagirilan funksiya
    public MyView(@Nullable Context context) {
        super(context);
    }

    // Constructor, parametrler ile, maximum ve minimumu, nece eded daire olacagini MainActivity' den aliriq
    public MyView(@Nullable Context context, int maxX, int maxY, int circleCount) {
        super(context);

        // Painti yaradiriq, ve ici dolu olmasi ucun Style.FILL qururuq.
        paint = new Paint();
        paint.setStyle(Style.FILL);

        // 32 burda dairenin diametridi, ekrandan cixiriq ki, dairenin yarisi qirada qalir bezen.
        this.maxX = maxX - 32;
        this.maxY = maxY - 32;

        // List ucun funksiya
        setColorList();

        // MainActivity'den alinan daire sayi
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

    // onDraw burda View'in oz funksiyasidi biz View'i implement etmisik deye bu funksiyani override edirik
    @SuppressLint("DrawAllocation")
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // For dongusu girilen input qeder daire ceke bilmek ucun
        for (int i = 0; i < circleCount; i++) {
            // Random bir reng qururuq rengler listinden
            paint.setColor(colorList.get(new Random().nextInt(10)));
            // Ve nehayet ekrana cekirik random hisselerde
            canvas.drawCircle(generateRandomXAndY()[0], generateRandomXAndY()[1], 32, paint);
        }

    }

    // Random x ve y tapir ve istifade etmek ucun return edir.
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
