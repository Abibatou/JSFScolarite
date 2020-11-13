/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abi.webstore;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;


public class DB_connexion {

	 public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	DB_connexion obj_DB_connexion= new DB_connexion();
	        		obj_DB_connexion.get_connection();
	                // Votre fonction Run
	                // Vos information de connexion à une base de données
	                
	            }
	        });
	    }
	 public Connection get_connection() {
			
			Connection connection=null;
			String BDD = "Championnat";
            String url = "jdbc:mysql://localhost:3307/" + BDD;
            String user = "root";
            String passwd = "";
            // L'essaie de connexion à votre base de donées
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connecter");
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Erreur");
                System.exit(0);
            }
			return connection;
		}
	 
}