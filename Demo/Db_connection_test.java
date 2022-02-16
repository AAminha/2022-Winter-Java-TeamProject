
/*
 * DB �����ϴ� ���� �ڵ��Դϴ�.
 * ����̹� ��ġ, ������ �Ʒ� ���� ���������� �ʿ��Ͻø� �������ּ���!!
 * ��ġ: https://docs.microsoft.com/ko-kr/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
 * ����: https://docs.microsoft.com/ko-kr/sql/connect/jdbc/step-3-proof-of-concept-connecting-to-sql-using-java?view=sql-server-ver15
 */

package recipe_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Db_connection_test {
	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;" 
								+ "database=Test_DB;" 		// ����� DB �̸�
								+ "encrypt=true;trustServerCertificate=true;" 
								+ "user=sa;" 				// ������ ���� �α���
								+ "password=��й�ȣ;"; 
								
		try (Connection connection = DriverManager.getConnection(connectionUrl);) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM music"); 
			
			while (rs.next()) {
	            String s = rs.getString("singer");
	            String t = rs.getString("title");
	            System.out.println(s + " - " + t);                  
	        }  
			
			rs.close();
	        stmt.close();
	        connection.close();
	        
		} catch (SQLException e) { e.printStackTrace(); }
	}
}


