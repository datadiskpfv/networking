package uk.co.datadisk;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main_URI {

    public static void main(String[] args) {

        try {
            //URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");  // URL malformed
            //URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            URI uri = new URI("/catalogue/phones?os=android#samsung");          // URL malformed

            URL url = uri.toURL();
            System.out.println("URL = " + url);

//            System.out.println("Scheme = " + uri.getSchemeSpecificPart());
//            System.out.println("Scheme-Specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri .getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());



        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
    }
}
