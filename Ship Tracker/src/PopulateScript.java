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
	    
		//put all values in String arrayLists
		ArrayList<String> shipNames = new ArrayList<String>();
		ArrayList<String> ImoNums = new ArrayList<String>();
		ArrayList<String> shipOwners = new ArrayList<String>();
		
		
		while (fileReader.hasNext()) {
			token = fileReader.next();
			System.out.println(token);
		}
		
		 String sql = "INSERT INTO Ship (Ship_Name, Imo_No, Owner) VALUES (?, ?, ?)";
         
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setString(1, "Jim Rohn");
         preparedStatement.setString(2, "rohnj@herbalife.com");
         preparedStatement.setString(3, "0919989998");
		
		
		
		fileReader.close();
		
	}

}
