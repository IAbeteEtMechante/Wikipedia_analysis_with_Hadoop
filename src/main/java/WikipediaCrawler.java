/*
 * Get each day's page views for topics mentioned in main method
 */

import java.io.*;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/**
* @author: Patricia, Duc, Pierre
*/

public class WikipediaCrawler {
	/**
	* This is the program for getting number of views
	*from different articles from Wikipedia
	*/

    private final String userAgent = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        prepUrl("articles");
    }

    /**
     * Send GET request to get the data
     */
    private String sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", userAgent);

        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static String parseFromJsonResponse(String respo) {
        JSONObject myjson;
        String result = "";
        try {
            myjson = new JSONObject(respo);
            for (int i = 0; i < 30; i++) {
                JSONObject res = myjson.getJSONArray("items").getJSONObject(i);
                result = res.getString("article")
                        + "," + res.getString("timestamp").substring(0, 8)
                        + "," + res.getLong("views");

                try (FileWriter fw = new FileWriter("wikicounts", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw)) {
                    out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Prepare the Wikipedia API URL
     */
    public static String prepUrl(String filename) throws Exception {
        BufferedReader inputFileReader = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<>();
        String line = inputFileReader.readLine();

        while(line != null) {
            lines.add(line);
            line = inputFileReader.readLine();
        }
        inputFileReader.close();

        String[] articles = lines.toArray(new String[]{});
        String[] startDates = {"2015100100"};
        String[] endDates = {"2015103000"};
        WikipediaCrawler http = new WikipediaCrawler();
        String response = "";
        for (int i = 0; i < articles.length; i++) {
            for (int j = 0; j < startDates.length; j++) {
                String url1 =
                        "https://wikimedia.org/api/rest_v1/metrics/pageviews/per-article/en.wikipedia/all-access/all-agents/";
                String url2 = articles[i]; //Article name
                String url3 = "/daily/";
                String url4 = startDates[j]; //Start Date
                String url5 = "/";
                String url6 = endDates[j]; //End Date
                StringBuilder sb = new StringBuilder();
                sb.append(url1).append(url2).append(url3).append(url4).append(url5).append(url6);
                String res = sb.toString();
                response = http.sendGet(res);
                // System.out.println(response);
                parseFromJsonResponse(response);

            }
        }
        return response;
    }
}
