package com.neo4j.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.json.JSONArray;
import org.json.JSONObject;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Path("/service")
public class Neo4JService {
	   private static final String SUCCESS_RESULT="success";
	   private static final String FAILURE_RESULT="failure";
	   EntityDAO entityDAO;
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   Date date;
	   String sysdate;
	   JSONArray dependentList;
	   
	   
	   public Neo4JService() {
		
		   entityDAO= new EntityDAO();
           date = new Date();
           sysdate=dateFormat.format(date);
		  
	   }



	@POST
	   @Path("/createnode")
	   @Produces(MediaType.TEXT_PLAIN)
	   public String createNode(String input) throws IOException{
		  
		   JSONObject jsonObj = new JSONObject(input);
		   System.out.println(jsonObj);
		   Entity entity=new Entity(((JSONObject) jsonObj.get("entity")).get("entityName").toString(),((JSONObject) jsonObj.get("entity")).get("entityType").toString(),"1",sysdate,1000);
		   dependentList=jsonObj.getJSONArray("dependentList");
		   entityDAO.createNode(entity,dependentList,sysdate);
		   return SUCCESS_RESULT;
		      

	     
	      
	   }

}
