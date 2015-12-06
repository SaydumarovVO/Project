package ru.nc.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Created by Валера on 05.12.2015.
 */
public class Project implements EntryPoint {

    public void onModuleLoad() {
        Button button = new Button();
        RootPanel.get().add(button);

        final String kek = "паровозик";

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                GenServer.App.getInstance().generate(kek, new AsyncCallback<String>(){

                    public void onFailure(Throwable caught) {

                    }

                    public void onSuccess(String result) {
                        Window.alert(result);
                    }
                });
            }
        });


    }
}
