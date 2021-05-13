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
	    
		
		
		
		
		String shipName, imoNo, owner, charterer, operator, arrivalPort, arrivalDate,agent, cargoType, quantity, consignee, shipper, loadPort, loadCountry;
		int row;
		String sqlInsert = "";
	    int count = 0;
		while (fileReader.hasNext()) {
			count++;
			shipName = fileReader.next().trim();
			System.out.println(shipName);
			imoNo = fileReader.next();
			System.out.println(imoNo);
			owner = fileReader.next();
			System.out.println(owner);
			sqlInsert = "INSERT INTO Ship (Ship_Name, Imo_No, Owner)" +
			"VALUES('" + shipName + "', '" + imoNo + "', '" + owner + "')";
	
			Statement statement = connection.createStatement();
			
			
			
			row = statement.executeUpdate(sqlInsert);
			
			
			charterer = fileReader.next();
			System.out.println(charterer);
			operator = fileReader.next();
			System.out.println(operator);
			arrivalPort = fileReader.next();
			System.out.println(arrivalPort);
			arrivalDate = fileReader.next();
			System.out.println(arrivalDate);
			agent = fileReader.next();
			System.out.println(agent);
			cargoType = fileReader.next();
			System.out.println(cargoType);
			quantity = fileReader.next();
			System.out.println(quantity);
			consignee = fileReader.next();
			System.out.println(consignee);
			shipper = fileReader.next();
			System.out.println(shipper);
			loadPort = fileReader.next();
			System.out.println(loadPort);
			loadCountry = fileReader.next();
			System.out.println(loadCountry);
			
			//sqlInsert = "INSERT INTO Charter (Charter_Name) VALUES(?)";
			
		}
		
		
		
		
		
		fileReader.close();
		
	}

}
