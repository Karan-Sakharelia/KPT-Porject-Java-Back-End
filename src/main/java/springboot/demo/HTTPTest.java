package springboot.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HTTPTest {

    private static final String USER_AGENT = "Mozilla/5.0";

    private static final String GET_URL = "https://finnhub.io/api/v1/stock/symbol?exchange=US&token=bqng6svrh5re7283mceg";


    public static void main(String[] args) throws IOException {

        sendGET();
        System.out.println("GET DONE");
    }

    private static void sendGET() throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();

        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, Object>> jsonMap = mapper.readValue(con.getInputStream(), List.class);
            System.out.println(jsonMap);
            // print result
        } else {
            System.out.println("GET request not worked");
        }

    }
}
