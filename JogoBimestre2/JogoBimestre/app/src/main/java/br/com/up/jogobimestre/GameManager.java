package br.com.up.jogobimestre;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GameManager {
    BgImage bgImage;
    int scoreCount;
    int winningTube;
    Paint desingPaint;


    public GameManager() {
        bgImage = new BgImage();
        initScoreVariables();
    }

    public void initScoreVariables(){
        scoreCount = 0;
        winningTube =0;
        desingPaint = new Paint();
        desingPaint.setColor(Color.YELLOW);
        desingPaint.setTextSize(250);
        desingPaint.setStyle(Paint.Style.FILL);
        desingPaint.setFakeBoldText(true);
        desingPaint.setShadowLayer(5.0f, 20.0f, 20.0f, Color.BLACK);


    }

    public void backgroundAnimation(Canvas canvas){
    bgImage.setX(bgImage.getX() - bgImage.getVelocity());
    if (bgImage.getX() < -AppHolder.getBitmapControl().getBackgroundWidth()){
        bgImage.setX(0);
    }
    canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getX(), bgImage.getY(), null);
    if (bgImage.getX() <-(AppHolder.getBitmapControl().getBackgroundWidth() - AppHolder.SCRN_WIDTH_X)){
        canvas.drawBitmap(AppHolder.getBitmapControl().getBackground(), bgImage.getX() +
                AppHolder.getBitmapControl().getBackgroundWidth(), bgImage.getY(), null);
    }
    }

    public void scrollingTube(Canvas can){
        if (gameState == 1){

            if ((tubeCollections.get(winningTube).getXtube() < nave.getX() + AppHolder.getBitmapControl().getNaveWidth())
            &&(tubeCollections.get(winningTube).getUpTubeCollection_Y() > nave.getY()
            ||tubeCollections.get(winningTube).getDownTube_Y() < nave.getY() +
                    AppHolder.getBitmapControl().getNaveHeight())){
                gameState = 2;
                Context mContext = AppHolder.gameActivityContext;
                Intent mIntent = new Intent(mContext, GameOver.class);
                mIntent.putExtra("score",scoreCount);
                mContext.startActivity(mIntent);
                ((Activity)mContext).finish();

            }

            if (tubeCollections.get(winningTube).getXtube() < nave.getX() - AppHolder.getBitmapControl().getTubeWisth()){
                scoreCount ++;
                winningTube ++;
                if (winningTube > AppHolder.tube_numbers -1){
                    winningTube = 0;
                }
            }
            for (int j =0; j < AppHolder.tube_numbers; j++){
                if(tubeCollections.get(j).getXtube()<-AppHolder.getBitmapControl().getTubeWidth()) {
                    tubeCollections.get(j).setXtube(tubeCollections.get(j).getXtube()
                            + AppHolder.tube_numbers * AppHolder.tubeDistance);
                    int upTubeCollectioY = AppHolder.minimumTubeCollection_Y +
                            rand.nextInt(AppHolder.minimumTubeCollection_Y - AppHolder.minimumTubeCollection_Y + 1);
                    tubeCollection.get(j).setUpTubeCollection_y(upTubeCollectioY);
                    tubeCollections.get(j).setColorTube();
                }
                    if (tubeCollections.get(j).getColorTube() == 0){
                        can.drawBitmap(AppHolder.getBitmapControl().getUpTube(), tubeCollections.get(j).getXtube(),tubeCollections.get(j).getUpTube_Y(), null);
                        can.drawBitmap(AppHolder.getBitmapControl().getDownTube(), tubeCollections.get(j).getXtube(), tubeCollections.get(j).getUpTube_Y(), null);
                    }else{
                        can.drawBitmap(AppHolder.getBitmapControl().getUpColoredTube(), tubeCollections.get(j).getXtube(), tubeCollections.get(j).getUpTube_Y(), null);
                        can.drawBitmap(AppHolder.getBitmapControl().getDownColoredTube().tubeCollections.get(j).getXtube(),tubeCollections.get(j).getDownTube_Y(),null);
                    }
                }
                tubeCollection.get(j).setXtube(tubeCollection.get(j).getXtube()- AppHolder.tubeVelocity);

            }
            can.drawText("" + scoreCount, 620, 400, desingPaint);
        }
    }
}
