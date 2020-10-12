/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import data.LeerDatos;
import data.Patron;
import java.util.ArrayList;

/**
 *
 * @author working
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        /**distancias 
        (2.4,5.6,3)   (5,6,3) d1:
        (1,2) (6.7,7.8)  d2:
        **/
        //Patron p1 = new Patron("", "", new double[]{1,2});
        //Patron p2 = new Patron("", "", new double[]{6.7,7.8});
        //System.out.println(p2.calcularDistancia(p1)); 
        
        ArrayList<Patron> instancias = LeerDatos.tokenizarDataSet();
                
        double[] distancias = new double[instancias.size()];
        
        Patron j = new Patron("","", new double[]{2.4,3.3,5.6,7.8});
        for(int x = 0 ; x<  instancias.size();x++){
            distancias[x] =    instancias.get(x).calcularDistancia(j);
        }
                       
        System.out.println();
        // TODO: TOKENIZADOR PARA PODER SEPARAR POR COMAS Y GENERAR UN COLECCION DE PATRONES
    }
    
}
