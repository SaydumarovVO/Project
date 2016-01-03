package ru.nc.gwt.server;

import javax.ws.rs.*;

@Path("/music")
public class VKMusicService{
    @GET
    @Path("/list")
    @Produces("application/json")
    public VKAudio getListOfAudio(@QueryParam("user_id") String kek){return new VKAudio();}

}