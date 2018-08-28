/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.model;

import kp.jngg.json.JSONObject;

/**
 *
 * @author Asus
 */
public abstract class ObjectModel<O>
{
    private final String id;
    
    public ObjectModel(String id)
    {
        if(id == null)
            throw new NullPointerException();
        if(id.isEmpty())
            throw new IllegalArgumentException("Model ID cannot be empty");
        this.id = id;
    }
    
    public final String getId() { return id; }
    
    public abstract void load(JSONObject base);
    public abstract JSONObject store();
    
    public abstract O build();
}
