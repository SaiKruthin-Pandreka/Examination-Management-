package examination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	
	public static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args)throws Exception {
		Main studentDatabase = new Main();
	
		
		boolean isRunning=true;
		while(isRunning) {
		System.out.println("Enter choice:\n1.Registration\n2.Get Hallticket\n3.Exam Modes\n4.Exit");
		int choice=Integer.parseInt(scanner.nextLine());
		
		switch(choice) {
		case 1:
			studentDatabase.insertReg();
			break;
		case 2:
			studentDatabase.hallticket();
			break;
		case 3:
			 ExamModes m = new ExamModes();
			 m.examModes();
			 break;
			
		case 4:
			System.out.println("exiting..");
			isRunning=false;
			
			break;
		}
		
		}
	}
	private void insertReg()throws Exception{
		
		String sql="insert into details (name,rollnum,email,password) values(?,?,?,?)";
		Connection con=MainConnection.getConnection();
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		System.out.println("Enter name");
		preparedStatement .setString(1,scanner.nextLine());
		
		System.out.println("Enter rollnum");
		preparedStatement .setString(2,scanner.nextLine());
		
		System.out.println("Enter email");
		preparedStatement .setString(3,scanner.nextLine());
		
		System.out.println("Enter password");
		preparedStatement .setString(4,scanner.nextLine());
		
		int rows = preparedStatement.executeUpdate();
		
		if(rows>0) {
			System.out.println("Registration sucessfull");
		}
		
	}
	
	public void hallticket() throws Exception{
		Connection con=MainConnection.getConnection();
		Statement statement=con.createStatement();
		
		System.out.println("Enter roll number for hall ticket");
		int number =Integer.parseInt(scanner.nextLine());
		


		String sql="select * from details where rollnum ="+number;


//		
//		PreparedStatement statements = con.prepareStatement(sql);
//        statements.setInt(1, number);
//        statements.setString(2, password);
//		
		
		ResultSet result = statement.executeQuery(sql);
		
		
		if(result.next()) {
			
			System.out.println("***************Hall Ticket***************");
			System.out.println("Swarnandhra College Of Engneering and Technology ");
			System.out.println("            Examination Branch                    ");
			System.out.println("Name of the student: "+result.getString("name"));
			System.out.println("Student roll number:"+result.getString("rollnum"));
			System.out.println("Student email:"+result.getString("email"));
			System.out.println("Subject:Programming in java");
			System.out.println("*****************************************");
				
		}else {
			System.out.println("No hallticket found..");
		}
		
	}

}
