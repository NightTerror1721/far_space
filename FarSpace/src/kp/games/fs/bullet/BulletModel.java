/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.bullet;

import kp.games.fs.model.ObjectModel;
import kp.jngg.json.JSONObject;

/**
 *
 * @author Asus
 */
public class BulletModel extends ObjectModel<Bullet>
{

    public BulletModel(String id) {
        super(id);
    }

    @Override
    public void load(JSONObject base) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JSONObject store() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bullet build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
