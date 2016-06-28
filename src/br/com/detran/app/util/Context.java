package br.com.detran.app.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PedroLima
 */
public class Context {

    private final static Context instance = new Context();
    
    public static Context getInstance(){
        return instance;
    }
    
   
    private String folderName = "";
    public String getMessage(){
        return folderName;
    }
    public void setString(String folderName){
        this.folderName = folderName;
    }
   
}
