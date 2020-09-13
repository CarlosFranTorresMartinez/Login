/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import javax.faces.context.FacesContext;
import model.Persona;

/**
 *
 * @author ctmar
 */
public class SessionUtils {


    public static Persona obtenerObjetoSesion() {
        return (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    }

//    public static Long ObtenerCodigoSesion() {
//        Persona us = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
//        if (us != null) {
//            return us.getIDPER();
//        } else {
//            return null;
//        }
//    }

}
