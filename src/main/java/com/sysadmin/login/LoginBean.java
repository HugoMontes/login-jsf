package com.sysadmin.login;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Data
@Named
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;

    public String login() {
        // Validación simple (reemplaza con lógica real)
        if ("admin".equals(username) && "1234".equals(password)) {
            return "dashboard.xhtml?faces-redirect=true"; // Redirige al dashboard
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error", "Credenciales incorrectas"));
            return null; // Permanece en la página de login
        }
    }
}