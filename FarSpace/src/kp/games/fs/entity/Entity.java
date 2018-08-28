/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.entity;

import kp.games.fs.go.PhysicalObject;

/**
 *
 * @author Asus
 */
public class Entity extends PhysicalObject
{
    protected final EntityModel model;
    
    private int healthPoints;
    
    private boolean destroyed;
    
    public Entity(EntityModel model)
    {
        super();
        if(model == null)
            throw new NullPointerException();
        this.model = model;
        this.healthPoints = 1;
        this.destroyed = false;
    }
    
    public final EntityModel getModel() { return model; }
    
    public final void setHealthPoints(int healthPoints)
    {
        this.healthPoints = healthPoints < 1 ? 1 : healthPoints;
    }
    public final void damage(int points)
    {
        healthPoints -= points < 0 ? -points : points;
        if(healthPoints < 0)
            healthPoints = 0;
    }
    public final void kill() { healthPoints = 0; }
    public final void heal(int points)
    {
        if(healthPoints > 0)
            healthPoints += points < 0 ? -points : points;
    }
    public final void resurrect(int points)
    {
        if(healthPoints <= 0)
        {
            if(points == 0)
                healthPoints = 1;
            else healthPoints = points < 0 ? -points : points;
        }
    }
    public final int getHealthPoints() { return healthPoints; }
    public final boolean isAlive() { return healthPoints > 0; }
    
    public final boolean hasDestroyed() { return destroyed; }
    
    public final void destroy()
    {
        if(destroyed)
            return;
        destroyed = true;
        onDestroying();
    }
    
    public void onDestroying() {}
}
