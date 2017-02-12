package com.neo4j.service;

import java.io.File;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import com.neo4j.service.test.Tutorials;

public class EntityDAO {

	GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
	GraphDatabaseService db = dbFactory.newEmbeddedDatabase(DB_PATH);

	public enum EntityLabel implements Label {
		SOFTWARE, PRODUCT, URL;
	}

	public enum DependentLabel implements Label {
		CG1PRD, DMPORD, APP;
	}

	public enum RelationshipsLabel implements RelationshipType {
		DOWNSTREAM, UPSTREAM;
	}

	private static final File DB_PATH = new File("C:/Users/ankessha/Documents/Neo4j/default.graphdb");

	public void createNode(Entity entity, JSONArray dependentList,String sysdate) {

		try (Transaction tx = db.beginTx()) {
		        String entityName=entity.getName().toUpperCase();
			    String entityType=entity.gettype().toUpperCase();
			    String entityStatus=entity.getStatus().toUpperCase();
			    String entityLastChanged=entity.getLastChanged();
			    int entityFrequncy=entity.getFrequency();
			    db.execute("MERGE (entity:"+entityType+" { Name:'"+entityName+"' }) ON CREATE SET entity.Name='"+entityName+"',entity.Status='"+entityStatus+"',entity.LastChanged='"+entityLastChanged+"',entity.Frequency="+entityFrequncy+" ON MATCH SET entity.Name='"+entityName+"',entity.Status='"+entityStatus+"',entity.LastChanged='"+entityLastChanged+"',entity.Frequency="+entityFrequncy);

			    
			   /* Iterating over dependent nodes */        
			   Iterator itr = dependentList.iterator();
				while (itr.hasNext()) {
					JSONObject json = (JSONObject) itr.next();
					System.out.println(json.get("dependentType").toString());
					
					String dependentName=json.get("dependentName").toString().toUpperCase();
				    String dependentType=json.get("dependentType").toString().toUpperCase();
				    String dependentStatus=entity.getStatus().toUpperCase();
				    String dependentLastChanged=sysdate;
				    int dependentFrequncy=2000;	
					db.execute("MERGE (entity:"+dependentType+" { Name:'"+dependentName+"' }) ON CREATE SET entity.Name='"+dependentName+"',entity.Status='"+dependentStatus+"',entity.LastChanged='"+dependentLastChanged+"',entity.Frequency="+dependentFrequncy+" ON MATCH SET entity.Name='"+dependentName+"',entity.Status='"+dependentStatus+"',entity.LastChanged='"+dependentLastChanged+"',entity.Frequency="+dependentFrequncy);
				    db.execute("MATCH (entity:"+entityType+" { Name: '"+entityName+"' }),(entity1:"+dependentType+" { Name: '"+dependentName+"' }) MERGE (entity)-[r:"+RelationshipsLabel.DOWNSTREAM+"]->(entity1)");
				   

			}
				
				
				

			
		
			tx.success();
		} catch (Exception e) {
			System.out.println(e);

		}
		db.shutdown();
		System.out.println("Done successfully");

	}

}
