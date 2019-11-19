/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import net.minidev.json.JSONObject;

/**
 *
 * @author Victor
 */
public interface IPandaFacade {
    
    public JSONObject getAllSeries(String query) throws MalformedURLException, IOException;
    public String getSingleSerie(String query);
    
}
