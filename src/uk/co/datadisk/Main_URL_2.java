package uk.co.datadisk;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main_URL_2 {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();  // returns an open connection instance, give you chance to setup connection settings

            urlConnection.setRequestMethod("GET");    // this is optional



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}