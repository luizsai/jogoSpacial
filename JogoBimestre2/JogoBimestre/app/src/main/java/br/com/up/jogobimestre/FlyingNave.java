package br.com.up.jogobimestre;

public class FlyingNave {
    private int naveX;
    private int naveY;
    private  int currentFrame;
    private int velocity;
    public static int maximumFrame;
    public FlyingNave(){
        naveX = AppHolder.SCRN_WIDTH_X/2 - AppHolder.getBitmapControl().getNaveWidth()/2;
        naveY = AppHolder.SCRN_HEIGHT_Y/2 - AppHolder.getBitmapControl().getNaveHeight()/2;
        currentFrame = 0;
        maximumFrame = 2;
    }
    public int getCurrentFrame(){
        return currentFrame;
    }
    public void setCurrentFrame(int currentFrame){
        this.currentFrame = currentFrame;
    }
    public int getX(){
        return naveX;
    }
    public int getY(){
        return naveY;
    }
    public void setX(int naveX){
        this.naveX = naveX;
    }
    public void setY(int naveY){
        this.naveY = naveY;
    }
    public int getVelocity(){
        return velocity;
    }
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }
}
