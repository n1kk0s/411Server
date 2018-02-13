/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

/**
 *
 * @author nweld
 */
public class ThankYouView {
    
    public static String html;
    public static String serveThankYou(String name) {
        
        html = "<html><body>"
                + "Thank you for your submission, "+name+"!"
                + "</body></html>";
        return html;
        
    }
    
}
