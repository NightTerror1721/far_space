/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.go;

import kp.jngg.math.BoundingBox;
import kp.jngg.utils.BBContainer;

/**
 *
 * @author Asus
 */
public class PhysicalObject extends GameObject
{
    protected final BBContainer bbox = new BBContainer();
    
    protected final void setMultiBoundingBox(boolean flag)
    {
        bbox.setBoundingBox(new BoundingBox());
    }
    
    public final BBContainer getBoundingBoxContainer() { return bbox; }
    
    public final void updateBoundingBox()
    {
        bbox.resituate(position);
    }
    
    public final boolean hasCollision(PhysicalObject other) { return bbox.hasCollision(other.bbox); }
    public final boolean hasCollision(BBContainer other) { return bbox.hasCollision(other); }
    public final boolean hasCollision(BoundingBox other) { return bbox.hasCollision(other); }
    
    public final void collideTo(PhysicalObject object)
    {
        onCollide(object);
    }
    
    public void onCollide(PhysicalObject object) {}
}
