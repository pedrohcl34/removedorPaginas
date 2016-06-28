/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.detran.app.util;

import br.com.detran.app.pdf.PDF_FILES;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PedroLima
 */
public class FileManipulation {
    public static PDF_FILES readTemporaryFile(String fileName) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(new File(fileName)));
            PDF_FILES files = (PDF_FILES) in.readObject();
            return files;
        } catch (IOException ex) {
            System.out.println("Erro: "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: "+ex.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("Erro: "+ex.getMessage());
            }
        }
        return null;
    }
    
        public static boolean generateTemporaryFile(String fileName, PDF_FILES pdfFiles) {
        try {
            
            FileWriter file = new FileWriter(fileName);
            PrintWriter pWriter = new PrintWriter(file);
            pWriter.print(pdfFiles);
            pWriter.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }

    }
    
}
