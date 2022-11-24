import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

		if(args.length != 1) {
			System.out.println("Please provide proper number of arguments");
			System.exit(1);
		}
		else{
			// Check arguments
			if(args[0].equals("a")) {
				System.out.println("Loading data ...");			
				try {
					String studentsNameInSingleString = readFromFile("students.txt");
					String studentsNames[] = studentsNameInSingleString.split(",");			
					for(String studentName : studentsNames) { 
						System.out.println(studentName.trim()); 
					}
				} catch (Exception e){

				} 
				System.out.println("Data Loaded.");
			}
			else if(args[0].equals("r")) {
				System.out.println("Loading data ...");			
				try {
					String studentsNameInSingleString = readFromFile("students.txt");
					String studentsNames[] = studentsNameInSingleString.split(",");	
					Random random = new Random();
					int randomIndexForStudentSelection = random.nextInt(studentsNames.length);
					System.out.println(studentsNames[randomIndexForStudentSelection].trim());
				} catch (Exception e){

				} 
				System.out.println("Data Loaded.");			
			}
			else if(args[0].contains("+")){
				System.out.println("Loading data ...");			
				try {
				String newStudentName = args[0].substring(1);
				Date date = new Date();
				String dateFormatInString = "dd/MM/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateFormatInString);
				String formattedDate= dateFormat.format(date);
				writeToFile("students.txt", ", "+newStudentName+"\nList last updated on "+formattedDate);
				} catch (Exception e){

				}
				System.out.println("Data Loaded.");	
			}
			else if(args[0].contains("?")) {
				System.out.println("Loading data ...");			
				try {
					String studentsNameInSingleString = readFromFile("students.txt");
					String studentsNames[] = studentsNameInSingleString.split(",");	
					boolean done = false;
					String studentName = args[0].substring(1);
					for(int index = 0; index<studentsNames.length && !done; index++) {
						if(studentsNames[index].equals(studentName)) {
							System.out.println("We found it!");
							done=true;
						}
					}
				} catch (Exception e){

				} 
				System.out.println("Data Loaded.");				
			}
			else if(args[0].contains("c")) {
				System.out.println("Loading data ...");			
				try {
					String studentsNameInSingleString = readFromFile("students.txt");
					char charactersInStudentsNames[] = studentsNameInSingleString.toCharArray();			
					boolean isWord = false;
					int count=0;
					for(char character:charactersInStudentsNames) {
						if(character ==' ') {
							if (!isWord) {	
								count++; 
								isWord =true;	
							}
							else { 
								isWord=false;
							}			
						}
					}
					System.out.println(count +" word(s) found " );
				} catch (Exception e){

				} 
				System.out.println("Data Loaded.");				
			}
		}
	}

	public static String readFromFile(String fileName){
		try{
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileName))); 
			String fileContent = bufferedReader.readLine();
			bufferedReader.close();
			return fileContent;
		} catch(Exception e){
			System.out.println("Error reading from file");
		}
		return "";
	}

	public static void writeToFile(String fileName, String content){
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(fileName, true));
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch(Exception e){
			System.out.println("Error writing to file");
		}
	}
}