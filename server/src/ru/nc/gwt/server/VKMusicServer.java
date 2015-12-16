package ru.nc.gwt.server;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/music")
public class VKMusicServer{
    @GET
    @Path("/listofaudio")
    @Produces("application/json")
    public VKAudio getListOfAudio(@QueryParam("action") String kek){return new VKAudio();}

}