/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.scripts;

import java.io.File;
import java.util.HashMap;
import kp.games.fs.utils.Constants;
import kp.sgs.SGSScript;

/**
 *
 * @author Asus
 */
public final class ScriptRepository
{
    private static final HashMap<String, SGSScript> SCRIPTS = new HashMap<>();
    
    public static final void loadScripts()
    {
        File[] files = Constants.DIR_SCRIPTS.listFiles();
        for(File file : files)
        {
            if(!file.getName().endsWith(".sgs"))
                continue;
            
        }
    }
    
    private static SGSScript createInvalidScript()
    {
        SGSCompiler.
    }
}
