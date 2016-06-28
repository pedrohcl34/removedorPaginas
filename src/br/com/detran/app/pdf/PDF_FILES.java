/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran.app.pdf;

import br.com.detran.app.util.FileStandards;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PedroLima
 */
public class PDF_FILES  implements Serializable,FileStandards{
    private List<File> files;
    private int index;
    private int size;
    
    public PDF_FILES(){
        this.files = new ArrayList<>();
        this.index =0;
        this.size = files.size();
    }
    
    public void recursiveSearch(File file){
        if(file.isDirectory()){
           if(file.listFiles()!=null)
                for(File singleFile: file.listFiles())
                    recursiveSearch(singleFile);
        }
        if(file.getName().contains(".pdf") || file.getName().contains(".PDF"))
            files.add(file);
        this.size = files.size();
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String returnFilePath(File file) {
        return file.getPath().replace(file.getName(), "");
    }
    
    
    
}
