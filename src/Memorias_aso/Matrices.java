/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memorias_aso;

/**
 *
 * @author Gerardo
 */
public class Matrices {
    int operaciones;
    int filas_X,columnas_X;
    int filas_Y,columnas_Y;
    int numero_entrenamiento;
    int MemoriaXY[][];
    int arreglos_X[][],arreglos_Y[][];
    int recorrido;
    int X,Y;
    public Matrices(int fX,int fY,int cx,int cy,int oper,int valoresX[][],int valoresY[][]){
        operaciones=oper;
        filas_X=fX;
        filas_Y=fY;
        columnas_X=cx;
        columnas_Y=cy;
        arreglos_X=valoresX;
        arreglos_Y=valoresY;
        if(filas_X >= filas_Y){
            X=filas_X;
            if(columnas_X == columnas_Y){
                MemoriaXY=new int[filas_X][columnas_X];
                recorrido=filas_X*columnas_X;
                Y=columnas_X;
            }else if(columnas_X <= columnas_Y){
                MemoriaXY=new int[filas_X][columnas_Y];
                recorrido=filas_X*columnas_Y;
                Y=columnas_Y;
            }else if(columnas_X >= columnas_X){
                MemoriaXY=new int[filas_X][columnas_X];
                recorrido=filas_X*columnas_X;
                Y=columnas_X;
            }
        }else if(filas_X <= filas_Y){
            X=filas_Y;
            if(columnas_X == columnas_Y){
                 MemoriaXY=new int[filas_Y][columnas_X];
                 recorrido=filas_Y*columnas_X;
                 Y=columnas_X;
            }else if(columnas_X <= columnas_Y){
                 MemoriaXY=new int[filas_Y][columnas_Y];
                 recorrido=filas_Y*columnas_Y;
                 Y=columnas_Y;
            }else if(columnas_X >= columnas_Y){
                 MemoriaXY=new int[filas_Y][columnas_X];
                 recorrido=filas_Y*columnas_X;
                 Y=columnas_X;
            }
        }else if(filas_X == filas_Y){
            if(columnas_X == columnas_Y){
                 MemoriaXY=new int[filas_Y][columnas_X];
                 recorrido=filas_Y*columnas_X;
            }else if(columnas_X <= columnas_Y){
                 MemoriaXY=new int[filas_Y][columnas_Y];
                 recorrido=filas_Y*columnas_Y;
            }else if(columnas_X >= columnas_Y){
                 MemoriaXY=new int[filas_Y][columnas_X];
                 recorrido=filas_Y*columnas_X;
            }
        }
    }
    public int[][] inicio_calcular(){
    llenar_matriz();
    int conteo_aux=0;
    int i=0,j=0,k=0,l=0,aux=0;
    for(k=0;k<columnas_Y;k++){
        for(i=0;i<filas_Y;i++){
            for(j=0;j<columnas_X;j++){
                if(conteo_aux==recorrido){
                    aux++;                   
                    conteo_aux=0;
                }  
                if(arreglos_Y[i][k]== 1 && arreglos_X[aux][j]==1){
                    MemoriaXY[i][j]+=1;
                    conteo_aux++;
//                        System.out.println("Y="+arreglos_Y[i][k]+",i="+1+"k="+k);
//                        System.out.println("X="+arreglos_X[aux][j]+",aux="+aux+"j="+j);
//                        System.out.println(MemoriaXY[i][j]);
//                        System.out.println(conteo_aux);
                   
                    }else if(arreglos_Y[i][k]== 0 && arreglos_X[aux][j]==1){
                        MemoriaXY[i][j]=MemoriaXY[i][j];
                        conteo_aux++;
//                        System.out.println("Y="+arreglos_Y[i][k]+",i="+1+"k="+k);
//                        System.out.println("X="+arreglos_X[aux][j]+",aux="+aux+"j="+j);
//                        System.out.println(MemoriaXY[i][j]);
//                        System.out.println(conteo_aux);
                    }else if(arreglos_Y[i][k]== 1 && arreglos_X[aux][j]==0){
                     MemoriaXY[i][j]-=1;
                     conteo_aux++;
//                        System.out.println("Y="+arreglos_Y[i][k]+",i="+1+"k="+k);
//                        System.out.println("X="+arreglos_X[aux][j]+",aux="+aux+"j="+j);
//                        System.out.println(MemoriaXY[i][j]);
//                        System.out.println(conteo_aux);
                    }else if(arreglos_Y[i][k]== 0 && arreglos_X[aux][j]==0){
                        MemoriaXY[i][j]=MemoriaXY[i][j];
                        conteo_aux++;
//                        System.out.println("Y="+arreglos_Y[i][k]+",i="+1+"k="+k);
//                        System.out.println("X="+arreglos_X[aux][j]+",aux="+aux+"j="+j);
//                        System.out.println(MemoriaXY[i][j]);
//                        System.out.println(conteo_aux);
                }
            }            
        }
    }
    imprimir(MemoriaXY);
    return MemoriaXY;
    }
    public void recuperacion_A(){
        int i=0,j=0,k=0;
        int contador= 0;
        int[][]aux=getMemoriaXY();
        int[][]recuperacion=new int[X][X];
        for(k=0;k<operaciones;k++){
            contador=0;
            for(i=0;i<X;i++){
                for(j=0;j<Y;j++){
                   // System.out.println("antes-valor aux="+aux[i][j]);
                    contador+=aux[i][j]*arreglos_X[k][j];
                   // System.out.println("valor aux="+aux[i][j]+"valor arregloX="+arreglos_X[k][j]);
                }
             recuperacion[k][i]=contador;
             System.out.println("contador="+contador);
             contador=0;
            }
        }
       imprimir2(recuperacion);
    }
    
