package ru.nc.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.nc.gwt.server.VKMusicServer;

/**
 * Created by Валера on 05.12.2015.
 */
public class Project implements EntryPoint {

    public void onModuleLoad() {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "/server-1.0-SNAPSHOT/rest/music/listofaudio?action=makelist");

    }
}
