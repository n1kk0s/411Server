/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nweld
 */
public class Server {
    
    public static void main(String[] args) {
        
        System.out.println("Server started");
        try (ServerSocket serverSocket = new ServerSocket(60000)) {
            
            while(true) {
                
                System.out.println("Waiting for connection......");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected to client");
                try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)){
                    
                    String inputLine;
                    while((inputLine = br.readLine()) != null) {
                        
                        // Index.html
                        if((inputLine.indexOf("/index.html") > -1)) {
                            
                            out.write("HTTP/1.1 200 OK\n\n");
                            File file = new File("C:\\Users\\nweld\\Documents\\NetBeansProjects\\411Server\\Server\\src\\main\\java\\public\\index.html");
                            String path = "C:\\Users\\nweld\\Documents\\NetBeansProjects\\411Server\\Server\\src\\main\\java\\public\\index.html";
                            if(file.isFile()) {
                                out.write(FileView.serveFile(path));
                            } else {
                                System.out.println("Not a file");
                            }
                            
                        // Address Form
                        } else if ((inputLine.indexOf("/address") >-1 )) {
                            
                            out.write("HTTP/1.1 200\n\n");
                            out.write(AddressView.serveForm());
                            System.out.println("Serve form");
                            break;
                            
                        } else if ((inputLine.indexOf("/submit") > -1)) {
                            
                            //Initialize form fields
                            String name ="";
                            String street = "";
                            String state = "";
                            String zip = "";
                            out.write("HTTP/1.1 200 OK\n\n");
                            
                            //Parse URL
                            if(inputLine.indexOf("?") >=0) {
                                
                                String[] url = inputLine.split("&");
                                String[] data = null;
                                for(int i = 0; i<url.length; i++) {
                                    
                                    String[] parts = url[i].split("=");
                                    url[i] = parts[1];
                                    System.out.println(url[i]);
                                    if(i==3) {
                                        url[i] = url[i].split(" ")[0];
                                        System.out.println(url[3]);
                                    }
                                    
                                }
                                name = url[0];
                                street = url[1];
                                state = url[2];
                                zip = url[3];
                                if(name == null || street == null || state == null || zip == null) {
                                    
                                    out.write(AddressView.reServeForm(name, street, state, zip));
                                    
                                } else {
                                    
                                    if(AddressModel.isValid(name, street, state, zip)) {
                                        
                                        AddressModel address = new AddressModel();
                                        AddressListModel addressList = new AddressListModel();
                                        addressList.setAddressList();
                                        address.name = name;
                                        address.street = street;
                                        address.state = state;
                                        address.zip = zip;
                                        addressList.add(address);
                                        addressList.saveList();
                                        out.write(ThankYouView.serveThankYou(name));
                                        
                                    } else {
                                        
                                        out.write(AddressView.reServeForm(name,street,state,zip));
                                        
                                    }
                                    
                                }
                                
                            }
                            break;
                            
                        } else if (inputLine.indexOf("/list") > -1) {
                            
                            out.write("HTTP/1.1 200 OK\n\n");
                            System.out.println("Calling the list");
                            out.write(AddressListTableView.serveTable(AddressListModel.addresses));
                            
                        } else {
                            
                            out.write("HTTP/1.1 404 Not Found\n\n");
                            
                        }
                        break;
                    }
                    
                } catch(IOException ex) {
                    // Handle exception
                }
                
            }
            
        } catch (IOException ex) {
            //Handle exceptions
        }
        
    }
}
