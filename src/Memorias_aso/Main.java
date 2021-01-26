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
public class Main {
    public static void main(String[] args) {
        int filaX=3;
        int filaY=3;
        int ColumnaX=5;
        int ColumnaY=3;
        int [][]matrizX={{1,0,1,0,1},{1,1,0,0,1},{1,0,1,1,0}};
        int [][]matrizY={{1,0,0},{0,1,0},{0,0,1}};  
        Matrices E1M1= new Matrices(filaX,filaY,ColumnaX,ColumnaY,3,matrizX,matrizY);
        E1M1.inicio_calcular();
        E1M1.recuperacion_A();
    }
}
