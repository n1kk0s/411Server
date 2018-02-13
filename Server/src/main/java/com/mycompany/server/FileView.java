/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author nweld
 */
public class FileView {
    
    public static String html;
    public static String serveFile(String path) {
        
        System.out.println("Got to serveFile()");
        File htmlFile = new File(path);
        StringBuilder contentBuilder = new StringBuilder();
        String str;
        try {
            
            BufferedReader in = new BufferedReader(new FileReader(htmlFile));
            while((str = in.readLine()) != null) {
                
                contentBuilder.append(str);
                
            }
            in.close();
            
        } catch (IOException ex) {
            
            // Log exception
            
        }
        html = contentBuilder.toString();
        return html;
        
    }
    
}
