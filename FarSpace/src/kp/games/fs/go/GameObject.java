/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.go;

import java.awt.Graphics2D;
import java.util.UUID;
import kp.jngg.math.DirectionUtils;
import kp.jngg.math.Vector2;
import kp.jngg.sprite.Sprite;

/**
 *
 * @author Asus
 */
public class GameObject
{
    private final UUID uid = UUID.randomUUID();
    
    protected final Vector2 position = new Vector2();
    protected final Vector2 speed = new Vector2();
    protected final Vector2 acceleration = new Vector2();
    
    protected double rotationTheta;
    protected double rotationSpeed;
    
    protected final Vector2 size = new Vector2();
    
    public final UUID getUniqueId() { return uid; }
    
    public final void setPosition(double x, double y) { this.position.set(x, y); }
    public final void setPosition(Vector2 position) { this.position.set(position); }
    public final void setPositionX(double x) { this.position.x = x; }
    public final void setPositionY(double y) { this.position.y = y; }
    
    public final void setSpeed(double x, double y) { this.speed.set(x, y); }
    public final void setSpeed(Vector2 speed) { this.speed.set(speed); }
    public final void setSpeedX(double x) { this.speed.x = x; }
    public final void setSpeedY(double y) { this.speed.y = y; }
    
    public final void setAcceleration(double x, double y) { this.acceleration.set(x, y); }
    public final void setAcceleration(Vector2 acceleration) { this.acceleration.set(acceleration); }
    public final void setAccelerationX(double x) { this.acceleration.x = x; }
    public final void setAccelerationY(double y) { this.acceleration.y = y; }
    
    public final void setRotationTheta(double theta) { this.rotationTheta = theta; }
    
    public final void setRotationSpeed(double speed) { this.rotationSpeed = speed; }
    
    public final void setSize(double width, double height) { this.size.set(width, height); }
    public final void setSize(Vector2 size) { this.size.set(size); }
    public final void setSizeWidth(double width) { this.size.x = width; }
    public final void setSizeHeight(double height) { this.size.y = height; }
    
    
    public final Vector2 getPosition() { return position.copy(); }
    public final double getPositionX() { return position.x; }
    public final double getPositionY() { return position.y; }
    
    public final Vector2 getSpeed() { return speed.copy(); }
    public final double getSpeedX() { return speed.x; }
    public final double getSpeedY() { return speed.y; }
    
    public final Vector2 getAcceleration() { return acceleration.copy(); }
    public final double getAccelerationX() { return acceleration.x; }
    public final double getAccelerationY() { return acceleration.y; }
    
    public final double getRotationTheta() { return rotationTheta; }
    
    public final double getRotationSpeed() { return rotationSpeed; }
    
    public final Vector2 getSize() { return size.copy(); }
    public final double getSizeWidth() { return size.x; }
    public final double getSizeHeight() { return size.y; }
    
    
    public final void translate(double x, double y) { position.add(x, y); }
    public final void translate(Vector2 amount) { position.add(amount); }
    
    
    @SuppressWarnings("empty-statement")
    public void update(double delta)
    {
        position.add(speed.product(delta));
        speed.add(acceleration.product(delta));
        
        rotationTheta += rotationSpeed * delta;
        if(rotationTheta >= DirectionUtils.PI2)
            while((rotationTheta -= DirectionUtils.PI2) >= DirectionUtils.PI2);
        else if(rotationTheta < 0)
            while((rotationTheta += DirectionUtils.PI2) < 0);
    }
    
    public void draw(Graphics2D g) {}
    
    
    protected static final void drawSprite(Graphics2D g, Sprite sprite, Vector2 position, Vector2 size)
    {
        sprite.draw(g, position.x - (size.x / 2), position.y - (size.y / 2), size.x, size.y);
    }
    
    protected static final void drawSprite(Graphics2D g, Sprite sprite, double x, double y, double width, double height)
    {
        sprite.draw(g, x - (width / 2), y - (y / 2), width, height);
    }
    
    protected static final void drawSprite(Graphics2D g, Sprite sprite, Vector2 position, Vector2 size, double theta)
    {
        sprite.draw(g, position.x - (size.x / 2), position.y - (size.y / 2), size.x, size.y, theta);
    }
    
    protected static final void drawSprite(Graphics2D g, Sprite sprite, double x, double y, double width, double height, double theta)
    {
        sprite.draw(g, x - (width / 2), y - (y / 2), width, height, theta);
    }
    
    protected final void drawSprite(Graphics2D g, Sprite sprite)
    {
        sprite.draw(g, position.x - (size.x / 2), position.y - (size.y / 2), size.x, size.y, rotationTheta);
    }
}
