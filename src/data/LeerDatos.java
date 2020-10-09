/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author working
 */
public class LeerDatos {
    
    public static ArrayList<Patron> tokenizarDataSet(String nom){
        StringTokenizer tokens;
        File archivo;
        FileReader fr;
        BufferedReader br;
        ArrayList al = new ArrayList();
        try{
            archivo=new File(nom);
            fr= new FileReader(archivo);
            br= new BufferedReader(fr);
            
            String linea, temp;

            while((linea=br.readLine())!=null){
                tokens = new StringTokenizer (linea,",");
                    while(tokens.hasMoreTokens()){
                        temp=tokens.nextToken();
                           System.out.println(temp);
                    }
                
            }
            br.close();
            fr.close();
            
        }catch(Exception e){
        }
        
        
        
        


    
    return al;
    }
    
    
    public static void main(String ags[]){

        LeerDatos l1= new LeerDatos();
        l1.tokenizarDataSet("iris.txt");
    
    }
}
