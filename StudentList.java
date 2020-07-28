import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
	private ArrayList<Student> students;
	
	public StudentList() {
		students = new ArrayList<>();
	}
	
	private static int readValidInt(Scanner scanner, String prompt, int min, int max) {
		System.out.print(prompt);
		int value = Integer.parseInt(scanner.nextLine());
		while(value < min || value > max) {
			System.out.println("Invalid input, must be >= "+min+"and <= "+max);
			System.out.print(prompt);
			value = Integer.parseInt(scanner.nextLine());
		}
		return value;
	}
	
	private static double readValidDouble(Scanner scanner, String prompt, double min, double max) {
		System.out.print(prompt);
		Double value = Double.parseDouble(scanner.nextLine());
		while(value < min || value > max) {
			System.out.println("Invalid input, must be >= "+min+"and <= "+max);
			System.out.print(prompt);
			value = Double.parseDouble(scanner.nextLine());
		}
		return value;
	}
	
	public int addStudent() {
		Student s = new Student();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter rollNo.: ");
		String rollNo = keyboard.nextLine();
		boolean found = false;
		for(int i = 0;i < students.size() && !found;++i) {
			if(rollNo.equals(students.get(i).getRollNo())) {
				found = true;
			}
		}
		if (found == true) {
			System.out.println("Rollno. allready exist. This student can not be added in the file.");
			return 0;
		}
		else {
			System.out.print("Enter first name: ");
			String firstName = keyboard.nextLine();
			System.out.print("Enter last name: ");
			String lastName = keyboard.nextLine();
			//System.out.print("Enter score in CPP: ");
			int scoreInCPP = StudentList.readValidInt(keyboard, "Enter score in CPP: ", 0, 100);
			int scoreInJava = StudentList.readValidInt(keyboard, "Enter score in Java: ", 0, 100);
			int scoreInPython = StudentList.readValidInt(keyboard, "Enter score in Python: ", 0, 100);
			Double height = StudentList.readValidDouble(keyboard, "Enter height: ", 0.0, 2.5);
			Double weight = StudentList.readValidDouble(keyboard, "Enter weight: ", 1.0, 160.0);
			s.setRollNo(rollNo);
			s.setFirstName(firstName);
			s.setLastName(lastName);
			s.setScoreInCPP(scoreInCPP);
			s.setScoreInJava(scoreInJava);
			s.setScoreInPython(scoreInPython);
			s.setHeight(height);
			s.setWeight(weight);
			students.add(s);
		}
		return 0;
	}
	
	public void readStudentsFromFile(String fileName) throws IOException {
		File file = new File(fileName);
		Scanner fileScanner = new Scanner(file);
		while(fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			String [] tokens = line.split(",");
			Student student = new Student();
			student.setRollNo(tokens[0]);
			student.setFirstName(tokens[1]);
			student.setLastName(tokens[2]);
			student.setScoreInCPP(Integer.parseInt(tokens[3]));
			student.setScoreInJava(Integer.parseInt(tokens[4]));
			student.setScoreInPython(Integer.parseInt(tokens[5]));
			student.setHeight(Double.parseDouble(tokens[6]));
			student.setWeight(Double.parseDouble(tokens[7]));	
			students.add(student);
		}
	}
	
	public int searchStudent(String targetRoll) {
		int index = -1;
		boolean found = false;
		for(int i = 0;i < students.size() && !found;++i) {
			if(targetRoll.equals(students.get(i).getRollNo())) {
				found = true;
				index = i;
			}
		}
		return index;
	}
	
	public boolean deleteStudent(String targetRoll) {
		boolean success = false;
		int index = searchStudent(targetRoll);
		if(index != -1) {
			students.remove(index);
			success = true;
		}
		return success;
	}
	
	public void saveStudentsToFile(String fileName) throws IOException{
		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(file);
		for(Student s:students) {
			pw.println(s.getCSVString());
		}
		pw.close();
	}
	
	public void displayStudents() {
		System.out.println();
		System.out.printf("%-4s %-25s %10s %-5s %10s %-15s\n",
				"Roll", "Full Name", "Avg Grade", "Grade", "BMI", "Remark");
		int [] counter = new int[] {0,0,0,0,0,0};
		for(Student s:students) {
			System.out.print(s.toString());
			if (s.getGrade().equals("A")) {
				counter[0] += 1;
			}
			else if(s.getGrade().contentEquals("B")) {
				counter[1] += 1;
			}
			else if(s.getGrade().contentEquals("C")) {
				counter[2] += 1;
			}
			else if(s.getGrade().contentEquals("D")) {
				counter[3] += 1;
			}
			else if(s.getGrade().contentEquals("E")) {
				counter[4] += 1;
			}
			else if(s.getGrade().contentEquals("F")) {
				counter[5] += 1;
			}
		}
		System.out.println();
		System.out.println("Grade A: "+counter[0]);
		System.out.println("Grade B: "+counter[1]);
		System.out.println("Grade C: "+counter[2]);
		System.out.println("Grade D: "+counter[3]);
		System.out.println("Grade E: "+counter[4]);
		System.out.println("Grade F: "+counter[5]);
		
	}
	
	public void writeReportToFile(String fileName) throws IOException{
		File file = new File(fileName);
		PrintWriter pw = new PrintWriter(file);
		pw.printf("%-4s %-25s %10s %-5s %10s %-15s\n",
				"Roll", "Full Name", "Avg Grade", "Grade", "BMI", "Remark");
		int [] counter = new int[] {0,0,0,0,0,0};
		for(Student s:students) {
			pw.print(s.toString());
			if (s.getGrade().equals("A")) {
				counter[0] += 1;
			}
			else if(s.getGrade().contentEquals("B")) {
				counter[1] += 1;
			}
			else if(s.getGrade().contentEquals("C")) {
				counter[2] += 1;
			}
			else if(s.getGrade().contentEquals("D")) {
				counter[3] += 1;
			}
			else if(s.getGrade().contentEquals("E")) {
				counter[4] += 1;
			}
			else if(s.getGrade().contentEquals("F")) {
				counter[5] += 1;
			}
		}
		pw.println();
		pw.println("Grade A: "+counter[0]);
		pw.println("Grade B: "+counter[1]);
		pw.println("Grade C: "+counter[2]);
		pw.println("Grade D: "+counter[3]);
		pw.println("Grade E: "+counter[4]);
		pw.println("Grade F: "+counter[5]);
		pw.close();
	}

}
