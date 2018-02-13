/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.util.List;

/**
 *
 * @author nweld
 */
public class AddressListView {
    
    public static String html;
    public static AddressListModel db = new AddressListModel();
    
    public static String serveList() {
        
        html = "<html><body>";
        for(AddressModel address: db.addresses) {
            
            html += address.name + "<br>";
            html += address.street + "<br>";
            html += address.state + ", "+address.zip+"<br><br>";
            
        }
        html = html + "</body></html>";
        return html;
        
    }
    
    
}
