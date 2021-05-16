//import java.io.*;
import java.sql.*;
import java.util.ArrayList;
//import java.util.Scanner;


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
}
