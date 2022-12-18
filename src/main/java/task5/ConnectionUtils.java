package main.java.task5;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionUtils {

    public static boolean isConnection(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.getResponseCode();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
