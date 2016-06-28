package br.com.detran.app.pdf.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author PedroLima
 */

public class MensagemFrameController implements Initializable{
    
    @FXML
    TextField txtFolderName;
    @FXML 
    Button btnOk;
    
    
    @FXML
    public void okButton(){
        if(txtFolderName.getText().trim().length()>0){
        br.com.detran.app.util.Context.getInstance().setString(txtFolderName.getText());
        Stage stage = (Stage) btnOk.getScene().getWindow();
        stage.close();
        }else{
           txtFolderName.setText("Arquivos Modificados");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
