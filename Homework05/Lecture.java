/**
*This class represents a Lecture
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Lecture implements ClassPeriod {
    private int grade = 0;
    private boolean mandatoryAttendance;
    private int numHours;
    private String professorName;
    private String subject;

    /**
    * Creates a new Lecture object
    * @param mandatoryAttendance lecture is mandatory or not
    * @param numHours number of hours of the lecture
    * @param professorName name of the professor
    * @param subject the subject of the lecture
    */
    public Lecture(boolean mandatoryAttendance, int numHours,
         String professorName, String subject) {
        this.mandatoryAttendance = mandatoryAttendance;
        this.numHours = numHours;
        this.professorName = professorName;
        this.subject = subject;
    }
    /**
    * Gets the subject of the lecture
    * @return the subject
    */
    public String getSubject() {
        return this.subject;
    }
    /**
    * Gets the hours of the lecture
    * @return the hours
    */
    public int getHours() {
        return numHours;
    }
    /**
    * Gets the Student's grade for the lecture
    * @return the grade
    */
    public double getGrade() {
        return grade;
    }
    /**
    *Sets the student's grade
    * @param grade the student's grade
    */
    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        }
    }
    /**
    * Gets the Professor for the lecture
    * @return the professor's name
    */
    public String getProfessor() {
        return professorName;
    }
    /**
    *Sets the professor's name
    * @param professor the professor's name
    */
    public void setProfessor(String professor) {
        this.professorName = professor;
    }
    /**
    * converts the lecture properties to a string
    * @return the string version of the lecture properties
    */
    public String toString() {
        if (mandatoryAttendance) {
            String tempString = subject + " taught by Professor ";
            tempString = tempString + professorName + ". It is a ";
            tempString = tempString + numHours + " hour course and you";
            tempString = tempString + " received a ";
            tempString = tempString + grade + ". Lecture is MANDATORY.";
            return tempString;
        } else {
            String tempString = subject + " taught by Professor ";
            tempString = tempString + professorName + ". It is a ";
            tempString = tempString + numHours + " hour course and you";
            tempString = tempString + " received a ";
            tempString = tempString + grade + ". Lecture is not MANDATORY.";
            return tempString;
        }
    }

}