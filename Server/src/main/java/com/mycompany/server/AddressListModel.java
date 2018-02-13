/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nweld
 */
public class AddressListModel {
    
    public ArrayList<AddressModel> addresses = new ArrayList<>();

    public void add(AddressModel address) {
        
        addresses.add(address);
        
    }
    
    // Takes AddressListModel and converts and returns it as a JSON object from Jackson library
    public JSON serializeAsJSON(AddressListModel addresses) {
        
        JSON = AddressListModel
        return JSON;
        
    }
    
    // Takes JSON object from Jackson library and converts and returns it as an AddressModel
    public static AddressListModel deserializeJSON(JSON j) {
        
        AddressListModel = JSON
        return AddressListModel;
        
    }
    
    // Takes JSON object from Jackson library and writes it to a file
    public void saveJSONToFile(JSON j) {
        
        read JSON from file
        append new JSON
        write JSON to file
        
    }
    
    // Takes File object and returns JSON object from Jackson library
    public AddressListModel readJSONFromRile(File file) {
        
        return AddressListModel;
        
    }
    
}
