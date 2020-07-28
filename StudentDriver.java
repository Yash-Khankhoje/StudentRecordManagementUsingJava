import java.io.IOException;
import java.util.Scanner;

public class StudentDriver {
	
	public static int displayMenu() {
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("		Student Operations		");
		System.out.println("--------------------------------");
		System.out.println();
		System.out.println("1. Add new student");
		System.out.println("2. Display student report");
		System.out.println("3. Write student report to destination file");
		System.out.println("4. Delete a student");
		System.out.println("5. Save student list in the CSV file.");
		System.out.println("6. Exit");
		System.out.println("Please enter your option.(1 to 6): ");
		Scanner scanner = new Scanner(System.in);
		int option = Integer.parseInt(scanner.nextLine());
		return option;
	}

	public static void main(String[] args) throws IOException{
		//displayMenu();
		StudentList studentList = new StudentList();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter students file for student recordsfrom which data has to be readen.: ");
		String fileName = scanner.nextLine();
		studentList.readStudentsFromFile(fileName);
		boolean quit = false;
		String reportFile = "";
		String targetRoll = "";
		
		while(!quit) {
			int option = displayMenu();
			switch(option) {
			case 1: studentList.addStudent();
					break;
			case 2: studentList.displayStudents();
					break;
			case 3: System.out.println("Please enter the file name for report: ");
					reportFile = scanner.nextLine();
					studentList.writeReportToFile(reportFile);
					break;
			case 4: System.out.println("Enter the rollNo. fo the students which you want to delete.: ");
					targetRoll = scanner.nextLine();
					if(studentList.deleteStudent(targetRoll)) {
						System.out.println("Target student deleted successfully...");
					}
					else {
						System.out.println("Target student could not found.");
					}		
					System.out.println("Do you want to update it into your primary CSV file?[yes/no]");
					System.out.println("1 for yes.");
					System.out.println("0 for no.");
					int choice = Integer.parseInt(scanner.nextLine());
					switch(choice) {
					case 0: System.out.println("Ok. Not Saving the data to the primary CSV file.");
							break;
					case 1: studentList.saveStudentsToFile(fileName);
							System.out.println("File saved successfully.");
							break;
					default: System.out.println("Invalid choice --Choice should be either 1 or 2.");
							 break;
					}
					break;
			case 5: studentList.saveStudentsToFile(fileName);
					break;
			case 6: quit = true;
					break;
			default: System.out.println("Invalid option. --valid options are from 1 to 6.");
			}
		}
		System.out.println();
		System.out.println("Thank you!!");
		/*StudentList studentList = new StudentList();
		studentList.addStudent();
		studentList.readStudentsFromFile("MiniProject.csv");
		studentList.saveStudentsToFile("MiniProject.csv");
		studentList.displayStudents();
		studentList.writeReportToFile("report.txt");
	*/
	}

}
