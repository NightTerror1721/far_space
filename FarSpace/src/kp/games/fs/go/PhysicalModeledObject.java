/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.go;

import kp.games.fs.model.ObjectModel;

/**
 *
 * @author Asus
 */
public class PhysicalModeledObject<M extends ObjectModel> extends PhysicalObject
{
    protected final M model;
    
    public PhysicalModeledObject(M model)
    {
        if(model == null)
            throw new NullPointerException();
        this.model = model;
    }
    
    public final M getModel() { return model; }
}
