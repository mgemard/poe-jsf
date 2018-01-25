package poe.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import poe.dao.TrackDao;
import poe.jpa.Track;

@Path("tracks")
public class TrackService {

    @EJB
    private TrackDao trackDao;

    @GET
    public List<Track> list() {
        return trackDao.list();
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    public Track show(@PathParam("id") long trackId) {
        Track track = trackDao.get(trackId);
        System.out.println("the track to show " + track.getId());
        return track;
    }

    @POST
    @Path("/{title}")
    public Response add(@PathParam("title") String title, @Context UriInfo uriInfo) {
        Track track = new Track();
        track.setTitle(title);
        long trackId = trackDao.add(track);
        return Response.created(uriInfo.getBaseUriBuilder().path(TrackService.class).path(Long.toString(trackId)).build()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addJson(Track track, @Context UriInfo uriInfo) {
        long trackId = trackDao.add(track);
        return Response.created(uriInfo.getBaseUriBuilder().path(TrackService.class).path(Long.toString(trackId)).build()).build();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long trackId) {
        trackDao.delete(trackId);
    }

}
