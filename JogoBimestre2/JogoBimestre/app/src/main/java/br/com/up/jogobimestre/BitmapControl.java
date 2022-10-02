package br.com.up.jogobimestre;

import static android.graphics.BitmapFactory.decodeResource;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//sincroniza background
public class BitmapControl {
    Bitmap background;
    Bitmap[] FlyingNave;
    Bitmap upColoredTube, downColoredTube;


    public BitmapControl(Resources res) {
        background = decodeResource(res,R.drawable.background_full2);
        background = imageScale(background);
        FlyingNave = new Bitmap[1];
        BitmapFactory.decodeResource(res,R.drawable.imagemnave_1);
        upColoredTube = BitmapFactory.decodeResource(res,R.drawable.colored_tube_up);
        downColoredTube = BitmapFactory.decodeResource(res,R.drawable.colored_tube_bottom);


    }


    public  Bitmap getUpColoredTube(){
        return upColoredTube;
    }

    public Bitmap getDownColoredTube() {
        return downColoredTube;
    }

    public Bitmap getBackground(){
        return background;
    }
    public int getBackgroundWidth(){
        return background.getWidth();
    }
    public int getBackgroundHeight(){
        return background.getHeight();
    }
    public Bitmap imageScale(Bitmap bitmap){
        float width_heightRatio = (getBackgroundWidth() / getBackgroundHeight()) ;
        int bgScaleWidth = (int)width_heightRatio*AppHolder.SCRN_WIDTH_X;
        return Bitmap.createScaledBitmap(bitmap, bgScaleWidth, AppHolder.SCRN_HEIGHT_Y, false);
    }

}
