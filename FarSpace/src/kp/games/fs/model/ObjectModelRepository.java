/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import kp.games.fs.go.GameObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Asus
 * @param <GO>
 * @param <M>
 */
public abstract class ObjectModelRepository<GO extends GameObject, M extends ObjectModel<GO>>
{
    private final HashMap<String, M> models = new HashMap<>();
    
    protected abstract String repositoryName();
    
    protected abstract M createModel(String id, JSONObject base);
    
    public final boolean hasModel(String id) { return models.containsKey(id); }
    
    public final M getModel(String id) { return models.getOrDefault(id, null); }
    
    public final GO createObject(String id)
    {
        M model = models.getOrDefault(id, null);
        if(model == null)
            return null;
        return model.build();
    }
    
    public final void loadModels(JSONObject json)
    {
        JSONArray array = json.optJSONArray(repositoryName());
        if(array == null)
            return;
        
        int len = array.length();
        for(int i=0;i<len;i++)
        {
            JSONObject base = array.optJSONObject(i);
            if(base == null)
                continue;
            String id = base.optString("id");
            if(id.isEmpty())
                continue;
            M model = createModel(id, base);
            if(model == null)
                continue;
            models.put(id, model);
        }
    }
    
    public final void loadModels(InputStream input)
    {
        try { loadModels(new JSONObject(new JSONTokener(input))); }
        catch(JSONException ex) { ex.printStackTrace(System.err); }
    }
    
    public final void loadModels(File file)
    {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)))
        {
            loadModels(new JSONObject(new JSONTokener(bis)));
        }
        catch(IOException | JSONException ex) { ex.printStackTrace(System.err); }
    }
}
