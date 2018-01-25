package poe.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import poe.dao.UserDao;
import poe.jpa.Track;
import poe.jpa.User;

@Path("users")
public class UserService {

    @EJB
    private UserDao userDao;

    @GET
    public List<User> list() {
        return userDao.list();
    }

    @GET
    @Produces("application/json")
    @Path("{id}")
    public User show(@PathParam("id") Long userId) {
        User user = userDao.get(userId);
        System.out.println("the user to show " + user.getId());
        return user;
    }

    @POST
    @Path("/{email}/{password}")
    public Response add(@PathParam("email") String email, @PathParam("password") String password,
            @Context UriInfo uriInfo) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Long userId = userDao.add(user);
        return Response.created(uriInfo.getBaseUriBuilder().path(UserService.class).path(Long.toString(userId)).build())
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addJson(User user, @Context UriInfo uriInfo) {
        Long userId = userDao.add(user);
        return Response.created(uriInfo.getBaseUriBuilder().path(UserService.class).path(Long.toString(userId)).build())
                .build();
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long userId) {
        userDao.delete(userId);
    }

    @PUT
    @Path("{id}/{email}/{password}")
    public Response update(@PathParam("email") String email, @PathParam("password") String password,
            @PathParam("id") long userId, @Context UriInfo uriInfo) {
        User user = userDao.get(userId);
        user.setEmail(email);
        user.setPassword(password);
        userDao.update(user);
        return Response.created(uriInfo.getBaseUriBuilder().path(UserService.class).path(Long.toString(userId)).build())
                .build();
    }

    @PUT
    @Path("{userId}/tracks/{trackId}")
    public Response addTrack(@PathParam("userId") long userId, @PathParam("trackId") long trackId,
            @Context UriInfo uriInfo) {
        userDao.add(userId, trackId);
        return Response.created(uriInfo.getBaseUriBuilder().path(UserService.class).path(Long.toString(userId))
                .path("tracks").path(Long.toString(trackId)).build()).build();
    }

}
