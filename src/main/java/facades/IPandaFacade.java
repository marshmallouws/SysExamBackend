/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.JsonObject;
import dtos.SeriesDTO;
import errorhandling.NotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import net.minidev.json.JSONObject;

/**
 *
 * @author Victor
 */
public interface IPandaFacade {
    
    public SeriesDTO[] getAllSeries() throws NotFoundException;
    public SeriesDTO getSingleSerie(int seriesId) throws NotFoundException;
    
}
