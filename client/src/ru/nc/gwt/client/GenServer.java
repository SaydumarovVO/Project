package ru.nc.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * Created by Валера on 05.12.2015.
 */
@RemoteServiceRelativePath("generator")
public interface GenServer extends RemoteService {
    String generate(String word);
    /**
     * Utility/Convenience class.
     * Use GenServer.App.getInstance() to access static instance of GenServerAsync
     */
    public static class App {
        private static final GenServerAsync ourInstance = (GenServerAsync) GWT.create(GenServer.class);

        public static GenServerAsync getInstance() {
            return ourInstance;
        }
    }
}
