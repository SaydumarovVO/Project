package ru.nc.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import org.json.simple.JSONObject;

public class Project implements EntryPoint {

    public void onModuleLoad() {
        RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "/server-1.0-SNAPSHOT/rest/music/list?user_id=1");
        final Label label = new Label();

        builder.setCallback(new RequestCallback() {
            public void onResponseReceived(Request request, Response response) {
                label.setText(response.getText());
            }

            public void onError(Request request, Throwable exception) {Window.alert("error");}
        });

        RootPanel.get("slot").add(label);
    }
}
