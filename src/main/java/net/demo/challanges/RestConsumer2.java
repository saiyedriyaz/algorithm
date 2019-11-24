package net.demo.challanges;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RestConsumer2 {
    /*
     * Complete the function below. Base url:
     * https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */
    private static String BASE_URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

    public static void main(String[] args) throws Exception {
       Integer data = getNumberOfMovies("maze");
        System.out.println(data);
    }

    static Integer getNumberOfMovies(String substr) {
        Integer total = null;
        try {
            StringBuilder builder = new StringBuilder(BASE_URL + substr);
            String getResponse = doGet(builder.toString());
            total = getTotalCount(getResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    private static Integer getTotalCount(String getResponse) {
        JsonElement jelement = new JsonParser().parse(getResponse);
        Integer totalPages = jelement.getAsJsonObject().get("total").getAsInt();
        return totalPages;
    }

    private static String doGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
