package com.example.Mercado_POO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
@Component
public class MudarPorta implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    
   @Override
   public void customize(TomcatServletWebServerFactory factory) {
	   int porta = 4343;
	   /*try {
           FileInputStream arquivo = new FileInputStream("/cummins.txt");
           InputStreamReader input = new InputStreamReader(arquivo);
           BufferedReader buffer = new BufferedReader(input);
           String linha;
           do{
               linha = buffer.readLine();
               if(linha != null){
                   String[] palavras = linha.split("#");
                   porta = Integer.parseInt(palavras[3]);
               }                    
           }while(linha != null);
       } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Não foi possivel alterar a porta do serviço! " + ex);
       }*/
       factory.setPort(porta);
   }
}
