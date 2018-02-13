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
public class AddressModel {
    
    public String name = "";
    public String street = "";
    public String state = "";
    public String zip = "";
    
    public static boolean isValid(String name,String street, String state, String zip) {
        
        int zipCode = Integer.parseInt(zip);
        if(zip.length() != 5) {
            
            return false;
            
        } else if (zipCode <=0 || zipCode >=100000) {
            
            return false;
            
        }
        return true;
        
    }
    
    // Takes AddressModel and converts and returns it as a JSON object from Jackson library
    public JSON serializeAsJSON(AddressModel address) {
        
        JSON = AddressModel
        return JSON;
        
    }
    
    // Takes JSON object from Jackson library and converts and returns it as an AddressModel
    public static AddressModel deserializeJSON(JSON j) {
        
        AddressModel = JSON
        return AddressModel;
        
    }
    
}