    public void llenar_matriz(){
    int i=0,j=0;
    int[][]aux=getMemoriaXY();
    while (i < aux.length) {
            aux[i][j]=0;
            //System.out.println(aux[i][j]);
 
            if (j == aux[0].length - 1) {
                i++;
                j = 0;
            } else {
                j++;
            }
        }
        setMemoriaXY(aux);
    }
    public void imprimir(int [][]matriz){
    System.out.println("////////////////////");
    int i=0,j=0;
    int[][]aux=matriz;
    
        for(int f=0;f<aux.length;f++) {
            for(int c=0;c<aux[f].length;c++) {
                System.out.print(aux[f][c]+" ");
            }
            System.out.println();
        }
    
    /*while (i < aux.length) {
            //aux[i][j]=0;
            System.out.println(" "+aux[i][j]);
    
 
            if (j == aux[0].length - 1) {
                i++;
                j = 0;
            } else {
                j++;
            }
        }*/
        //setMemoriaXY(aux);
    }
    public void imprimir2(int [][]matriz){
    System.out.println("////////////////////");
    int[][]aux=matriz;    
        for (int i = 0; i < aux.length; i++){
            for (int j = 0; j < aux.length; j++) {
                System.out.print(" " +aux[i][j]);
            }
            System.out.println();
        }
    }

    public int getFilas_X() {
        return filas_X;
    }

    public int getColumnas_X() {
        return columnas_X;
    }

    public int getFilas_Y() {
        return filas_Y;
    }

    public int getColumnas_Y() {
        return columnas_Y;
    }

    public int getNumero_entrenamiento() {
        return numero_entrenamiento;
    }


    public int[][] getArreglos_X() {
        return arreglos_X;
    }

    public void setArreglos_X(int[][] arreglos_X) {
        this.arreglos_X = arreglos_X;
    }

    public int[][] getArreglos_Y() {
        return arreglos_Y;
    }

    public void setArreglos_Y(int[][] arreglos_Y) {
        this.arreglos_Y = arreglos_Y;
    }
    public int[][] getMemoriaXY() {
        return MemoriaXY;
    }

    public void setMemoriaXY(int[][] MemoriaXY) {
        this.MemoriaXY = MemoriaXY;
    }
   
}
