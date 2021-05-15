/*
 * Program Name: PopulateScript.java
 * Purpose: Populates a specifically designed access database that keeps track of ships and their cargo (Aden)
 * Author: Mustafa Al-Sakkaf
 * Date: May 12, 2021
 */



import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class PopulateScript {

	public static void main(String[] args) throws SQLException, FileNotFoundException {
		
		String databaseURL = "jdbc:ucanaccess://ShipTracker.accdb";
		Connection connection = DriverManager.getConnection(databaseURL);
		
		File myFile = new File ("Aden Port Volume jan.csv");
		
		Scanner fileReader = new Scanner (myFile);
		String  token = "";
		
		fileReader.useDelimiter("\n");
		
		while (fileReader.hasNext()) {
			token = fileReader.next();
			
			if (token.contains("Jan")) {
				token =  fileReader.next();
				break;
			}
			//System.out.println(token);
		}
		
		fileReader.useDelimiter(",");
	    
		ArrayList<String> shipNames = new ArrayList <String>();
		ArrayList<String> imoNums = new ArrayList <String>();
		ArrayList<String> owners = new ArrayList <String>();
		ArrayList<String> charterers = new ArrayList <String>();
		ArrayList<String> operators = new ArrayList <String>();
		ArrayList<String> arrivalDates = new ArrayList <String>();
		ArrayList<String> agents = new ArrayList <String>();
		ArrayList<String> cargoTypes = new ArrayList <String>();
		ArrayList<String> quantities = new ArrayList <String>();
		ArrayList<String> consignees = new ArrayList <String>();
		ArrayList<String> shippers = new ArrayList <String>();
		ArrayList<String> loadPorts = new ArrayList <String>();
		ArrayList<String> loadCountries = new ArrayList <String>();
		
		int count = 0;
		String shipName, imoNo, owner, charterer, operator, arrivalPort, arrivalDate,agent, cargoType, quantity, consignee, shipper, loadPort, loadCountry;
		while (fileReader.hasNext()) {
	        
			if (count%12 == 0) {
				shipName = fileReader.next().trim();
				shipNames.add(shipName);
				imoNo = fileReader.next();
				imoNums.add(imoNo);
				owner = fileReader.next();
				owners.add(owner);
				charterer = fileReader.next();
				charterers.add(charterer);
				operator = fileReader.next();
				operators.add(operator);
				
				arrivalPort = fileReader.next();// default arrival port is already specified in the database
			
				arrivalDate = fileReader.next();
				arrivalDates.add(arrivalDate);
				agent = fileReader.next();
				agents.add(agent);
				cargoType = fileReader.next();
				cargoTypes.add(cargoType);
				quantity = fileReader.next();
				quantities.add(quantity);
				consignee = fileReader.next();
				consignees.add(consignee);
				shipper = fileReader.next();
				shippers.add(shipper);
				loadPort = fileReader.next();
				loadPorts.add(loadPort);
				fileReader.useDelimiter("\n");
				loadCountry = fileReader.next();
				loadCountries.add(loadCountry);
				fileReader.useDelimiter(",");
				
	         }	
			
			 if (count%11 == 0 && count > 0 ) {
				
				 fileReader.nextLine();
				
			 } 
	         count++;
			
		}
		
		
		
		ToolBox.populateShipTable(connection, shipNames, owners, imoNums);
	    
		
		 
		fileReader.close();
		
	}

}
