//import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/*
 * 
 */

public class ToolBox {

	public static void populateShipTable (Connection connection, ArrayList<String> shipNames, ArrayList<String> owners, ArrayList<String> imoNums) throws SQLException{
		/*shipNames = removeRedundancies(shipNames);
		owners = removeRedundancies(owners);
		imoNums = removeRedundancies(imoNums);*/
		
		String sql = " INSERT INTO SHIP (Ship_Name, Imo_No, Owner) VALUES (?, ?, ? )";
		int row;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		for (int i = 0; i < shipNames.size(); i++) {
			
			preparedStatement.setString(1, shipNames.get(i));
			preparedStatement.setString(2, imoNums.get(i));
			preparedStatement.setString(3, owners.get(i));
			row = preparedStatement.executeUpdate();
			
		}
	}
		public static void populateTable (Connection connection, ArrayList<String> field, String tableName) throws SQLException{
			field = removeRedundancies(field);
			String sql = " INSERT INTO " + tableName + "(" + tableName + ") VALUES (?)";
			int row;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			for (int i = 0; i < field.size(); i++) {
				
				preparedStatement.setString(1, field.get(i));
				row = preparedStatement.executeUpdate();
				
			}
			
		
		
	}
		
		public static ArrayList<String> removeRedundancies(ArrayList<String> arrayList) {
			
			ArrayList<String> arrayList2 = new ArrayList<String>();
			
			for (int i = 0; i < arrayList.size(); i++) {
				
				if (!arrayList2.contains(arrayList.get(i))) {
					
					arrayList2.add(arrayList.get(i));
				}
				
			}
			
			return arrayList2;	
		}
		
		public static void populateActivityTable(Connection connection, String shipName, String charterer, String operator, String arrivalDate, String agent, String cargoType, String quantity, String consignee, String shipper, String loadPort, String loadCountry) throws SQLException, ParseException {
			
			int row = 0;
			Statement queryStatement = connection.createStatement();
			Statement insertStatement = connection.createStatement();
			
			String sqlSelectShip = "SELECT Ship_ID FROM Ship WHERE Ship_Name ='" + shipName + "'";
			String sqlSelectCharterer = "SELECT Charterer_ID FROM Charterer where Charterer ='"+charterer+"'";
	        String sqlSelectOperator = "SELECT Operator_ID FROM Operator where Operator ='"+operator+"'";
	        String sqlSelectAgent = "SELECT Agent_ID FROM Agent where Agent ='"+agent+"'";
	        String sqlSelectCargoType = "SELECT Cargo_Type_ID FROM Cargo_Type where Cargo_Type ='"+cargoType+"'";
	        String sqlSelectConsignee = "SELECT Consignee_ID FROM Consignee where Consignee ='"+consignee+"'";
	        String sqlSelectShipper = "SELECT Shipper_ID FROM Shipper where Shipper ='"+shipper+"'";
	        String sqlSelectLoadPort = "SELECT Load_Port_ID FROM Load_Port where Load_Port ='"+loadPort+"'";
	        String sqlSelectLoadCountry = "SELECT Load_Country_ID FROM Load_Country where Load_Country ='"+loadCountry+"'";
	       
	        ResultSet result = queryStatement.executeQuery(sqlSelectShip);
	        int ship_ID = 0;
	        int charterer_ID = 0;
	        int operator_ID = 0;
	        int agent_ID = 0;
	        int cargoType_ID = 0;
	        int consignee_ID = 0;
	        int shipper_ID = 0;
	        int loadPort_ID = 0;
	        int loadCountry_ID = 0;
	        
	        while (result.next()) {
		        ship_ID = result.getInt("Ship_ID");
		       
		    }
	        

             result = queryStatement.executeQuery(sqlSelectCharterer);
	        
	        while (result.next()) {
		        charterer_ID = result.getInt("Charterer_ID");
		    }
	        

            result = queryStatement.executeQuery(sqlSelectOperator);
	        
	        while (result.next()) {
		        operator_ID = result.getInt("Operator_ID");
		    }
	        
			 result = queryStatement.executeQuery(sqlSelectAgent);
				        
		     while (result.next()) {
			    agent_ID = result.getInt("Agent_ID");
			 }
		     
		     result = queryStatement.executeQuery(sqlSelectCargoType);
		        
		     while (result.next()) {
			    cargoType_ID = result.getInt("Cargo_Type_ID");
			 }
		     
		     result = queryStatement.executeQuery(sqlSelectConsignee);
		        
		     while (result.next()) {
			    consignee_ID = result.getInt("Consignee_ID");
			 }
		     
		     result = queryStatement.executeQuery(sqlSelectShipper);
		        
		     while (result.next()) {
			    shipper_ID = result.getInt("Shipper_ID");
			 }
		     
		     result = queryStatement.executeQuery(sqlSelectLoadPort);
		        
		     while (result.next()) {
			    loadPort_ID = result.getInt("Load_Port_ID");
			 }
		     
		     result = queryStatement.executeQuery(sqlSelectLoadCountry);
		        
		     while (result.next()) {
			    loadCountry_ID = result.getInt("Load_Country_ID");
			 }
				        
	       
	        System.out.println(arrivalDate);
	        
	        if (!arrivalDate.equals("Nil")) {

	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        Date d = sdf.parse(arrivalDate);
	        sdf.applyPattern("YYYY-MM-dd");
	        arrivalDate = sdf.format(d);
	        } else {
	        	arrivalDate = "2002-01-03";
	        }
	        
	        System.out.println(arrivalDate);
	        
	        String sqlInsertRecord = "INSERT INTO Activity(Ship_ID, Charterer_ID, Operator_ID, Arrival_Date, Agent_ID, Cargo_Type_ID, Quantity, Consignee_ID, Shipper_ID, Load_Port_ID, Load_Country_ID) VALUES ("+ship_ID+"," + charterer_ID + "," + operator_ID + ",'" + arrivalDate + "'," + agent_ID + "," + cargoType_ID + ",'" + quantity + "'," + consignee_ID + "," + shipper_ID + "," + loadPort_ID + "," + loadCountry_ID + ")";
	        row = insertStatement.executeUpdate(sqlInsertRecord);
	        
		} 
}
