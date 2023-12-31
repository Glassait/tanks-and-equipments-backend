package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.abstracts.member.Members;
import com.glassait.equipment_tanks.abstracts.wot_api.Response;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

@Service
@Slf4j
@RequiredArgsConstructor
public class WotService {
    @Value("${glassait.clanID}")
    private static final String CLAN_ID = "500312605";
    private static final String WOT_API_URL =
            "https://api.worldoftanks.eu/wot/clans/info/?application_id=d5cfa347c97b1997c50c1797e2f1cfdc&clan_id=" + CLAN_ID + "&language=fr";

    private static String formatWoTApiUrl(String parameter) {
        return String.format("%s%s", WOT_API_URL, parameter);
    }

    private static HttpURLConnection getHttpURLConnection(String wotUrl) throws URISyntaxException, IOException {
        URI uri = new URI(wotUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) uri.toURL()
                                                                     .openConnection();
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
            HttpURLConnection httpURLConnection = getHttpURLConnection(formatWoTApiUrl("&fields=members.account_id%2Cmembers.role"));

            int status = httpURLConnection.getResponseCode();
            if (status != 200) {
                log.error("The request to wot api failed for getting all clan members with status : " + status);
                return null;
            }

            return new Gson().fromJson(convertURLConnectionToResponse(httpURLConnection).getData()
                                                                                        .get(CLAN_ID)
                                                                                        .toString(), Members.class);
        } catch (URISyntaxException | IOException | JsonSyntaxException e) {
            log.error("The request to wot api failed with error: \n" + e);
            throw new RuntimeException(e);
        }
    }

    public boolean checkAccessToken(String accessToken) {
        try {
            HttpURLConnection httpURLConnection = getHttpURLConnection(formatWoTApiUrl("&fields=private&access_token=" + accessToken));

            int status = httpURLConnection.getResponseCode();
            if (status != 200) {
                log.error("The request to wot api failed with the given accessToken with status : " + status);
                return false;
            }

            return !convertURLConnectionToResponse(httpURLConnection).getStatus()
                                                                     .equals("error");
        } catch (URISyntaxException | IOException e) {
            log.error("The request to wot api failed with error: \n" + e);
            return false;
        }
    }
}
