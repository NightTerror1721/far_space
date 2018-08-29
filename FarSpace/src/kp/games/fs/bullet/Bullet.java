/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.bullet;

import kp.games.fs.go.GameObject;
import kp.games.fs.go.PhysicalModeledObject;
import kp.jngg.sprite.Sprite;

/**
 *
 * @author Asus
 */
public class Bullet extends PhysicalModeledObject<BulletModel>
{
    private GameObject owner;
    protected Sprite sprite;
    
    public Bullet(BulletModel model)
    {
        super(model);
        this.owner = GameObject.OBJECT_INVALID;
    }
    
}
