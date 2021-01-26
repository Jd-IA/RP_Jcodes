/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 *
 * @author asuka
 */
public class Pattern {
    
    private String clase;
    private String claseResultante;
    private double[] vectorC;//medidas
    public  ArrayList<String> cla;


    public Pattern(int n) {
        this.clase = "";
        this.claseResultante = "";
        this.vectorC = new double[n];
    }
        public Pattern(String clase) {
        this.clase = clase;

    }
    public Pattern() {

    }

    public Pattern(String clase, String claseResultante, double[] vectorC) {
        this.clase = clase;
        this.claseResultante = claseResultante;
        this.vectorC = vectorC;
    }
    // distancia euclidiana
    public double calcularDistancia (Pattern aux){
        double sumatoria = 0;
        // recorre el vector característico
        for (int x=0; x<aux.getVectorC().length;x++ ){
         sumatoria+= Math.pow(this.vectorC[x]-aux.getVectorC()[x], 2);
        }
        sumatoria = Math.sqrt(sumatoria);
        return sumatoria;
    }
    
    public ArrayList contarClases(ArrayList<Pattern> aux){//obtenemos nuestro aux de tipo patrones INSTANCIAS= AUX
        
        cla = new ArrayList<>();
        for(int i=0;i<aux.size();i++){
            cla.add(aux.get(i).getClase());        
        }
      //Creamos un objeto HashSet
        LinkedHashSet hs = new LinkedHashSet();
       
     //Lo cargamos con los valores del array, esto hace quite los repetidos
        hs.addAll(cla);
       
     //Limpiamos el array
        cla.clear();
       
     //Agregamos los valores sin repetir
        cla.addAll(hs);

    return cla;//setosa-versicolor-virginica
    }
    
    public ArrayList entrenamiento(ArrayList<Pattern> aux){//entrenamiento valores representativos promedio INSTANCIAS 150 = AUX
        
    ArrayList<Pattern> medidas=new ArrayList<>();
       
       int ncla =cla.size();//contarClases(aux).size();//3
       
       int []contC=new int[ncla];//3 va a contar cuantasveces conto a setosa 50 - versicolor 50 y virginica 50
        
        for(int i=0;i<ncla;i++){
            medidas.add(new Pattern(cla.get(i),"",new double[aux.get(0).getVectorC().length]));
        }
        //guardamos las posiciones 
        for (Pattern patron: aux){
             String nomcla = patron.getClase();//nombre de clase setosa
             int pos = cla.indexOf(nomcla);      //int pos=0;  
             guardar(patron,pos,medidas);                                                                    
             contC[pos]++;         
        }
        
        //promedios
        for (int x=0; x < medidas.size();x++){
           for (int y=0; y < medidas.get(x).getVectorC().length;y++){
                medidas.get(x).getVectorC()[y]/=contC[x];
           }
        }
        //[Iris-setosa, ,                   iris-setosa  -- 0
        //Iris-versicolor                 iris-setosa
        // Iris-virginica]                 iris-setosa
       
//       clase=contarClases(aux);
//       double promedio = 0;

        return  medidas;
    }
    
    public void guardar(Pattern aux, int p,ArrayList<Pattern> medidas){ //aux=instancias 
        
        for (int i=0; i<medidas.get(p).getVectorC().length;i++){//i<4
          medidas.get(p).getVectorC()[i]+=aux.getVectorC()[i];//2 - 3.4 - 5.6 - 1.8
        }
    }
    
    public double minDist(Pattern aux){///minima distacnia
        
        return 0;
    }
    
    public String clasificar(ArrayList<Pattern> aux, double[] dist){
        double min=99999999;
        int pos=-1;
        
        for(int i=0;i<dist.length;i++){
            if(dist[i]<min){
            min=dist[i];
            pos=i;
            }
        }
        
        String resultado= aux.get(pos).getClase();
        return resultado;
    }
    
    

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the claseResultante
     */
    public String getClaseResultante() {
        return claseResultante;
    }

    /**
     * @param claseResultante the claseResultante to set
     */
    public void setClaseResultante(String claseResultante) {
        this.claseResultante = claseResultante;
    }

    /**
     * @return the vectorC
     */
    public double[] getVectorC() {
        return vectorC;
    }

    /**
     * @param vectorC the vectorC to set
     */
    public void setVectorC(double[] vectorC) {
        this.vectorC = vectorC;
    }

    public ArrayList<String> getCla() {
        return cla;
    }


    public void setCla(ArrayList<String> cla) {
        this.cla = cla;
    }

   

  
    
    
    
    
}
