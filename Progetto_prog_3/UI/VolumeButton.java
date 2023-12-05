package Progetto_prog_3.UI;

import Progetto_prog_3.utils.LoadSave;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Progetto_prog_3.utils.LoadSave;
import static Progetto_prog_3.utils.Constants.UI.VolumeButton.*;


public class VolumeButton extends PauseButtons {

    private BufferedImage[] imgs;
    private BufferedImage slider;

    private int index = 0;
    private int buttonX;

    private boolean mouseOver, mousePressed;

    public VolumeButton(int x, int y, int width, int height) {
        //Modificare cosìil richiamo al costruttore della superclasse serve a posizionare il tasto del volume 
        //esattamente in mezzo alla barra del volume quando il gioco parte
        super(x + width/2 , y, VOLUME_WIDTH, height);
        buttonX = x + width/2;
        loadImages(); 

    }
    
        private void loadImages(){
        BufferedImage temp = LoadSave.getSpriteAtlas(LoadSave.VOLUME_BUTTON);
        imgs = new BufferedImage[3];

        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = temp.getSubimage(i * VOLUME_DEFAUT_WIDTH, 0, VOLUME_DEFAUT_WIDTH, VOLUME_DEFAUT_WIDTH);
        }

        slider = temp.getSubimage(3 * VOLUME_DEFAUT_WIDTH, 0, SLIDER_DEFAULT_WIDTH, VOLUME_DEFAUT_HEIGHT);
    }

    public void update(){

        index = 0;
        if (mouseOver) {
            index = 1;
        }
        if (mousePressed) {
            index = 2;
        }

    }

    public void draw(Graphics g){
        g.drawImage(slider, x, y, width, height, null);
        g.drawImage(imgs[0], buttonX, y, VOLUME_WIDTH, VOLUME_HEIGHT, null);
    }

    public void resetBools(){

        mouseOver = false;
        mousePressed = false;

    }

    public boolean getMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean getMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    };


}
