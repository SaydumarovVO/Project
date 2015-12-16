package ru.nc.gwt.server;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Валера on 13.12.2015.
 */
public class VKAudio {

    public VKAudio() {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.vk.com").setPath("/method/audio.get")
                .setParameter("owner_id", "10245516")
                .setParameter("access_token", "7759b536c7107be30eab3b061192be23aa2f127bd78d289be3c74cfab4ade92a6baa9fa973e7c8d80818c");
        HttpResponse response = HTTPConnector.connectResponse(uriBuilder);
        Integer status = response.getStatusLine().getStatusCode();

        if (status == 200){
            StringWriter content = new StringWriter();

            try{
                IOUtils.copy(response.getEntity().getContent(), content);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONParser parser = new JSONParser();
            try{
                JSONObject jsonResp = (JSONObject) parser.parse(content.toString());
                JSONArray  audioList = (JSONArray) jsonResp.get("response");
                JSONObject unicAudio;
                for (int i = 1; i < audioList.size(); i++){
                    unicAudio = (JSONObject) audioList.get(i);
                    System.out.println(unicAudio.get("text"));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
