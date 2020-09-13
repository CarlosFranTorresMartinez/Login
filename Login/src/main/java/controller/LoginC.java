package controller;

import Services.SessionUtils;
import dao.Login;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import model.Persona;

@Named(value = "loginC")
@SessionScoped
public class LoginC implements Serializable {

    Persona personalM = new Persona();

    Login dao;

    private Integer User; //Variable usuario
    private String Pass; //Variable contraseña

    public LoginC() {
        dao = new Login();
    }

    public void session() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            dao = new Login();
            personalM = dao.loginPersona(User, Pass);
            if (personalM != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", personalM);
                switch (personalM.getTIP()) {
                    case "A":
                        ec.redirect(ec.getRequestContextPath() + "/faces/admin.xhtml");
//                        ec.redirect(ec.getRequestContextPath() + "/faces/todos.xhtml");
                        break;
                    case "U":
                        ec.redirect(ec.getRequestContextPath() + "/faces/usuario.xhtml");
//                        ec.redirect(ec.getRequestContextPath() + "/faces/todos.xhtml");
                        break;
                }
            } else {
                setPass(null);
                personalM = new Persona();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage("Ingreso mal el usuario o contraseña", "o el usuario no existe"));
            }
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public void securityLogin() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        personalM = SessionUtils.obtenerObjetoSesion();
        if (personalM != null) {
            switch (personalM.getTIP()) { // Se hace las comparaciones
                case "A":
                    ec.redirect(ec.getRequestContextPath() + "/faces/admin.xhtml");
                    break;
                case "U":
                    ec.redirect(ec.getRequestContextPath() + "/faces/usuario.xhtml");
                    break;
            }
        }
    }

    /*Metodo para evitar el acceso si no has iniciado sessión*/
    public void securitySession() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        if (SessionUtils.obtenerObjetoSesion() == null) {
            ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
        }
    }


    /*Método para cerrar session e inhabilitarla*/
    public void cerrar() throws IOException {
        System.out.println("LLAMANDO AL METODO CERRAR");
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
    }

    /*Metodo para redireccionar al login*/
    public void toLogin() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.getSessionMap().clear();
        ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml");
    }

    public Persona getPersonalM() {
        return personalM;
    }

    public void setPersonalM(Persona personalM) {
        this.personalM = personalM;
    }

    public Integer getUser() {
        return User;
    }

    public void setUser(Integer User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

}
