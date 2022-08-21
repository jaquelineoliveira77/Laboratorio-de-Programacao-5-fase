/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifsc.internacionalizacao;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author Jaqueline
 */
public class Main {
    
    public static void main(String[] args) {
       
        String idioma;
        String pais;
        
        //java - jar pacote.jar pt BR
        //java - jar pacote.jar em US
        
        if(args.length !=2){
            idioma = "en";    //pt ou em outros
            pais = "US";      //BR ou US ou outros
            
        } else{
            idioma = args[0]; //pt ou em outros
            pais = args[1];   //BR ou US ou outros
        }
        
        Locale localCorrente;
        ResourceBundle traducoes = null;
        
        localCorrente = new Locale(idioma, pais);
        //um recurso que vai ler arquivos de idiomas com objetos locale
        //MessagesBundle_pt_BR.properties
        //MessagesBundle_en_US.properties
        //src/main/resource/Messages       
        
        traducoes = ResourceBundle.getBundle("MessagesBundle", localCorrente);
        //MessagesBundle_idioma_PAIS.properties
        
        //produção - idioma para o executavél .jar
        InputStream newInputStream;
        String nomeArquivo = "./idiomas/MessagesBundle_" + idioma + "_" + pais + ".properties";
        
        try {
            newInputStream = Files.newInputStream(Paths.get(nomeArquivo));
            traducoes = new PropertyResourceBundle(newInputStream);
            
        } catch (IOException e) {
           // Logger.getLogger(TesteInternacionalizacao.class.getName()).log(Level.SEVERE, null, ex)
        }
        
        System.out.println("-->> " + traducoes.getString("cad_cliente_nome"));
        System.out.println("-->> " + traducoes.getString("cad_cliente_email"));
        
        
        
    }
    
}
