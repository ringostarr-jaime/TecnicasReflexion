/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relflectionjava;

/**
 *
 * @author Jymmy
 */
public class Lavadora {
    private String id;
private String modelo;
private String descripcion;
 
public Lavadora(String id, String modelo, String descripcion) {
super();
this.id = id;
this.modelo = modelo;
this.descripcion = descripcion;
}
public String getId() {
return id;
}
public void setId(String id) {
this.id = id;
}
public String getModelo() {
return modelo;
}
public void setModelo(String modelo) {
this.modelo = modelo;
}
public String getDescripcion() {
return descripcion;
}
public void setDescripcion(String descripcion) {
this.descripcion = descripcion;
}
}
