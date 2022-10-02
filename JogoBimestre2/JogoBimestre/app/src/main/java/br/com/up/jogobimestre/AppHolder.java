package br.com.up.jogobimestre;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppHolder {
    static BitmapControl bitmapControl;
    static GameManager gameManager;
    static int SCRN_WIDTH_X;
    static int SCRN_HEIGHT_Y;
    static Context  gameActivityContext;

    public static void assign(Context context){
        mapScreenSize(context);
        bitmapControl = new BitmapControl(context.getResources());
        gameManager = new GameManager();
    }
    public static BitmapControl getBitmapControl(){
        return bitmapControl;
    }
    public static GameManager getGameManager(){
        return gameManager;
    }
    //captura tamanho da tela
    private static void mapScreenSize(Context context){
        WindowManager manager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        Display dsp = manager.getDefaultDisplay();
        DisplayMetrics dMetrics = new DisplayMetrics();
        dsp.getMetrics(dMetrics);
        AppHolder.SCRN_WIDTH_X = dMetrics.widthPixels;
        AppHolder.SCRN_HEIGHT_Y = dMetrics.heightPixels;
    }
}
