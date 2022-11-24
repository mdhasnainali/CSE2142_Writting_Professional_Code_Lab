import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		if(args.length != 1) {
			System.out.println(Constants.ERROR_MESSAGE_FOR_INVALID_NO_OF_ARGUMENTS);
			System.exit(1);
		}
		else{
			// Check arguments
			if(args[0].equals(Constants.CHAR_A)) {
				System.out.println(Constants.MESSAGE_FOR_LOADING_DATA);			
				try {
					String studentsNameInSingleString = readFromFile(Constants.FILE_NAME);
					String studentsNames[] = studentsNameInSingleString.split(Constants.COMMA);
					for(String studentName : studentsNames) { 
						System.out.println(studentName.trim()); 
					}
				} catch (Exception e){

				} 
				System.out.println(Constants.MESSAGE_FOR_DATA_LOADED);
			}
			else if(args[0].equals(Constants.CHAR_R)) {
				System.out.println(Constants.MESSAGE_FOR_LOADING_DATA);		
				try {
					String studentsNameInSingleString = readFromFile(Constants.FILE_NAME);
					String studentsNames[] = studentsNameInSingleString.split(Constants.COMMA);	
					Random random = new Random();
					int randomIndexForStudentSelection = random.nextInt(studentsNames.length);
					System.out.println(studentsNames[randomIndexForStudentSelection].trim());
				} catch (Exception e){

				} 
				System.out.println(Constants.MESSAGE_FOR_DATA_LOADED);			
			}
			else if(args[0].contains(Constants.PLUS_SIGN)) {
				System.out.println(Constants.MESSAGE_FOR_LOADING_DATA);			
				try {
				String newStudentName = args[0].substring(1);
				DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_STRING);
				String formattedDate= dateFormat.format(new Date());
				writeToFile(Constants.FILE_NAME, Constants.COMMA + newStudentName + Constants.LAST_UPDATE + formattedDate);
				} catch (Exception e){

				}
				System.out.println(Constants.MESSAGE_FOR_DATA_LOADED);	
			}
			else if(args[0].contains(Constants.QUESTION_MARK)) {
				System.out.println(Constants.MESSAGE_FOR_LOADING_DATA);			
				try {
					String studentsNameInSingleString = readFromFile(Constants.FILE_NAME);
					String studentsNames[] = studentsNameInSingleString.split(Constants.COMMA);	
					String studentName = args[0].substring(1);
					for(int index = 0; index<studentsNames.length; index++) {
						if(studentsNames[index].trim().equals(studentName)) {
							System.out.println(Constants.MESSAGE_FOR_FOUND_THE_STUDENT);
							break;
						}
					}
				} catch (Exception e){

				} 
				System.out.println(Constants.MESSAGE_FOR_DATA_LOADED);				
			}
			else if(args[0].contains(Constants.CHAR_C)) {
				System.out.println(Constants.MESSAGE_FOR_LOADING_DATA);			
				try {
					String studentsNameInSingleString = readFromFile(Constants.FILE_NAME);
					String studentsNames[] = studentsNameInSingleString.split(Constants.COMMA);		
					System.out.println(studentsNames.length + Constants.WORDS_FOUND );
				} catch (Exception e){

				} 
				System.out.println(Constants.MESSAGE_FOR_DATA_LOADED);				
			}
			else {
				System.out.println(Constants.ERROR_MESSAGE_FOR_INVALID_ARGUMENTS);
				System.exit(1);
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
			System.out.println(Constants.ERROR_MESSAGE_FOR_READING_FILE);
		}
		return Constants.BLANK_STRING;
	}

	public static void writeToFile(String fileName, String content){
		try{
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(fileName, true));
			bufferedWriter.write(content);
			bufferedWriter.close();
		} catch(Exception e){
			System.out.println(Constants.ERROR_MESSAGE_FOR_WRITING_FILE);
		}
	}
}