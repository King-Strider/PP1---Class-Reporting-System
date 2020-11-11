package classroom;

/**
 *
 * @author Caleb Trout
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class Class {

    private final String rubric, name, prof, days;
    private final int crn, section, time, seats, enrolled, openings;

    public Class(int crn, String rubric, int section, String name, String prof, String days, int time, int seats, int enrolled, int openings) {
        this.crn = crn;
        this.rubric = rubric;
        this.section = section;
        this.name = name;
        this.prof = prof;
        this.days = days;
        this.time = time;
        this.seats = seats;
        this.enrolled = enrolled;
        this.openings = openings;

    }

    @Override
    public String toString() {
        return crn + " " + rubric + "\t" + section + "\t" + name + "\t" + prof + "\t" + days + "\t" + time + "\t" + seats + "\t" + enrolled + "\t" + openings;
    }

}

class Student {

    final double MAXGRADE = 100;
    final double LOWGRADE = 0;
    private String first, last, middle, letterGrade;
    private double grade1, grade2, grade3, grade4, finalTest, finalGrade, studentID;

    public Student(String firstname, String lastname, double grade1, double grade2, double grade3, double grade4, double finalTest) {

        this.first = firstname;
        this.last = lastname;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
        this.grade4 = grade4;
        this.finalTest = finalTest;
        this.finalGrade = (grade1 + grade2 + grade3 + grade4 + (finalTest * .12)) / 5;

        if (this.finalGrade >= 90 && this.finalGrade <= 100) {
            this.letterGrade = "A";
        } else if (this.finalGrade >= 80 && this.finalGrade < 90) {
            this.letterGrade = "B";
        } else if (this.finalGrade >= 70 && this.finalGrade < 80) {
            this.letterGrade = "C";
        } else if (this.finalGrade >= 60 && this.finalGrade < 70) {
            this.letterGrade = "D";
        } else {
            this.letterGrade = "F";
        }

    }

    @Override
    public String toString() {
        return first + " " + last + "\t" + grade1 + "\t" + grade2 + "\t" + grade3 + "\t" + grade4 + "\t" + finalTest + "\t" + finalGrade + "\t" + letterGrade;
    }

}

class classOfferings {

    public static void classOfferingsReport() throws FileNotFoundException {
        FileWriter classOfferings = null;
        try {
            String rubric, name, prof, days;
            int crn, section, time, seats, enrolled, openings;

            ArrayList<Class> classes = new ArrayList<Class>();/* creates a list to store the students and their grades*/

            Scanner fileInput = new Scanner(new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\ClassRoom\\src\\classroom\\Classes\\ClassList.txt")); /* reads in a classroom file */

            while (fileInput.hasNextLine()) {
                crn = fileInput.nextInt();
                rubric = fileInput.next();
                section = fileInput.nextInt();
                name = fileInput.next();
                prof = fileInput.next();
                days = fileInput.next();
                time = fileInput.nextInt();
                seats = fileInput.nextInt();
                enrolled = fileInput.nextInt();
                openings = fileInput.nextInt();

                classes.add(new Class(crn, rubric, section, name, prof, days, time, seats, enrolled, openings)); /* creates a new class and adds to the list from each line in the file */


            }  //classOfferings = new FileWriter("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\ClassRoom\\src\\classroom\\classOfferings.txt");
            for (Class st : classes) {
                System.out.print(st.toString() + "\n");

            }
            System.out.println("Class Report file has been written successfully");
            // classOfferings.close();
        } catch (IOException ex) {
            Logger.getLogger(ClassRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class gradeReport {

    public static void gradeReport(String fileName) throws FileNotFoundException {

        FileWriter GradeReport = null;
        try {
            String first_name, last_name;
            double grade1, grade2, grade3, grade4, finalTest;
            ArrayList<Student> studentGradeList = new ArrayList<Student>();/* creates a list to store the students and their grades*/

            Scanner fileInput = new Scanner(new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\ClassRoom\\src\\classroom\\ClassGrades\\" + fileName)); /* reads in a classroom file */

            while (fileInput.hasNextLine()) {
                first_name = fileInput.next();
                last_name = fileInput.next();
                grade1 = fileInput.nextDouble();
                grade2 = fileInput.nextDouble();
                grade3 = fileInput.nextDouble();
                grade4 = fileInput.nextDouble();
                finalTest = fileInput.nextDouble();

                studentGradeList.add(new Student(first_name, last_name, grade1, grade2, grade3, grade4, finalTest)); /* creates a new student and adds to list from each line in the file */


            }
            GradeReport = new FileWriter("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\ClassRoom\\src\\classroom\\GradeReport.txt");
            for (Student st : studentGradeList) {
                GradeReport.write(st.toString() + "\n");

            }
            System.out.println("Grade Report file has been written successfully");
            GradeReport.close();
        } catch (IOException ex) {
            Logger.getLogger(ClassRoom.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                GradeReport.close();
            } catch (IOException ex) {
                Logger.getLogger(ClassRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void classRoster(String fileName) throws FileNotFoundException {
        try {
            String first_name, last_name;
            double grade1, grade2, grade3, grade4, finalTest;
            ArrayList<Student> studentGradeList = new ArrayList<Student>();/* creates a list to store the students and their grades*/

            Scanner fileInput = new Scanner(new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\ClassRoom\\src\\classroom\\ClassGrades\\" + fileName)); /* reads in a classroom file */

            while (fileInput.hasNextLine()) {
                first_name = fileInput.next();
                last_name = fileInput.next();
                grade1 = fileInput.nextDouble();
                grade2 = fileInput.nextDouble();
                grade3 = fileInput.nextDouble();
                grade4 = fileInput.nextDouble();
                finalTest = fileInput.nextDouble();

                studentGradeList.add(new Student(first_name, last_name, grade1, grade2, grade3, grade4, finalTest)); /* creates a new student and adds to list from each line in the file */


            }
            for (Student st : studentGradeList) {
                //(st.toString() + "\n"); this will print out the student roster

            }
        } catch (IOException ex) {
            Logger.getLogger(ClassRoom.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}

public class ClassRoom {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scnr = new Scanner(System.in);
        int cmd;

        //gets all the two types of files for use from two seperate directories   
        File classesFolder = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\ClassRoom\\src\\classroom\\Classes");
        File gradesFolder = new File("C:\\Users\\Caleb\\Documents\\NetBeansProjects\\ClassRoom\\src\\classroom\\ClassGrades");

//puts file names in arrays for comparisons
        File[] listOfClassGrades = gradesFolder.listFiles();
        File[] listOfClasses = classesFolder.listFiles();

        System.out.println("Please select a report you would like Run: (Please Type in the number of which report you would like; 1,2,3,4)");
        System.out.println("Class Offerings Report - 1");
        System.out.println("Class Roster Report - 2");
        System.out.println("Class Attendendance - 3");
        System.out.println("Class Grade Report - 4");

        cmd = scnr.nextInt();

        if (cmd == 1) {
            System.out.println("Class Offerings Report - 1");
            classOfferings.classOfferingsReport();
        } else if (cmd == 2) {
            //allows the selection of class to run report on
            System.out.println("Please choose a file number to run the report on");
            //Prints out file names
            for (int i = 0; i < listOfClassGrades.length; i++) {
                if (listOfClassGrades[i].isFile()) {
                    System.out.println("File number " + (i + 1) + " " + listOfClassGrades[i].getName());
                }
            }

            cmd = scnr.nextInt();
            gradeReport.classRoster(listOfClassGrades[cmd - 1].getName());

        } else if (cmd == 3) {
            System.out.println("Class Attendendance - 3");

        } else if (cmd == 4) {
            //allows the selection of class to run report on
            System.out.println("Please choose a file number to run the report on");
            //Prints out file names
            for (int i = 0; i < listOfClassGrades.length; i++) {
                if (listOfClassGrades[i].isFile()) {
                    System.out.println("File number " + (i + 1) + " " + listOfClassGrades[i].getName());
                }

            }

            cmd = scnr.nextInt();
            gradeReport.gradeReport(listOfClassGrades[cmd - 1].getName());

        } else {
            System.out.println("That is an invalid choice..... Exiting now");

        }

    }

}
