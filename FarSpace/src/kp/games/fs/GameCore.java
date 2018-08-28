/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs;

import java.awt.Color;
import java.awt.Graphics2D;
import kp.jngg.Display;
import kp.jngg.GameLoop;
import kp.jngg.input.InputEvent;
import kp.jngg.input.InputListener;
import kp.jngg.input.Keyboard;

/**
 *
 * @author Asus
 */
public final class GameCore implements GameLoop, InputListener
{
    static { Display.enableOpenGL(); }
    
    public static void main(String[] args)
    {
        Screen.createWindow(800, 600);
        Screen.setGameLoop(new GameCore());
        Screen.insertRuntimeStopCallback();
        Screen.start();
    }

    @Override
    public final void init()
    {
        Screen.addInputListener(this);
        Screen.addInput(new Keyboard());
        
        Screen.debugInfo().setEnabled(true);
        Screen.debugInfo().setExactFps(true);
        Screen.debugInfo().setColor(Color.GREEN);
        Screen.debugInfo().setShowMemory(true);
    }

    @Override
    public final void draw(Graphics2D g)
    {
        
    }

    @Override
    public final void update(double delta)
    {
        
    }

    @Override
    public final void dispatchEvent(InputEvent event)
    {
        System.out.println(event);
    }
}
