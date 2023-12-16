package examination;
import java.util.*;

public class ExamModes {
	public static void examModes()throws Exception{
		Scanner sc=new Scanner(System.in);
	System.out.println("1. online mode");
    System.out.println("2. offline mode");
    int ch=sc.nextInt();
    if(ch==2) {
    	System.out.println("Three centers available to attempt in offline");
    	System.out.println("Enter center number:");
    	System.out.println("1. Swarnandhra college ");
    	System.out.println("2. vishnu college");
    	System.out.println("3. srkr college");
    	int center=sc.nextInt();
    	switch(center) {
    	case 1:
    		System.out.println("Examination Center: Swarnandhra college ,Narsapur\nExam date:1/1/2024");
    		System.out.println(".............Thank u for Visiting...........");
    		
    		break;
    	case 2: 
    		System.out.println("Examination Center: Vishnu college ,Bhimavaram\nExam date:1/1/2024");
    		System.out.println(".............Thank u for Visiting...........");
    	break;
    	case 3: 
    		System.out.println("Examination Center: srkr college ,Bhimavaram\nExam date:1/1/2024");
    		System.out.println(".............Thank u for Visiting...........");
    		break;
    	default: 
    		break;
    	}
    	
    }
    else if(ch==1) {
    	System.out.println("Ready for Exam...");
    	questions.question();
    	sc.close();
    	
    }
    else {
    	System.out.println("Invallid Option");
    }
}

}
