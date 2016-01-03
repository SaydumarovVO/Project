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

public class VKAudio {

    public VKAudio() {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("api.vk.com").setPath("/method/audio.get")
                .setParameter("owner_id", "10245516")
                .setParameter("access_token", "4ed84896f60986f90aad68de50182e662fedecfaa68bbe3d3be916364549d714d5e1be216c1c49c6b7e42");
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
                JSONObject uniqAudio;
                for (int i = 1; i < audioList.size(); i++){
                    uniqAudio = (JSONObject) audioList.get(i);
                    System.out.println(uniqAudio.get("text"));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
