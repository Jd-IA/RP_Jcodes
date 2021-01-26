/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import Clasificador.Knn;
import Clasificador.MinimaDistancia;
import HerramientasClasificadores.LeerDatos;
import HerramientasClasificadores.Patron;
import data.LeerData;
import data.Pattern;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author asuka
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Minima Distancia 
//        /**distancias 
//        (2.4,5.6,3)   (5,6,3) d1:
//        (1,2) (6.7,7.8)  d2:
//        **/
//        //Patron p1 = new Patron("", "", new double[]{1,2});
//        //Patron p2 = new Patron("", "", new double[]{6.7,7.8});
//        //System.out.println(p2.calcularDistancia(p1)); 
//        
//        ArrayList<Pattern> instancias = LeerData.tokenizarDataSet();
//        ArrayList<Pattern>  promedios= new ArrayList<>();
//        ArrayList<Pattern>  nombres= new ArrayList<>();
//
//        String res;
//        Pattern j = new Pattern();
//
//
//        nombres=j.contarClases(instancias);
//        promedios=  j.entrenamiento(instancias);
////          
////
////
////                
////        double[] distancias2 = new double[promedios.size()];
////        
////        Patron j3 = new Patron("","", new double[]{1,1.9,0,0,0.95,1});//punto a clasificar zapato
////        for(int x = 0 ; x<  promedios.size();x++){
////          distancias2[x] =    promedios.get(x).calcularDistancia(j3);
////                             //Claserepresentativos.calsificar(insatncias,j);//debe regresar un string de la clase
////        }
////        
////        res=j.clasificar(promedios ,distancias2);
//        
//        System.out.println(); 
        //KNN
        LeerDatos.leerDatos(new int[]{1,1,1,1,1,1});        
        MinimaDistancia minimadistancia = new MinimaDistancia();
        minimadistancia.entrenar(LeerDatos.instancias);
        minimadistancia.clasificar(LeerDatos.instancias);
        System.out.println(minimadistancia.getMc().toString());
        Knn knn = new Knn(3);
        knn.entrenar(LeerDatos.instancias);
        knn.clasificar((ArrayList<Patron>)LeerDatos.instancias.clone());
        System.out.println(knn.getMc().toString());        
    }
    
}
