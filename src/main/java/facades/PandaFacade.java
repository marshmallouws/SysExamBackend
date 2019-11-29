/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import dtos.SeriesDTO;
import errorhandling.NotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PandaFacade implements IPandaFacade {

    private static PandaFacade instance;

    public static PandaFacade getPandaFacade() {
        if (instance == null) {
            instance = new PandaFacade();
        }
        return instance;
    }

    private static String apiKey = System.getenv("S3_PANDA_TOKEN");

    @Override
    public SeriesDTO[] getAllSeries() throws NotFoundException {
        URL url = null;
        Gson gson = new Gson();
        Scanner scan = null;
        HttpURLConnection con = null;

        try {
            url = new URL("https://api.pandascore.co/series?sort=-year&per_page=15&" + "token=" + apiKey);

            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            con.setRequestProperty("Content", "application/json");

            scan = new Scanner(con.getInputStream());
        } catch (IOException e) {
            throw new NotFoundException("Ressource cannot be found");
        }

        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();

        SeriesDTO[] result = gson.fromJson(jsonStr, SeriesDTO[].class);

        System.out.println(result[0].videogame.name);
        return result;

    }

    @Override
    public SeriesDTO getSingleSerie(int id) throws NotFoundException {

        URL url = null;
        HttpURLConnection con = null;
        Scanner scan = null;
        Gson gson = new Gson();
        String jsonStr = null;

        try {
            url = new URL("https://api.pandascore.co/series/" + id + "?token=" + apiKey);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            con.setRequestProperty("Content", "application/json");

            scan = new Scanner(con.getInputStream());
        } catch (IOException ex) {
            throw new NotFoundException("URL is not found");
        }

        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();

        if (jsonStr == null) {
            throw new NotFoundException("No data on the given location");
        }

        return gson.fromJson(jsonStr, SeriesDTO.class);
    }
}
