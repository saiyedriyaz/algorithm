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
import java.util.Collections;
import java.util.List;

public class Solution {
    /*
     * Complete the function below. Base url:
     * https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */
    private static String BASE_URL = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

    /*public static void main(String[] args) throws Exception {
        String[] data = getMovieTitles("spiderman");
        for (String datum : data) {
            System.out.println(datum);
        }
    }

    static String[] getMovieTitles(String substr) {
        try {
            StringBuilder builder = new StringBuilder(BASE_URL + substr);
            String getResponse = doGet(builder.toString());
            List<String> titleList = new ArrayList<>();
            titleList.addAll(getStringArray(getResponse));

            Short totalPages = getTotalPageCount(getResponse);
            if (totalPages > 1) {
                for (int nextPage = 2; nextPage <= totalPages; nextPage++) {
                    getResponse = doGet(builder.toString() + "&page=" + nextPage);
                    titleList.addAll(getStringArray(getResponse));
                }
            }
            Collections.sort(titleList);
            return titleList.stream().toArray(title -> new String[title]);
        } catch (Exception e) {
            return null;
        }
    }

    private static Short getTotalPageCount(String getResponse) {
        JsonElement jelement = new JsonParser().parse(getResponse);
        Short totalPages = jelement.getAsJsonObject().get("total_pages").getAsShort();
        return totalPages;
    }

    private static List getStringArray(String getResponse) {
        JsonElement element = new JsonParser().parse(getResponse);
        JsonObject object = element.getAsJsonObject();
        JsonArray dataArray = object.getAsJsonArray("data");
        List<String> titleList = new ArrayList<>();

        if (dataArray != null && dataArray.size() > 0) {
            String[] retArra = new String[dataArray.size()];

            for (JsonElement pa : dataArray) {
                JsonObject paymentObj = pa.getAsJsonObject();
                String title = paymentObj.get("Title").getAsString();
                titleList.add(title);
            }
        }
        return titleList;
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
    }*/
}
