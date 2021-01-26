/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clasificador;

import HerramientasClasificadores.LeerDatos;
import HerramientasClasificadores.Matriz;
import HerramientasClasificadores.Patron;
import java.util.ArrayList;

/**
 *
 * @author asuka
 */
public class Knn implements Clasificador{
    private Matriz matriz;
    private ArrayList<String> clases;
    private ArrayList<Patron> instancias;
    private int k;

    public Knn(int k) {
        this.matriz =  null;
        this.clases = new ArrayList<>();
        this.k = k;
    }
     
    
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
        this.instancias = (ArrayList<Patron>) instancias.clone();
        // generamos un arraylist de las clases involucradas
        for(Patron p: instancias){
           if(!this.clases.contains(p.getClase())){
                this.clases.add(p.getClase());
           }
       }
        
      
    }

    @Override
    public void clasificar(Patron patron) {
        instancias.sort((a, b) -> new Double(LeerDatos.calcularDistanciaEuclidiana(a, patron))
                        .compareTo(new Double(LeerDatos.calcularDistanciaEuclidiana(b, patron)))
  
        );
        int contador[] = new int[this.clases.size()];
        // clasificar en base al numero de vecinos
        for(Patron aux: this.instancias){
            int i = this.clases.indexOf(aux.getClase());
            contador[i]++;
            if(contador[i]==this.k){
                // clasificar
                patron.setClaseResultante(this.clases.get(i));
                break;
            }
        }
       // TODO: VALIDACIÓN DE K 
        
    }

    @Override
    public void clasificar(ArrayList<Patron> patrones) {
       for(Patron p: patrones){
           clasificar(p);
       }
       this.matriz = new Matriz(patrones);
    }

    /**
     * @return the mc
     */
    public Matriz getMc() {
        return matriz;
    }
    
}
