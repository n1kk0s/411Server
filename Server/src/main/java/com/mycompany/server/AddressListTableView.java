/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.util.ArrayList;

/**
 *
 * @author nweld
 */
public class AddressListTableView {
    
    static String html;
    
    public static String serveTable(ArrayList<AddressModel> addressList) {
        
        html = "<html><body>";
        
        for(AddressModel address: addressList) {
            
            html += address.name + "<br>";
            html += address.street + "<br>";
            html += address.state + ", "+address.zip+"<br><br>";
            
        }
        
        html += "</body></html>";

        
        return "<html><body><p>Didn't work</p></body></html>";
        
    }
    
}
