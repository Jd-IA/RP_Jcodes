/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author working
 */
public class Patron {
    
    private String clase;
    private String claseResultante;
    private double[] vectorC;//medidas

    public Patron(int n) {
        this.clase = "";
        this.claseResultante = "";
        this.vectorC = new double[n];
    }
    public Patron() {

    }
    public Patron(String clase, double[] vectorC) {
        this.clase = clase;
        this.vectorC = vectorC;
    }

    public Patron(String clase, String claseResultante, double[] vectorC) {
        this.clase = clase;
        this.claseResultante = claseResultante;
        this.vectorC = vectorC;
    }
    // distancia euclidiana
    public double calcularDistancia (Patron aux){
        double sumatoria = 0;
        // recorre el vector característico
        for (int x=0; x<aux.getVectorC().length;x++ ){
         sumatoria+= Math.pow(this.vectorC[x]-aux.getVectorC()[x], 2);
        }
        sumatoria = Math.sqrt(sumatoria);
        return sumatoria;
    }
    
    public ArrayList contarClases(ArrayList<Patron> aux){//obtenemos nuestro aux de tipo patrones INSTANCIAS= AUX
        
        ArrayList cla=new ArrayList<>();// declarams nuestro arrayList
        
        cla.add(aux.get(0).getClase());//obtenemos nuestra primer clase y la guardamos
        
        for(int i=1; i<aux.size();i++){//recorremos el arraylist donde estan la clases 
            String clase=aux.get(i).getClase();//asigamos las clases
            
            if(cla.contains(clase)==false){//si nuestro 
                cla.add(clase);
            }
        }

        
    return cla;//setosa-versicolor-virginica
    }
    
    public ArrayList entrenamiento(ArrayList<Patron> aux){//entrenamiento valores representativos promedio INSTANCIAS 150 = AUX
        
       ArrayList<Patron> medidas=new ArrayList<>();
       ArrayList<Patron> clase=new ArrayList<Patron>();
       
       clase=contarClases(aux);//setosa=0-versicolor=1-virginica =2   
       
       int ncla =contarClases(aux).size();//3
       
       int []contC=new int[ncla];//3 va a contar cuantasveces conto a setosa 50 - versicolor 50 y virginica 50
        
        for(int i=0;i<ncla;i++){
            medidas.add(new Patron(clase.get(i).getClase(),"",new double[aux.get(0).getVectorC().length]));
        }
        //guardamos las posiciones 
        for (Patron patron: aux){
             String cla = patron.getClase();//nombre de clase setosa
             int pos = clase.indexOf(cla);      //int pos=0;  
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
    
    public void guardar(Patron aux, int p,ArrayList<Patron> medidas){ //aux=instancias 
        
        for (int i=0; i<medidas.get(p).getVectorC().length;i++){//i<4
          medidas.get(p).getVectorC()[i]+=aux.getVectorC()[i];//2 - 3.4 - 5.6 - 1.8
        }
    }
    
    public double minDist(Patron aux){///minima distacnia
        
        return 0;
    }
    public ArrayList clasificar(){
    ArrayList clasificado=new ArrayList<>();
    
        return clasificado;
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
    
    
    
    
}
