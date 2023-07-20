/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 *  @author fernando
 */
public class Nodo {
    //Atributos
    int dato;
    Nodo enlace;
    //Constructor
    public Nodo(){
        enlace =null;
    }
    
    public Nodo(int dato){
      this.enlace=null;
       this.dato=dato;
    }
    
    public void setDato(int dato){
        this.dato=dato;
    }
    public void setEnlace(Nodo enlace){
        this.enlace=enlace;
    } 
    

    public int getDato() {
        return dato;
    }

    public Nodo getEnlace() {
        return enlace;
    }
    
    @Override
    public String toString(){
      String s="[dato=";
      s=s+getDato();
      return s+"  | ]";
    }
    public static void main(String[] args) {
           Nodo A=new Nodo(10);
           System.out.println(A.toString());
    }
}
