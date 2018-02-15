/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author nweld
 */
public class AddressModel {
    
    public String name = "";
    public String street = "";
    public String state = "";
    public String zip = "";
    public static ObjectMapper mapper = new ObjectMapper();
    
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
    public JsonNode serializeAsJSON(AddressModel address) {
        
        JsonNode node = mapper.valueToTree(address);
        return node;
        
    }
    
    // Takes JSON object from Jackson library and converts and returns it as an AddressModel
    public static AddressModel deserializeJSON(JsonNode node) throws JsonProcessingException {
        
        AddressModel address = mapper.treeToValue(node, AddressModel.class);
        return address;
        
    }
    
}
