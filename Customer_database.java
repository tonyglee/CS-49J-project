import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer_database {
	public static void main(String[] args) {
		createTable();
//		createCustomer("Aba", "Male", "12", "123456789", "alekjf@gijlas", "456", "123", "Oh my god");
	}
	
	public static String[][] getCustomers(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name, gender, age, phone, email, totalpoint, expiringpoint, note FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>(); //리스트와 달리 알아서 사이즈 조절 가능
			while(results.next()) { //다음 데이터가 없을때까지 데이터를 리스트에 추가
				list.add(new String[] {
						results.getString("name"),
						results.getString("gender"),
						results.getString("age"),
						results.getString("phone"),
						results.getString("email"),
						results.getString("totalpoint"),
						results.getString("expiringpoint"),
						results.getString("note")
				});
			}
			System.out.println("Data has been fetched");
			
			String[][] arr = new String[list.size()][8];
			return list.toArray(arr);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createCustomer(String name, String gender, String age, String phone, String email, String totalpoint, String expiringpoint, String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insertion = con.prepareStatement(""
					+"INSERT INTO customer"
					+"(name, gender, age, phone, email, totalpoint, expiringpoint, note) "
					+ "VALUE "
					+ "('"+name+"', '"+gender+"', '"+age+"', '"+phone+"', '"+email+"', '"+totalpoint+"', '"+expiringpoint+"', '"+note+"')");
			insertion.executeUpdate();
			System.out.println("Data Saving Succeed");
		}catch(Exception e){
			System.out.println("Problem in createCustomer");
			System.out.println(e.getMessage());
		}
	}
	
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con.prepareStatement(
					"CREATE TABLE IF NOT EXISTS "
					+ "customer(id int NOT NULL AUTO_INCREMENT,"
					+ "name varChar(255), "
					+ "gender varChar(255), "
					+ "age varChar(255), "
					+ "phone varChar(255), "
					+ "email varChar(255), "
					+ "totalpoint varChar(255), "
					+ "expiringpoint varChar(255), "
					+ "note varChar(255),"
					+ "PRIMARY KEY(id))");
			createTable.execute();
			
;		}catch(Exception e){
			System.out.println("Problem in createTable");
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Table is successfully created");
		}
	}
	public static Connection getConnection() {
		try {
			//드라이버 로딩
			String driver = "com.mysql.cj.jdbc.Driver";
			System.out.println("Driver Succeeed");
			
			//DB 연결
			String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9618359";
			String username = "sql9618359";
			String password = "aE9qKc9FaQ";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("DB Connection Succeeed");
			return con;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
