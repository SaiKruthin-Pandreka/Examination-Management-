package examination;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class MainConnection {
		private static String url="jdbc:mysql://localhost:3306/Examination";
		private static String username="root";
		private static String password="password";
		public static Connection getConnection()throws Exception{
		return DriverManager.getConnection(url,username,password);
		
	}
	}
