package examination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class questions {
		public static void question() throws Exception{
			  String sql1 = "SELECT rollnum FROM details ";
	            Connection con=MainConnection.getConnection();
	    		PreparedStatement smt=con.prepareStatement(sql1);
	    		ResultSet result=smt.executeQuery();
	    		result.next();
	    		int rs=result.getInt("rollnum");
		            String sql2 = "SELECT question_id, question,option1,option2,option3,option4 FROM questions";
		            Statement statement = con.createStatement();
		            ResultSet resultSet = statement.executeQuery(sql2);

		            Scanner scanner = new Scanner(System.in);
		            while (resultSet.next()) {
		                int questionId = resultSet.getInt("question_id");
		                String question = resultSet.getString("question");
		                String option1 = resultSet.getString("option1");
		                String option2 = resultSet.getString("option2");
		                String option3 = resultSet.getString("option3");
		                String option4 = resultSet.getString("option4");

		                System.out.println(question);
		                System.out.println(option1);
		                System.out.println(option2);
		                System.out.println(option3);
		                System.out.println(option4);
		                String userAnswer = scanner.nextLine();

		                String sql3 = "INSERT INTO user_answers (rollnum,question_id, user_answer) VALUES (?,?, ?)";
		                PreparedStatement preparedStatement = con.prepareStatement(sql3);
		                preparedStatement.setInt(1, rs);
		                preparedStatement.setInt(2, questionId);
		                preparedStatement.setString(3, userAnswer);
		                preparedStatement.executeUpdate();
		            }

		            String sql4 = "SELECT question_id, correct_answer FROM questions";
		            resultSet = statement.executeQuery(sql4);

		            int correctCount = 0;
		            while (resultSet.next()) {
		                int questionId = resultSet.getInt("question_id");
		                String correctAnswer = resultSet.getString("correct_answer");

		                String sql5 = "SELECT rollnum,user_answer FROM user_answers WHERE question_id = ?";
		                PreparedStatement preparedStatement = con.prepareStatement(sql5);
		                preparedStatement.setInt(1, questionId);
		                ResultSet resultSet2 = preparedStatement.executeQuery();

		                if (resultSet2.next()) {
		                    String userAnswer = resultSet2.getString("user_answer");
		                    if (userAnswer.equalsIgnoreCase(correctAnswer)) {
		                        correctCount++;
		                    }
		                }
		            }
		          
		          
		            
		           
		     
		      
		    		
		            double grade = (double) correctCount / 10 * 100;

		            String sql6= "INSERT INTO grades (rollnum,grade) VALUES (?,?)";
		            PreparedStatement preparedStatement = con.prepareStatement(sql6);
		            preparedStatement.setInt(1, rs);
		            preparedStatement.setDouble(2, grade);

		            preparedStatement.executeUpdate();
		            
		            
		            //
		            String sql7 = "SELECT rollnum,grade FROM grades where rollnum= "+rs;
		    		PreparedStatement smt1=con.prepareStatement(sql7);
		    		ResultSet rt=smt1.executeQuery();
		    		rt.next();
		    		int reg=rt.getInt("rollnum");
		    		double db=rt.getDouble("grade");
		    		System.out.println(correctCount);
		    		System.out.println("Total Grade of "+reg+" is: "+db);
		    		
		            
		           


		            // Close the resources
		            scanner.close();
		            con.close();
		            statement.close();
		            resultSet.close();
		            preparedStatement.close();

		        }

	}
