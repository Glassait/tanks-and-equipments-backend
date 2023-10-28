package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.abstracts.GlassaitLogger;
import com.glassait.equipment_tanks.abstracts.membre.Members;
import com.glassait.equipment_tanks.abstracts.wot_api.Response;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WotService extends GlassaitLogger {

    private static String formatWoTApiUrl(String url) {
        return String.format("%s%s", "https://api.worldoftanks.eu/wot", url.replace("clanId", "500312605"));
    }

    private static HttpURLConnection getHttpURLConnection(String wotUrl, String accessToken) throws URISyntaxException, IOException {
        URI uri = new URI(wotUrl + accessToken);
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL().openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);

        return httpURLConnection;
    }

    private static Response convertURLConnectionToResponse(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return new Gson().fromJson(content.toString(), Response.class);
    }

    public Members getClanMembers() {
        try {
            HttpURLConnection httpURLConnection = getHttpURLConnection(formatWoTApiUrl("/clans/info/?application_id=d5cfa347c97b1997c50c1797e2f1cfdc&clan_id=clanId&language=fr&fields=members.account_id%2Cmembers.role"), "");

            int status = httpURLConnection.getResponseCode();
            if (status != 200) {
                super.logError("The request to wot api failed for getting all clan members with status : " + status);
                return null;
            }

            return new Gson().fromJson(convertURLConnectionToResponse(httpURLConnection).getData().get("500179430").toString(), Members.class);
        } catch (URISyntaxException | IOException e) {
            super.logError("The request to wot api failed with error: \n" + e);
            throw new RuntimeException(e);
        }
    }

    public boolean checkAccessToken(String accessToken) {
        try {
            HttpURLConnection httpURLConnection = getHttpURLConnection(formatWoTApiUrl("/clans/info/?application_id=d5cfa347c97b1997c50c1797e2f1cfdc&clan_id=clanId&fields=private&access_token="), accessToken);

            int status = httpURLConnection.getResponseCode();
            if (status != 200) {
                super.logError("The request to wot api failed with the given accessToken with status : " + status);
                return false;
            }

            return !convertURLConnectionToResponse(httpURLConnection).getStatus().equals("error");
        } catch (URISyntaxException | IOException e) {
            super.logError("The request to wot api failed with error: \n" + e);
            return false;
        }
    }
}
