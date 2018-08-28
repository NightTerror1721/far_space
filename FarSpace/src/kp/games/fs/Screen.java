/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import kp.jngg.DebugInfo;
import kp.jngg.Display;
import kp.jngg.DisplayMode;
import kp.jngg.GameLoop;
import kp.jngg.input.Input;
import kp.jngg.input.InputListener;
import kp.jngg.input.InputMaskDispatcher;

/**
 *
 * @author Asus
 */
public final class Screen
{
    private static Display display;
    
    public static final void createWindow(int width, int height)
    {
        if(display != null)
            throw new IllegalStateException();
        display = Display.create("Far Space", DisplayMode.getDisplayMode(800, 600));
    }
    
    public static final void setGameLoop(GameLoop gameLoop)
    {
        display.setGameLoop(gameLoop);
    }
    
    public static final Display display() { return display; }
    
    public static final void start() { display.start(); }
    public static final void stop() { display.stop(); }
    public static final void abort() { display.abort(); }
    public static final void abort(int code) { display.abort(code); }
    
    public static final DebugInfo debugInfo() { return display.getDebugInfo(); }
    
    public static final void addInputListener(InputListener listener) { display.addInputListener(listener); }
    public static final void removeInputListener(InputListener listener) { display.removeInputListener(listener); }
    
    public static final InputMaskDispatcher createInputMaskDispatcher() { return display.createInputMaskDispatcher(); }
    
    
    public static final void addInput(Input input) { display.addInput(input); }
    public static final void removeInput(Input input) { display.removeInput(input); }
    
    public static final int getX() { return display.getX(); }
    public static final int getY() { return display.getY(); }
    public static final int getWidth() { return display.getWidth(); }
    public static final int getHeight() { return display.getHeight(); }
    public static final int getRefreshRate() { return display.getRefreshRate(); }
    
    public static final void setFullscreen(boolean flag) { display.setFullscreen(flag); }
    public static final boolean isFullscreenEnabled() { return display.isFullscreenEnabled(); }
    
    public static final void setDisplayMode(DisplayMode mode) { display.setDisplayMode(mode); }
    public static final DisplayMode getDisplayMode() { return display.getDisplayMode(); }
    
    public static final double getLastDeltaTime() { return display.getLastDeltaTime(); }
    
    public static final Insets getInsets() { return display.getInsets(); }
    
    public static final int getCurrentFpsPerSecond() { return display.getCurrentFpsPerSecond(); }
    public static final double getExactCurrentFpsPerSecond() { return display.getExactCurrentFpsPerSecond(); }
    
    public static final void setUpdateFramerate(int fps) { display.setUpdateFramerate(fps); }
    public static final int getCurrentUpdateFramerate() { return display.getCurrentUpdateFramerate(); }
    public static final double getExactCurrentUpdateFramerate() { return display.getExactCurrentUpdateFramerate(); }
    
    
    public static final boolean isRunning() { return display.isRunning(); }
    
    public static final Dimension getDimension() { return display.getDimension(); }
    public static final Rectangle getArea() { return display.getArea(); }
    
    public static final void addStopCallbackFunction(Runnable function) { display.addStopCallbackFunction(function); }
    public static final void addStopCallbackFunction(boolean oneUse, Runnable function) { display.addStopCallbackFunction(oneUse, function); }
    public static final void removeStopCallbackFunction(Runnable function) { display.removeStopCallbackFunction(function); }
    
    public static final void insertRuntimeStopCallback() { display.insertRuntimeStopCallback(); }
    
    public static final long getMemoryUsed() { return Display.getMemoryUsed(); }
    public static final float getMemoryUsedInKb() { return Display.getMemoryUsedInKb(); }
    public static final float getMemoryUsedInMb() { return Display.getMemoryUsedInMb(); }
    
    public static final long getTotalMemory() { return Display.getTotalMemory(); }
    public static final float getTotalMemoryInKb() { return Display.getTotalMemoryInKb(); }
    public static final float getTotalMemoryInMb() { return Display.getTotalMemoryInMb(); }
}
