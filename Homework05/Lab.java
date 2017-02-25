/**
*This class represents a Lab
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Lab implements ClassPeriod {
    private String professorName;
    private String labAssistantName;
    private int numHours;
    private double grade = 0.0;
    private String subject;
    private double[] labReports = new double[10];
    private String[] labRules = new String[3];
    /**
    * Creates a new Lab object
    * @param professorName name of the professor
    * @param labAssistantName name of the lab assistant
    * @param numHours number of hours of the lab class
    * @param subject the subject of the lab
    */
    public Lab(String professorName, String labAssistantName, int numHours,
         String subject) {
        this.professorName = professorName;
        this.labAssistantName = labAssistantName;
        this.numHours = numHours;
        this.subject = subject;
    }
    /**
    * Gets the subject of the lab
    * @return the subject
    */
    public String getSubject() {
        return this.subject;
    }
    /**
    * Gets the hours of the lab
    * @return the hours
    */
    public int getHours() {
        return this.numHours;
    }
    /**
    * Gets the Student's grade for the lab
    * @return the grade
    */
    public double getGrade() {
        return this.grade;
    }
    /**
    * Gets the Professor for the lab
    * @return the professor's name
    */
    public String getProfessor() {
        return this.professorName;
    }
    /**
    * Gets the Lab Assistant for the lab
    * @return the lab assistant's name
    */
    public String getLabAssistant() {
        return this.labAssistantName;
    }
    /**
    *Sets the professor's name
    * @param professor the professor's name
    */
    public void setProfessor(String professor) {
        this.professorName = professor;
    }
    /**
    *Sets the Lab Assistant's name
    * @param labAssistant the lab assistant's name
    */
    public void setLabAsisstant(String labAssistant) {
        this.labAssistantName = labAssistantName;
    }
    /**
    * Returns the lab grades
    * @return the lab grades for the lab class
    */
    public double[] getLabGradesList() {
        return this.labReports;
    }
    /**
    * Prints out the lab grades
    */
    public void getLabGrades() {
        for (int i = 0; i < this.labReports.length; i++) {
            System.out.println("Lab " + (i + 1) + " Grade is: "
                + this.labReports[i]);
        }
    }
    /**
    * Sets the grade for a specific lab report
    * @param labNumber the index of the lab report
    * @param g the grade of the labNumber
    * @return true if the labNumber was sucessfully given the grade
    */
    public boolean enterGrade(int labNumber, double g) {
        if (g >= 0.0 && g <= 50.0 && labNumber >= 1
             && labNumber <= 10) {
            int index = labNumber - 1;
            this.labReports[index] = g;
            this.grade = 0.0;
            calculateGrade();
            return true;
        }
        return false;
    }
    /**
    * Sets the array parameter to the labReports
    * @param reports the array containing the lab report grades
    * @return true if parameter was sucessfully set to the instance variable
    */
    public boolean enterGrade(double[] reports) {
        if (reports.length == this.labReports.length) {
            this.labReports = reports;
            this.grade = 0.0;
            calculateGrade();
            return true;
        }
        return false;
    }
    private void calculateGrade() {
        double tempGrade = 0.0;
        for (int i = 0; i < this.labReports.length; i++) {
            if (this.labReports[i] >= 0.0 && this.labReports[i] <= 50.0) {
                tempGrade += this.labReports[i];
            }
        }
        this.grade = tempGrade / this.labReports.length;
    }
    /**
    * Adds the three rules to the list of rules
    * @param rule1 String representing the first rule
    * @param rule2 String representing the second rule
    * @param rule3 String representig the third rule
    * @return true if all of the rules were successfully placed into the list
    * of rules
    */
    public boolean enterRules(String rule1, String rule2, String rule3) {
        int counter = 0;
        if (rule1.length() > 0 && rule1 != null) {
            labRules[0] = rule1;
            counter++;
        } else if (rule2.length() > 0 && rule2 != null) {
            labRules[1] = rule2;
            counter++;
        } else if (rule3.length() > 0 && rule3 != null) {
            labRules[2] = rule3;
            counter++;
        }
        if (counter == this.labRules.length) {
            return true;
        }
        return false;

    }
    /**
    * Adds the rule  to the list of rules
    * @param rule String representing the lab rule
    * @param ruleNumber index that represents the rule number
    * @return true if the rule was successfully placed into the list of rules
    */
    public boolean enterRules(String rule, int ruleNumber) {
        int index = ruleNumber - 1;
        if (rule.length() > 0 && rule != null && index >= 0 && index <= 2) {
            labRules[index] = rule;
            return true;
        }
        return false;
    }
    /**
    * Adds the rule  to the list of rules
    * @param rule String representing the lab rule
    * @return true if the rule was successfully placed into the list of rules
    */
    public boolean enterRules(String rule) {
        for (int i = 0; i < this.labRules.length; i++) {
            if (this.labRules[i] == null) {
                this.labRules[i] = rule;
                return true;
            }
        }
        return false;
    }
    /**
    * Sets the parameter equal to the list of rules
    * @param rules array representing the lab rules
    * @return true if the parameter was successfully set to the list of rules
    */
    public boolean enterRules(String[] rules) {
        if (this.labRules.length == rules.length) {
            this.labRules = rules;
            return true;
        }
        return false;
    }
    /**
    * Returns the number of lab rules
    * @return the number of lab rules
    */
    public int numRules() {
        int tempNumRules = 0;
        for (int i = 0; i < this.labRules.length && this.labRules[i] != null;
            i++) {
            tempNumRules++;
        }
        return tempNumRules;
    }
    /**
    * Converts the Lab properties to a string
    * @return the string version of the Lab properties
    */
    public String toString() {
        String tempString =  "Lab for " + this.subject + " taught by "
            + this.professorName + ". The Lab Assistant is "
            + this.labAssistantName + ". This lab is " + numHours
            + "and your current grade is "
            + this.grade + ". The saftey rules for this lab are: ";
        for (int i = 0; i < this.labRules.length && this.labRules[i] != null;
             i++) {
            tempString += (i + 1) + ") " + labRules[i] + ".";
        }
        return tempString;
    }
}