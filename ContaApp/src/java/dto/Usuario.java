/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Usuario
 */
public class Usuario {
    private String dni;
    private String clave;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario(String dni, String clave) {
        this.dni = dni;
        this.clave = clave;
    }

    public Usuario() {
    }
    
}
