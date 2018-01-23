package poe.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import poe.dao.UserDao;
import poe.jpa.User;

@Path("user")
public class UserRest {

    @EJB
    private UserDao userDao;

    @GET
    @Produces("application/json")
    @Path("/show")
    public User show(@QueryParam("id") int id) {
        return userDao.get(id);
        // User user = new User();
        // user.setEmail("mail@mail.com");
        // return user;
    }

    @DELETE
    @Path("/delete")
    public void delete(@QueryParam("id") int id) {
        userDao.delete(id);
        // User user = new User();
        // user.setEmail("mail@mail.com");
        // return user;
    }

    @POST
    @Path("/")
    public void post(@QueryParam("email") String email, @QueryParam("password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userDao.add(user);
        // User user = new User();
        // user.setEmail("mail@mail.com");
        // return user;
    }

    @POST
    @Consumes("application/json")
    @Path("/addJson")
    public void post(User user) {
        userDao.update(user);
        // User user = new User();
        // user.setEmail("mail@mail.com");
        // return user;
    }
    
    
    
    
    /*
     * 
     * GET http://localhost:8080/poe-jsf/user/show?id=42 HTTP/1.1



###

DELETE http://localhost:8080/poe-jsf/user/delete?id=42 HTTP/1.1


###


POST http://localhost:8080/poe-jsf/user?email=mail&password=pass HTTP/1.1
content-type: application/json


###


POST http://localhost:8080/poe-jsf/user/addJson HTTP/1.1
content-type: application/json

{
    "email": "mailazfa",
    "password": "secretpasswordfafa"
}*/
     */
    

}
