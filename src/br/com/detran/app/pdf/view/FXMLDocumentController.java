package br.com.detran.app.pdf.view;

import br.com.detran.app.pdf.PDF;
import br.com.detran.app.pdf.PDF_FILES;
import br.com.detran.app.util.Context;
import br.com.detran.app.util.FileManipulation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javafx.stage.DirectoryChooser;

import javafx.stage.Stage;


/**
 *
 * @author Pedro Lima
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    Label lblPercent;
    
    @FXML
    private ProgressBar fileStatusBar;
    
    @FXML
    Button btnStart;
    
    File singleFile = null;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        fileStatusBar.setProgress(0);
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Resource File");
        Stage stage = new Stage();
            singleFile = directoryChooser.showDialog(stage);
            exibirMensagem();
        if (singleFile!=null && singleFile.listFiles() != null) {
            btnStart.setDisable(false);
        }else
            btnStart.setDisable(true);
        
    }
    
    @FXML
    private void startProccessingFiles(ActionEvent event){
         try {
                PDF_FILES myFiles = new PDF_FILES();
                myFiles.recursiveSearch(singleFile);
                proccessMultipleFiles(myFiles);
                
            } catch (IOException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
    }
    
    public void proccessMultipleFiles(PDF_FILES files) throws IOException {
        int size = files.getSize();
        int index = files.getIndex();
        double max = size;
        
        for (int i = index; i < size; i++) {
            PDF file = new PDF(files.getFiles().get(i));
            file.removePages(files.returnFilePath(files.getFiles().get(i))+Context.getInstance().getMessage()+"\\");
            files.setIndex(i);
            fileStatusBar.setProgress(files.getIndex());
            lblPercent.setText(((double)(i+1)/max)*100.00+"%");
            FileManipulation.generateTemporaryFile("temp_save.det", files);
        }
        new File("temp_save.det").delete();
    }
    
     private void exibirMensagem(){
        try {
            
            Parent root = FXMLLoader.load(getClass().getResource("MensagemFrame.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Erro" +ex.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
