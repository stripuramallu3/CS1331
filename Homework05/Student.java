/**
*This class represents a Student
* @author Sreerama Tripuramallu
* @version 1.0
*/
public class Student {
    private String name;
    private String year;
    private Lecture[] lectures;
    private Recitation[] recitations;
    private Lab[] labs;
    private int numHours = 0;
    private int nullIndex1 = -1;
    private int nullIndex2 = -1;
    private int nullIndex3 = -1;
    /**
    * Creates a new Student object
    * @param name name of student
    * @param year year of student
    */
    public Student(String name, String year) {
        this.name = name;
        this.year = year;
        this.lectures = new Lecture[10];
        this.recitations = new Recitation[10];
        this.labs = new Lab[10];
        calcNumHours();
        findNullIndex();
    }
    /**
    * Creates a new Student object
    * @param name name of student
    * @param year year of student
    * @param lectures list of lecture classes student is taking
    * @param recitations list of recitations classes student is taking
    * @param labs list of lab classes student is taking
    */
    public Student(String name, String year, Lecture[] lectures, Recitation[]
         recitations, Lab[] labs) {
        this.name = name;
        this.year = year;
        this.lectures = lectures;
        this.recitations = recitations;
        this.labs = labs;
        calcNumHours();
        findNullIndex();
    }
    /**
    * Gets the number of hours student is enrolled in
    * @return the hours
    */
    public int getHours() {
        return numHours;
    }
    /**
    * Prints out the String version of all of the lecture classes student is
    * enrolled in
    */
    public void retriveLectures() {
        for (int i = 0; i < this.lectures.length && this.lectures[i] != null;
             i++) {
            System.out.println(this.lectures[i].toString());
            System.out.println();
        }
    }
    /**
    * Prints out the String version of all of the recitation classes student is
    * enrolled in
    */
    public void retriveRecitations() {
        for (int i = 0; i < this.recitations.length && this.recitations[i]
             != null; i++) {
            System.out.println(this.recitations[i].toString());
            System.out.println();
        }
    }
    /**
    * Prints out the String version of all of the lab classes student is
    * enrolled in
    */
    public void retriveLabs() {
        for (int i = 0; i < this.labs.length && this.labs[i] != null;
             i++) {
            System.out.println(this.labs[i].toString());
            System.out.println();
        }
    }
    /**
    * Returns the array of the lecture classes
    * @return array of lecture classes
    */
    public Lecture[] retrieveLectureList() {
        return this.lectures;
    }
    /**
    * Returns the array of the recitation classes
    * @return array of recitation classes
    */
    public Recitation[] retrieveRecitationList() {
        return this.recitations;
    }
    /**
    * Returns the array of the lab classes
    * @return array of lab classes
    */
    public Lab[] retrieveLabList() {
        return this.labs;
    }
    /**
    * Converts the student properties to a string
    * @return String version of the student's properties
    */
    public String toString() {
        return this.name + " is taking " + this.numHours + " as a " + this.year;
    }
    /**
    * Adds a lecture class to the list of lectures
    * @param lecture the lecture class
    * @return true if the lecture parameter was added to the list of lectures
    */
    public boolean addLectureClass(Lecture lecture) {
        if (possibleClass(lecture.getHours())) {
            this.lectures[nullIndex1] = lecture;
            nullIndex1 = -1;
            findNullIndex();
            this.numHours = 0;
            calcNumHours();
            return true;
        }
        return false;
    }
    /**
    * Adds a recitation class to the list of recitations
    * @param recitation the recitation class
    * @return true if the recitation parameter was added to the list of
    * recitations
    */
    public boolean addRecitationClass(Recitation recitation) {
        if (possibleClass(recitation.getHours())) {
            this.recitations[nullIndex2] = recitation;
            nullIndex2 = -1;
            findNullIndex();
            this.numHours = 0;
            calcNumHours();
            return true;
        }
        return false;
    }
    /**
    * Adds a lab class to the list of labs
    * @param lab the lab class
    * @return true if the lab parameter was added to the list of labs
    */
    public boolean addLabClass(Lab lab) {
        if (possibleClass(lab.getHours())) {
            this.labs[nullIndex3] = lab;
            nullIndex3 = -1;
            findNullIndex();
            this.numHours = 0;
            calcNumHours();
            return true;
        }
        return false;
    }
    private void calcNumHours() {
        for (int i = 0; i < this.lectures.length && this.lectures[i] != null;
             i++) {
            this.numHours += this.lectures[i].getHours();
        }
        for (int i = 0; i < this.recitations.length && this.recitations[i]
             != null; i++) {
            this.numHours += this.recitations[i].getHours();
        }
        for (int i = 0; i < this.labs.length && this.labs[i] != null; i++) {
            this.numHours += this.labs[i].getHours();
        }
    }
    private boolean possibleClass(int hours) {
        return (this.numHours + hours) <= 21;
    }
    private void findNullIndex() {
        for (int i = 0; i < this.lectures.length  && nullIndex1 == -1; i++) {
            if (this.lectures[i] == null) {
                nullIndex1 = i;
            }
        }
        for (int i = 0; i < this.recitations.length && nullIndex2 == -1; i++) {
            if (this.recitations[i] == null) {
                nullIndex2 = i;
            }
        }
        for (int i = 0; i < this.labs.length && nullIndex3 == -1; i++) {
            if (this.labs[i] == null) {
                nullIndex3 = i;
            }
        }


    }


}