/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran.app.pdf;

import java.io.File;

/**
 *
 * @author PedroLima
 */
public class Print {
 public static void main(String args[]){
     
     try{
         File file = new File("pedro\\pedro.det");
         file.mkdirs();
     }catch(Exception e){
         System.out.println("Erroo "+e.getMessage());
     }
     
 }   
}
