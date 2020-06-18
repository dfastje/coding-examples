package me.dfastje.restconsumptionproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ExampleController {

    @GetMapping("/example-endpoint")
    public String exampleEndpoint(){
        String exampleEndpointString = "example-endpoint";
        System.out.println(exampleEndpointString);
        return exampleEndpointString;
    }

    @GetMapping("/endpoint-eater")
    public String endpointEater(){
        String endpointEaterString = "endpoint-eater";
        System.out.println(endpointEaterString);

        //Code sample from https://stackoverflow.com/questions/12916169/how-to-consume-rest-in-java
        try {
            URL url = new URL("http://localhost:8080/example-endpoint");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println("Output from endpoint: " + output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in endpoint: " + e);
        }

        return endpointEaterString;
    }
}
