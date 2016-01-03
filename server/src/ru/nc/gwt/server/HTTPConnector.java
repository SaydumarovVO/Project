package ru.nc.gwt.server;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HTTPConnector{

    public static HttpResponse connectResponse(URIBuilder uriBuilder){
        URI uri = null;
        try{
            uri = uriBuilder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(uri);
        HttpResponse response = null;

        try{
            response = client.execute(request);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}