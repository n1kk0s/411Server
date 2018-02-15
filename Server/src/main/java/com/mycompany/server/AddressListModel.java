/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nweld
 */
public class AddressListModel {
    
    public static ArrayList<AddressModel> addresses = new ArrayList<>();
    public static ObjectMapper mapper = new ObjectMapper();
    public static ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
    public static File file = new File("C:\\Users\\nweld\\Documents\\NetBeansProjects\\411Server\\Server\\src\\main\\java\\public\\addresses.json");

    public void add(AddressModel address) {
        
        addresses.add(address);
        
    }
    
    // Takes AddressListModel and converts and returns it as a JSON object from Jackson library
    public String serializeAsJSON(ArrayList<AddressModel> addresses) throws JsonProcessingException {
        
        String jsonArray = mapper.writeValueAsString(addresses);
        return jsonArray;
        
    }
    
    // Takes JSON object from Jackson library and converts and returns it as an AddressModel
    public static ArrayList<AddressModel> deserializeJSON(String jsonArray) throws JsonProcessingException, IOException {
        
        TypeReference<ArrayList<AddressModel>> mapType = new TypeReference<ArrayList<AddressModel>>() {};
        ArrayList<AddressModel> addressList = mapper.readValue(jsonArray, mapType);
        return addressList;
        
    }
    
    // Takes JSON object from Jackson library and writes it to a file
    public void saveJSONToFile(String jsonArray) throws IOException {
        
        writer.writeValue(file, jsonArray);
        
    }
    
    // Takes File object and returns JSON object from Jackson library
    public String readJSONFromFile() throws IOException {
        
        if(file.isFile()) {

            String jsonArray = mapper.readValue(file, String.class);
            return jsonArray;
            
        } else {
        
            return null;
            
        }
        
    }
    
    public void setAddressList() throws IOException {
        
        System.out.println("Setting List");
        addresses = deserializeJSON(readJSONFromFile());
        
    }
    
    public void saveList() throws JsonProcessingException, IOException {
        
        saveJSONToFile(serializeAsJSON(addresses));
        
    }
    
}
