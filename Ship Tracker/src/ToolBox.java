//import java.io.*;
import java.sql.*;
import java.util.ArrayList;
//import java.util.Scanner;


/*
 * 
 */

public class ToolBox {

	public static void populateShipTable (Connection connection, ArrayList<String> shipNames, ArrayList<String> owners, ArrayList<String> imoNums) throws SQLException{
		
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
}
