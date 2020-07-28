
public class Student {
	private String rollNo;
	private String firstName;
	private String lastName;
	private int scoreInCPP, scoreInJava, scoreInPython;
	private double height, weight;
	public Student(String rollNo, String firstName, String lastName, int scoreInCPP, int scoreInJava, int scoreInPython,
			double height, double weight) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.scoreInCPP = scoreInCPP;
		this.scoreInJava = scoreInJava;
		this.scoreInPython = scoreInPython;
		this.height = height;
		this.weight = weight;
	}
	public Student() {
		
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getScoreInCPP() {
		return scoreInCPP;
	}
	public void setScoreInCPP(int scoreInCPP) {
		this.scoreInCPP = scoreInCPP;
	}
	public int getScoreInJava() {
		return scoreInJava;
	}
	public void setScoreInJava(int scoreInJava) {
		this.scoreInJava = scoreInJava;
	}
	public int getScoreInPython() {
		return scoreInPython;
	}
	public void setScoreInPython(int scoreInPython) {
		this.scoreInPython = scoreInPython;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getFullName() {
		return this.getFirstName()+" "+this.getLastName();
	}
	
	public double getAverage() {
		double avg = (scoreInCPP + scoreInJava + scoreInPython) / 3.0;
		return avg;
	}
	
	public String getGrade() {
		String grade = "";
		double avg = this.getAverage();
		if(avg >= 90) {
			grade = "A";
		}
		else if(avg >= 80) {
			grade = "B";
		}
		else if(avg >= 70) {
			grade = "C";
		}
		else if(avg >= 60) {
			grade = "D";
		}
		else if(avg >= 50) {
			grade = "E";
		}
		else {
			grade = "F";
		}
		return grade;
	}
	
	public double getBMI() {
		double bmi = this.getWeight() / (this.getHeight() * this.getHeight());
		return bmi;
	}
	public String getBMIRemark() {
		double bmi = this.getBMI();
		String remark = "";
		if(bmi >= 30.0) {
			remark = "Obese.";
		}
		else if(bmi >= 25.0) {
			remark = "Over Weight.";
		}
		else if(bmi >= 18.5) {
			remark = "Healthy Weight.";
		}
		else {
			remark = "Under Weight.";
		}
		return remark;
	}
	
	public String getCSVString() {
		String str = this.getRollNo()+","+this.getFirstName()+","+this.getLastName()+","+this.getScoreInCPP()+","
				+this.getScoreInJava()+","+this.getScoreInPython()+","+this.getHeight()+","+this.getWeight();
		return str;
			
	}
	
	public String toString() {
		String str = String.format("%-4s %-25s %10.2f %5s %10.2f %-15s\n", this.getRollNo(), this.getFullName(),
				this.getAverage(), this.getGrade(), this.getBMI(), this.getBMIRemark());
		return str;
	}

}
