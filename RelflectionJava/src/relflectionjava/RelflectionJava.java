/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relflectionjava;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jymmy
 */
public class RelflectionJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //---Declaracion de listas
        List<Ordenador> lista = new ArrayList<>();
        List<Lavadora> lista2 = new ArrayList<>();

        //List<Ordenador>  lista3 = new ArrayList<>();
        //---Llenado de objetos
        Ordenador o1 = new Ordenador("A1", "Ordenador gaming", 4);
        Ordenador o2 = new Ordenador("B1", "Ordenador", 2);
        Ordenador o3 = new Ordenador("C1", "Ordenador DELL", 3);
        Ordenador o4 = new Ordenador("D1", "Ordenador ofimatica", 2);

        Lavadora l1 = new Lavadora("L1", "Standard", "Lavadora normal");
        Lavadora l2 = new Lavadora("L2", "VIP", "Lavadora avanzada");

        //--se pasan los objetos a las listas
        lista.add(o1);
        lista.add(o2);
        lista.add(o3);
        lista.add(o4);
        lista2.add(l1);
        lista2.add(l2);

        //--mando a llamar los metodos
        /*  for (int i = 0; i < 10000000; i++) {
             imprimirListaCualquiera(lista, 0);
        imprimirListaCualquiera(lista2, 1);
        }*/
        imprimirListaCualquiera(lista, 0);
        imprimirListaCualquiera(lista2, 1);
         //----LLAMADO a IMPRIMIR
            imprimirLista(generica,encabezados);    
    }

    public static List<String> generica = new ArrayList<>();
    public static List<Ordenador> Ordenadores = new ArrayList<>();
    public static List<Lavadora> Lavadoras = new ArrayList<>();
    public static List<String> encabezados = new ArrayList<String>();

    //---obtiene una lista cualquiera
    public static void imprimirListaCualquiera(List<?> lista, int salto) {

        Ordenador o = new Ordenador();
        int contador = 0;
        for (Object c : lista) {
            //---metodo reflection           
            Method[] metodos = c.getClass().getMethods();
            //----iteracion de objeto -TIPO, nombre, OBJETO
            for (Method m : metodos) {
                //System.out.println(m.getName());
                try {

                    if (m.getName().startsWith("get") && !m.getName().endsWith("Class")) {
                        if (salto > 0) {
                            System.out.println("=====Cambio de lista primer lista======\n");
                            contador=salto;
                        }

                        /*//----PRUEBAS
                        if (m.getName().equals("getId")) {
                            contador++;
                            o.setId(m.invoke(c, null).toString());
                        }
                        if (m.getName().equals("getDescripcion")) {
                            contador++;
                            o.setDescripcion(m.invoke(c, null).toString());
                        }
                        if (m.getName().equals("getPotencia")) {
                            contador++;
                            o.setPotencia((int) m.invoke(c, null));
                        }*/
                        
                        //System.out.println(m.invoke(c, null));  
                                               
                        generica.add(m.invoke(c, null).toString());    
                        salto=-1;
                        //----no repetir encabezados
                        if (encabezados.isEmpty() && contador ==0) {
                            encabezados.add(m.getName());
                            //System.out.println(" " +m.getName());
                        }else
                        {
                            if (!encabezados.contains(m.getName())) {
                                encabezados.add(m.getName());
                                  //System.out.println(" " +m.getName());
                            }
                        }
                        //System.out.println(" "+generica.size());

                    }
                    /*if (m.getName().endsWith("Class") && contador == 3) {
                        //---Fin de un objeto, inicia el llenado del otro
                        contador = 0;

                        System.out.println("");
                    }*/

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    System.out.println("ERROR " + e);
                }

            }

                   
        }

    }

    public static void imprimirLista(List<?> lista,List<String> encabezados) {
        encabezados=null;
        try {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("" + lista.get(i) );
                
                
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            //System.out.println("ERROR " + e);
        }
    }

}
