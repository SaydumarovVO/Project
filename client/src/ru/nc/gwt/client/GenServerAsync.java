package ru.nc.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by Валера on 05.12.2015.
 */
public interface GenServerAsync {
    void generate(String word, AsyncCallback<String> asyncCallback);
}
