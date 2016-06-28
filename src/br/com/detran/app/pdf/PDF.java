/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran.app.pdf;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author PedroLima
 */
public class PDF implements PageDimension{
    private PDDocument document = null;
    private String fileName;
    private int number_of_pages;

    public PDF(File pdfFile) throws IOException{
        document = PDDocument.load(pdfFile);
        fileName = pdfFile.getName();
        this.number_of_pages = document.getNumberOfPages();
        
    }

    public PDDocument getDocument() {
        return document;
    }

    public void setDocument(PDDocument document) {
        this.document = document;
    }
    
    public int getPages(){
        return this.number_of_pages;
    }
    
    public void printPages(){
        for(PDPage page : document.getPages()){
            System.out.println("Altura: "+getRealHeight(page.getMediaBox().getHeight()));
            System.out.println("Largura: "+ getRealWidth(page.getMediaBox().getWidth()));
        }
    }
    
   
    public boolean removePages(String outputPath){
        PDDocument pDDocument = document;
        for(PDPage page : document.getPages()){
            if(getRealWidth(page.getMediaBox().getWidth())>240){
                pDDocument.removePage(page);
            }
        }
        if(pDDocument.getPages().getCount()!=this.getPages()){
            try {
                if(!new File(outputPath).exists())
                    new File(outputPath).mkdirs();
                pDDocument.save(new File(outputPath+this.fileName));
               
                return true;
            } catch (IOException ex) {
                System.out.println("Erro: "+ex.getMessage());
            }
        }
            
        return false;
    }

    @Override
    public float getRealWidth(float ptWidth) {
       return (float) (ptWidth*25.4 / (float)72);
    }

    @Override
    public float getRealHeight(float ptHeight) {
        return (float)(ptHeight*25.4/(float)72);
    }
}