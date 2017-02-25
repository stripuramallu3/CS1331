/**
*This class represents a Recitation
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Recitation implements ClassPeriod {
    private String professorName;
    private String teachingAssistantName;
    private int numHours;
    private String subject;
    private boolean collaborative;
    private int grade = 0;

    /**
    * Creates a new Recitation object
    * @param professorName name of the professor
    * @param teachingAssistantName name of the teaching assistant
    * @param numHours number of hours of the recitation class
    * @param subject the subject of the recitation
    * @param collaborative recitation is collaborative or not
    */
    public Recitation(String professorName, String teachingAssistantName,
         int numHours, String subject, boolean collaborative) {
        this.professorName = professorName;
        this.teachingAssistantName = teachingAssistantName;
        this.numHours = numHours;
        this.subject = subject;
        this.collaborative = collaborative;
    }
    /**
    * Gets the subject of the recitation
    * @return the subject
    */
    public String getSubject() {
        return this.subject;
    }
    /**
    * Gets the hours of the recitation
    * @return the hours
    */
    public int getHours() {
        return this.numHours;
    }
    /**
    * Gets the Student's grade for the recitation
    * @return the grade
    */
    public double getGrade() {
        return this.grade;
    }
    /**
    * Gets the Professor for the recitation
    * @return the professor's name
    */
    public String getProfessor() {
        return this.professorName;
    }
    /**
    * Gets the Teaching Asisstant's name for the recitation
    * @return the professor's name
    */
    public String getTeachingAssistant() {
        return this.teachingAssistantName;
    }
    /**
    * tells whether recitation is collaborative or not
    * @return collaborative
    */
    public boolean isCollaborative() {
        return this.collaborative;
    }
    /**
    *Sets the Teaching Assistant's name
    * @param teachingAssistant the teaching assistant's name
    */
    public void setTeachingAsisstant(String teachingAssistant) {
        this.teachingAssistantName = teachingAssistant;
    }
    /**
    *Sets the professor's name
    * @param professor the professor's name
    */
    public void setProfessor(String professor) {
        this.professorName = professor;
    }
    /**
    *Sets the Student's grade
    * @param grade the student's grade
    */
    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 50) {
            this.grade = grade;
        }
    }
    /**
    * Converts the recitation properties to a string
    * @return the string version of the recitation properties
    */
    public String toString() {
        if (collaborative) {
            String tempString = "Recitation for " + this.subject + "taught by ";
            tempString = tempString + this.professorName;
            tempString = tempString + ". The Teaching Assistant is ";
            tempString = tempString + this.teachingAssistantName + ".";
            tempString = tempString + " This recitation is ";
            tempString = tempString + this.numHours + " and your current grade";
            tempString = tempString + " is " + this.grade;
            tempString = tempString + ". The work for this recitation is";
            tempString = tempString + " COLLABORATIVE.";
            return tempString;
        } else {
            String tempString = "Recitation for " + this.subject + "taught by ";
            tempString = tempString + this.professorName;
            tempString = tempString + ". The Teaching Assistant is ";
            tempString = tempString + this.teachingAssistantName + ".";
            tempString = tempString + " This recitation is ";
            tempString = tempString + this.numHours + " and your current grade";
            tempString = tempString + " is " + this.grade;
            tempString = tempString + ". The work for this recitation is";
            tempString = tempString + " not COLLABORATIVE.";
            return tempString;
        }
    }
}