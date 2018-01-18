package poe.jsf.validator;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class UserValidator implements Validator {


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        UIInput composantMotDePasse = (UIInput) uiComponent.getAttributes().get("password");
    }
}
