package com.neo4j.service;

import org.neo4j.graphdb.Label;

import com.neo4j.service.EntityDAO.Tutorials;

public class test {

	public enum Tutorials implements Label {
	       SOFTWARE,PRODUCT,URL;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		Tutorials label = null;
		for (Tutorials t:Tutorials.values()){
			
			   if ("SOFTWARE".equalsIgnoreCase(t.toString())){
				   label=t;
				   
			   }
		}
		System.out.println(label);
		
	}
	

}
