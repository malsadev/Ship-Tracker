//import java.io.*;
import java.sql.*;
import java.util.ArrayList;
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
		
		public static void populateActivityTable(Connection connection, String shipName, String charterer, String operator, String arrivalDate, String agent, String cargoType, String quantity, String consignee, String shipper, String loadPort, String loadCountry) throws SQLException {
			
			int row = 0;
			Statement queryStatement = connection.createStatement();
			Statement insertStatement = connection.createStatement();
			String sqlSelectShip = "SELECT Ship_ID FROM Ship WHERE Ship_Name ='" + shipName + "'";
			
			String sqlSelectCharterer = "SELECT Charterer_ID FROM Charterer where Charterer ='"+charterer+"'";
	        
	       
	        ResultSet result = queryStatement.executeQuery(sqlSelectShip);
	        int ship_ID = 0;
	        int charterer_ID = 0;
	        while (result.next()) {
		        ship_ID = result.getInt("Ship_ID");
		       
		    }
	        queryStatement.close();
	       
	        Statement queryStatement2 = connection.createStatement();

            ResultSet result2 = queryStatement2.executeQuery(sqlSelectCharterer);
	        
	        while (result2.next()) {
		        charterer_ID = result2.getInt("Charterer_ID");
		    }
	        
	        queryStatement2.close();
	        String sqlInsertRecord = "INSERT INTO Activity(Ship_ID, Charterer_ID) VALUES ("+ship_ID+"," + charterer_ID + ")";
	        row = insertStatement.executeUpdate(sqlInsertRecord);
	        
		} 
}
