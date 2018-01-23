package poe.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/** correspond aux paramètres saisis dans la vue signup.xhtml
 * 
 */
@ManagedBean
@RequestScoped
public class UserBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private long id;
    private String email;

    private String password;
    
    

    public UserBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Method To Navigate User To The Edit Details Page And Passing Selecting School
    // Id Variable As A Hidden Value


}
