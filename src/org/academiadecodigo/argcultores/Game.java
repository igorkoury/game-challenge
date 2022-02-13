package org.academiadecodigo.argcultores;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Random;


public class Game implements KeyboardHandler {

    private Picture background;
    private Picture me;
    private Rectangle block;
    final static int PADDING = 10;
    private boolean play;

    public Game() {

        // background
        background = new Picture(PADDING, PADDING, "resources/background.png");
        background.draw();

        // my image
        me = new Picture(400, 150, "resources/me.png");
        me.draw();

        // play
        play = true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_SPACE:
                play = !play;
                break;
            case KeyboardEvent.KEY_UP:
                me.translate(0, -20);
                break;
            case KeyboardEvent.KEY_DOWN:
                me.translate(0, 20);
                break;
            case KeyboardEvent.KEY_RIGHT:
                me.translate(20, 0);
                break;
            case KeyboardEvent.KEY_LEFT:
                me.translate(-20, 0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void start() throws InterruptedException {

        while (play){

            blockCreator();
        }

    }

    public void blockCreator() throws InterruptedException {

        Random r = new Random();
        int rand = r.nextInt(50,300);

        block = new Rectangle(720,rand,20,20);
        block.setColor(Color.DARK_GRAY);
        block.draw();
        block.fill();

    }

    public void blockMove() {

        block.translate(-20,0); // move left

    }
}
