/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import dtos.SeriesDTO;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class PandaFacade implements IPandaFacade {

    @Override
    public SeriesDTO[] getAllSeries(String query) throws MalformedURLException, IOException, ProtocolException {
        URL url = new URL("https://api.pandascore.co/series?" + "token=uNIfp_1YhqRYLQTjQmWHXfiuQxg-r01KBjo_NOtr8k4ncXJLQ6g");
        Gson gson = new Gson();
        
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
        
        SeriesDTO[] result = gson.fromJson(jsonStr, SeriesDTO[].class);
        
        System.out.println(result[0].videogame.name);
        return result;

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

