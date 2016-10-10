/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbean;

import dto.Usuario;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Usuario
 */
@Named(value = "inicioMBean")
@SessionScoped
public class InicioMBean implements Serializable{

    boolean logueado = false;
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void validar() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        if (usuario.getDni() != null && usuario.getDni().equals("admin") && usuario.getClave() != null
                && usuario.getClave().equals("admin")) {
            logueado = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario.getDni());
        } else {
            logueado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
                    "Credenciales no válidas");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("estaLogeado", logueado);
        if (logueado) {
            context.addCallbackParam("view", "welcomePrimefaces.xhtml");
        }
    }

    /**
     * Creates a new instance of InicioMBean
     */
    public InicioMBean() {
    }

}
