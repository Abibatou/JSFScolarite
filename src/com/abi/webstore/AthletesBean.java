package com.abi.webstore;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean /*("athletesBean")*/ 
@RequestScoped
public class AthletesBean {
	private String id;
	private String nom;
	private String auteur;
	private String dateDePublication;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getDateDePublication() {
		return dateDePublication;
	}
	public void setDateDePublication(String dateDePublication) {
		this.dateDePublication = dateDePublication;
	}
	
	
	public ArrayList getGet_all_athletes(){
		ArrayList list_of_articles= new ArrayList();
		try {
			
			
			Connection connection=null;
			DB_connexion obj_DB_connexion= new DB_connexion();
			connection=obj_DB_connexion.get_connection();
			Statement st=connection.createStatement();
			ResultSet rs=st.executeQuery("select * from articles");
			while (rs.next()) {
				AthletesBean obj_AthletesBean= new AthletesBean();
				obj_AthletesBean.setId(rs.getString("id"));
				obj_AthletesBean.setNom(rs.getString("nom"));
				obj_AthletesBean.setAuteur(rs.getString("auteur"));
				obj_AthletesBean.setDateDePublication(rs.getString("dateDePublication"));
				
				list_of_articles.add(obj_AthletesBean);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return list_of_articles;
	}
	
	
	public void add_athletes(){
		
		try {
					
			Connection connection=null;
			DB_connexion obj_DB_connexion= new DB_connexion();
			connection=obj_DB_connexion.get_connection();
			PreparedStatement ps=connection.prepareStatement("insert into articles (nom) value ('"+nom+"')");
			ps.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	public AthletesBean() {
		
	}
	

	
}
