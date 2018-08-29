/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kp.games.fs.utils;

import java.io.File;

/**
 *
 * @author Asus
 */
public interface Constants
{
    /* REPOSITORY DIRECTORIES */
    File DIR_DATA = new File("data").getAbsoluteFile();
    File DIR_SCRIPTS = new File(DIR_DATA.getAbsolutePath() + File.separator + "scripts").getAbsoluteFile();
}
