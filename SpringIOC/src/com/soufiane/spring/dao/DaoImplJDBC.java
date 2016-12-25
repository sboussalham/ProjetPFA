package com.soufiane.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.soufiane.spring.service.Personne;

public class DaoImplJDBC implements IDao {
	public static Connection con = null;
	private String pilote = "com.mysql.jdbc.Driver";
	private String DBurl = "jdbc:mysql://localhost/PERSONNEL_DB";
	private String login = "java";
	private String password = "password";

	@Override
	public void init() {
		try {
			Class.forName(pilote);
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}

	}

	@Override
	public Collection<Personne> getAll() {
		ArrayList<Personne> pers = new ArrayList<>();

		try {
			con = DriverManager.getConnection(DBurl, login, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from personne");
			while(rs.next()){
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				//System.out.println(nom);
				Personne p = new Personne(id, nom, prenom);
				pers.add(p);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Connexion a la base de donnees echouée");
		}
		return pers;
	}

}
