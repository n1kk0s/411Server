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
public class AddressView {
    
    static String html;
    
    public static String serveForm() {
        
        html = "<html><body>"
                + "<form action='/submit'>"
                + "Name: <input type='text' name='name'><br>"
                + "Street: <input type='text' name='street'><br>"
                + "State: <input type='text' name='state'><br>"
                + "Zip: <input type='text' name='zip'><br>"
                + "<input type='submit' value='Submit'><br>"
                + "</form></body></html>";
        
        return html;
        
    }
    
    public static String reServeForm(String name, String street, String state, String zip) {
        
        html = "<html><body>"
                + "<form action='/submit'>"
                + "Name: <input type='text' value='"+name+"' name='name'><br>"
                + "Street: <input type='text' value='"+street+"' name='street'><br>"
                + "State: <input type='text' value='"+state+"' name='state'><br>"
                + "Zip: <input type='text' value='"+zip+"' name='zip'><br>"
                + "<p color='red'>There was an error validating your submission</p><br>"
                + "<input type='submit' value='Submit'><br>"
                + "</form></body></html>";
        
        return html;
        
    }
    
}
