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
    
}
