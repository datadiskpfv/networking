package uk.co.datadisk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            urlConnection.setRequestProperty("User-Agent", "Chrome");
            urlConnection.setReadTimeout(30000);

            int responseCode = urlConnection.getResponseCode();
            System.out.println("STATUS Code: " + responseCode);

            if(responseCode != 200){
                System.out.println("ERROR: reading web page");
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            while((line = inputReader.readLine()) != null){
                System.out.println(line);
            }

            inputReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}