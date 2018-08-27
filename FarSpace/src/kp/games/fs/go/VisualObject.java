/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.go;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import kp.jngg.DrawingArea;
import kp.jngg.sprite.Sprite;

/**
 *
 * @author Asus
 */
public abstract class VisualObject<S extends Sprite> extends GameObject
{
    protected static final AlphaComposite __ALPHA = AlphaComposite.SrcOver;
    
    protected S sprite;
    
    protected float alpha;
    protected float alphaSpeed;
    
    public VisualObject(S sprite)
    {
        super();
        this.sprite = sprite;
    }
    public VisualObject() { super(); }
    
    public void update(double delta)
    {
        super.update(delta);
        
        alpha += alphaSpeed;
        alpha = alpha > 1f ? 1f : alpha < 0f ? 0f : alpha;
        
        if(sprite != null)
            sprite.update(delta);
    }
    
    public void draw(Graphics2D g)
    {
        if(sprite != null)
        {
            if(alpha != 1f)
            {
                Composite old = g.getComposite();
                g.setComposite(__ALPHA.derive(alpha));
                drawSprite(g, sprite);
                g.setComposite(old);
                return;
            }
            drawSprite(g, sprite);
        }
    }
    
    public final boolean isOutOfCanvas(DrawingArea canvas)
    {
        return position.x + size.x < 0 ||
                position.x > (canvas.getWidth() + size.x) ||
                position.y + size.y < 0 ||
                position.y > (canvas.getHeight() + size.y);
    }
    
    public abstract boolean isDead();
}
