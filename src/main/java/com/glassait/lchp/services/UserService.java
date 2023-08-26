package com.glassait.lchp.services;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class UserService {

    public boolean checkAccessToken(String accessToken) {
        try {
            HttpURLConnection httpURLConnection = getHttpURLConnection(accessToken);

            int status = httpURLConnection.getResponseCode();
            if (status != 200) {
                System.err.println("The request to wot api failed for accessToken: `" + accessToken + "` with status : " + status);
                return false;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            JSONObject object = new JSONObject(content.toString());
            httpURLConnection.disconnect();

            return !object.get("status").equals("error");
        } catch (URISyntaxException | IOException e) {
            System.err.println("The request to wot api failed with error: \n" + e);
            return false;
        }
    }

    private static HttpURLConnection getHttpURLConnection(String accessToken) throws URISyntaxException, IOException {
        String urlWotApi = "https://api.worldoftanks.eu/wot/clans/info/?application_id=d5cfa347c97b1997c50c1797e2f1cfdc&clan_id=500179430&fields=private&access_token=";
        URI uri = new URI(urlWotApi + accessToken);
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);

        return httpURLConnection;
    }
}
