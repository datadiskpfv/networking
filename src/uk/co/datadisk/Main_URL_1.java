package uk.co.datadisk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Main_URL_1 {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();  // returns an open connection instance, give you chance to setup connection settings

            // Make sure you do any settings immediately after openConnection otherwise you will get an error
            urlConnection.setDoOutput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line = "";

            while(line != null){
                line = inputStream.readLine();
                System.out.println(line);
            }

            System.out.println("====================================================");
            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();

            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()){
                String key = entry.getKey();
                List<String> values = entry.getValue();
                System.out.println("Key: " + key);
                for (String value : values){
                    System.out.println("\t" + value);
                }
            }

            inputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}