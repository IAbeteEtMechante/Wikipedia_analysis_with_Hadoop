/* MapReduce Program - file SumPageViewsReduce.java
 * Authors:
 * Duc Pham
 * Patricia Poral
 * Pierre Schwob
 * copyright (c) 2020
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/** Program that outputs Wikipedia articles
 * and its view count for a specified time frame.
 */

public class WikipediaCrawler {

    /** Specify filename, start and end date where
     * articles are obtained from.
     *
     * @param args an array of command-line arguments for the application.
     * @throws Exception if error occurs in the method.
     */

    public static void main(String[] args) throws Exception {
        prepUrl("data/covid_articles", "2019120100", "2020050300");
    }

    /** Gets the URL then converts and stores
     * it as a String.
     *
     * @param url url related to filename defined.
     * @return url into String.
     * @throws Exception if error occurs in the method.
     */

    public static String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /** Outputs the title of Wikipedia article, its view count
     * and date it was obtained from.
     *
     * @param response is the URL converted to String
     * @return result
     */

    public static String parseFromJsonResponse(String response) {
        System.out.println(response);
        JSONObject myjson;
        String result = "";
        try {
            myjson = new JSONObject(response);
            for (int i = 0; i < 357; i++) {
                JSONObject res = myjson.getJSONArray("items").getJSONObject(i);
                System.out.println(res.getString("article"));
                result = res.getString("article") + ","
                        + res.getString("timestamp").substring(0, 8)
                        + "," + res.getLong("views");
                try (FileWriter fw = new FileWriter("covid_test_count", true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter out = new PrintWriter(bw)) {
                    out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            // do nothing
        }
        return result;
    }

    /** Fetch articles from URL and outputs the title
     * of Wikipedia article, its view count and date
     * it was obtained from.
     *
     * @param filename is the subject of related article
     *                 interested in.
     * @param startDates is the date where articles from
     *                   Wikipedia are first obtained.
     * @param endDates is the date where articles from
     *                 Wikipedia are last obtained.
     * @return the title of Covid related articles and its
     *                  page views for the specified time frame
     * @throws Exception if error occurs in the method.
     */

    public static String prepUrl(String filename,
                                 String startDates,
                                 String endDates) throws Exception {
        BufferedReader inputFileReader = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<>();
        String line = inputFileReader.readLine();

        while (line != null) {
            lines.add(line);
            line = inputFileReader.readLine();
        }
        inputFileReader.close();

        String[] articles = lines.toArray(new String[]{});
        WikipediaCrawler http = new WikipediaCrawler();
        String response = "";
        for (int i = 0; i < articles.length; i++) {
            String url1 =
                    "https://wikimedia.org/api/rest_v1/metrics/pageviews/per-article/en.wikipedia/all-access/all-agents/";
            String url2 = articles[i]; //Article name
            String url3 = "/daily/";
            String url4 = startDates; //Start Date
            String url5 = "/";
            String url6 = endDates; //End Date
            StringBuilder sb = new StringBuilder();
            sb.append(url1).append(url2).append(url3).append(url4).append(url5).append(url6);
            String res = sb.toString();
            response = http.sendGet(res);
            // System.out.println(response);
            parseFromJsonResponse(response);
        }
        return response;
    }
}
