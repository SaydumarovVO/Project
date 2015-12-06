package ru.nc.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.nc.gwt.client.GenServer;

/**
 * Created by Валера on 05.12.2015.
 */
public class GenServerImpl extends RemoteServiceServlet implements GenServer {
    public String generate(String word) {
        String drow = new String();
        for (int i = word.length(); i>=1; i--){
            drow += word.charAt(i-1);
        }
        return drow;
    }
}