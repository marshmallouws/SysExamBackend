/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.mysql.cj.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.ws.rs.core.MediaType;
import net.minidev.json.JSONObject;
import org.json.*;

/**
 *
 * @author Annika StringBuilder, Threads, DTO
 */
public class PandaFacade implements IPandaFacade {

    @Override
    public String getAllSeries(String query) throws MalformedURLException, IOException, ProtocolException {
        URL url = new URL("https://api.pandascore.co/series?" + "token=uNIfp_1YhqRYLQTjQmWHXfiuQxg-r01KBjo_NOtr8k4ncXJLQ6g");
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Content", "application/json");
        
        Scanner scan = new Scanner(con.getInputStream());

        String jsonStr = null;
        if(scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        
        scan.close();
        JSONObject j = new JSONObject(jsonStr);
//        JSONObject obj = new JSONObject();
        //JSONObject json = 
        
//        JSONObject j = new JSONObject();
//        Object o = con.getContent();

        return rootobj;
        
        
                JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream)
        con.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
    }

    @Override
    public String getSingleSerie(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) throws IOException {
        PandaFacade p = new PandaFacade();
        System.out.println(p.getAllSeries(""));
    }

}


/*
 public String getSwapiData(int id) throws MalformedURLException, IOException {
        URL url = new URL("https://swapi.co/api/people/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("User-Agent", "server"); //remember if you are using SWAPI
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }´
*/
