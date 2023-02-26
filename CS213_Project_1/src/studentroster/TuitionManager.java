package studentroster;
import java.util.Scanner;

/**
 This is user interface that reads terminal commands and displays the results.
 It can process single commands or sequences of commands. It stores the roster.
 @author Dylan Turner, Noor Hasan
 */
public class TuitionManager {
    private final Roster roster;
    private final Enrollment enrollment;

    /**
     Constructor for the Roster Manager. Creates a
     new roster and stores it.
     */
    public TuitionManager() {
        this.roster = new Roster();
        this.enrollment = new Enrollment();
    }

    /**
     Continuously runs and processes user commands until it is
     terminated by quit command "Q".
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tuition Manager Running...");
        boolean stopProgram = false;
        while (!stopProgram) {                          //checks if the terminate command has been entered.
            stopProgram = processCommand(scanner);
        }
        scanner.close();
        System.out.println("Tuition Manager Terminated.");
    }

    /**
       Helper method for run(), that stores and runs all valid commands.
       @param scanner object to receive user input.
       @return true if terminate command given, false otherwise.
     */
    private boolean processCommand(Scanner scanner) {
        String operationCode = scanner.next();

        switch (operationCode) {
            case "R":                           //remove a student from the roster.
                remove(scanner.next(), scanner.next(), scanner.next());
                return false;
            case "P":                           //prints the roster sorted by profile.
                if(!this.roster.isEmpty()){roster.print(); return false;}
                rosterEmpty();
                return false;
            case "PS":                          //prints the roster sorted by standing.
                if(!this.roster.isEmpty()){roster.printByStanding(); return false;}
                rosterEmpty();
                return false;
            case "PC":                          //prints the roster sorted by major.
                if(!this.roster.isEmpty()){roster.printBySchoolMajor(); return false;}
                rosterEmpty();
                return false;
            case "L":                           //lists all students under a specified school.
                printList(scanner.next().toUpperCase());
                return false;
            case "C":                           //changes the major of a specified student.
                changeMajor(scanner.next(), scanner.next(), scanner.next(), scanner.next());
                return false;
            case "Q":                           //terminate command.
                return true;
            default:                            //invalid command.
                return processAdditionCommands(scanner,operationCode); // continues to helper method to process additional commands
                                                                       // in order to maintain clean coding practices.
        }
    }

    private boolean processAdditionCommands(Scanner scanner, String operationCode) {
        switch (operationCode) {
            case "LS":                          // load the student roster from an external file

                return false;
            case "AR":                          // add a Resident student, for example, AR John Doe 4/3/2003 CS 29
                add(scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next(),StudentType.RESIDENT,"Unnecessary","Unnecessary");
                return false;
            case "AN":                          // add a NonResident student, for example, AN Leo Jones 4/21/2006 ITI 20
                add(scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next(),StudentType.NON_RESIDENT,"Unnecessary","Unnecessary");
                return false;
            case "AT":                          // add a Tri state student, for example, AT Emma Miller 2/28/2003 CS 15 NY
                add(scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next(),StudentType.TRI_STATE,scanner.next(),"Unnecessary");
                return false;
            case "AI":                          // add an International student, for example, AI Oliver Chang 11/30/2000 BAIT 78 false
                add(scanner.next(),scanner.next(),scanner.next(),scanner.next(),scanner.next(),StudentType.INTERNATIONAL,scanner.next(), scanner.next());
                return false;
            case "E":                           // enroll a student with the number of credits.

                return false;
            case "D":                           // drop a student from the enrollment list, for example, D Carl Brown 10/7/2004

                return false;
            case "S":                           // award the scholarship to a resident student, for example, S Roy Brooks 9/9/1999 10000

                return false;
            case "PE":                          // display the current enrollment list, based on their order in the array.

                return false;
            case "PT":                          // display the tuition due based on the credits enrolled, with the order in the enrollment array.

                return false;
            case "SE":                          // semester end to add the enrolled credits to the credit completed in the roster
                // and print out the students who have already completed 120 credits or more.

                return false;
            default:
                System.out.println(operationCode + " is an invalid command!");
                return false;
        } //39 lines, be careful ----------------------------------------------------------------------------------------------
    }

    /**
     Adds a student to the Roster if it passes all the validity checks.
     @param lname the student's last name.
     @param fname the student's first name.
     @param dob the student's date of birth.
     @param major the student's major.
     */
    private void add(String fname, String lname, String dob, String major, String creditsCompleted, StudentType studentType, String state, String isAbroad) {
        if (isAllowed(dob, major, creditsCompleted)) {              //checks if the student is allowed to be added
            Profile newProfile = new Profile(lname, fname, dob);
            if (this.roster.add(newProfile, major, Integer.parseInt(creditsCompleted), studentType,state, (isAbroad.equals("true")))) {
                System.out.println(fname + " " + lname + " " + dob + " added to the Roster.");
            } else {
                System.out.println(fname + " " + lname + " " + dob + " is already in the Roster.");
            }
        }
    }

    /**
     Removes a student from the roster given their profile if it passes validity checks.
     @param lname the student's last name.
     @param fname the student's first name.
     @param dob the student's date of birth.
     */
    private void remove(String fname, String lname, String dob) {
        Profile profile = new Profile(lname, fname, dob);
        if (this.roster.remove(profile)) {
            System.out.println(fname + " " + lname + " " + dob +" removed from the Roster.");
            return;
        }
        System.out.println(fname + " " + lname + " " + dob + " is not in the Roster.");
    }

    /**
     Changes the major of a student in the roster given it passes validity checks.
     @param lname the student's last name.
     @param fname the student's first name.
     @param dob the student's date of birth.
     @param major the student's major.
     */
    private void changeMajor(String fname, String lname, String dob, String major){
        if (!isValidMajor(major)) {                     //checks if the major is valid first.
            System.out.println("Major code invalid: " + major);
            return;
        }
        // access the student based on the profile, then directly change that objects major with setMajor()

        Profile profile = new Profile(lname, fname, dob);
        if (this.roster.contains(profile)) {                        //checks if the student is actually in the roster.
            if(this.roster.replaceMajor(profile,major)){            //checks if the major can/should be replaced.
                System.out.println(fname + " " + lname + " " + dob + " major changed to " + major);
            } else {
                System.out.println(fname + " " + lname + " " + dob + " already has this major");
            }
        } else {
            System.out.println(fname + " " + lname + " " + dob + " is not in the Roster.");
        }
    }

    /**
     Helper method for the add() method, checks if a student is allowed to
     be entered into the roster.
     @param dob the student's date of birth.
     @param major the student's major.
     @param creditsCompleted the amount of credits completed by the student.
     @return false if the student fails any checks, true otherwise.
     */
    private boolean isAllowed (String dob, String major, String creditsCompleted){
        Date birthday = new Date(dob);
        Date today = new Date();
        if (!birthday.isValid()) {                      //checks if birthday is a valid date.
            System.out.println("DOB invalid " + dob + " not a valid calendar date!");
            return false;
        }
        if (birthday.compareTo(today) >= 0) {           //checks if birthday is beyond current date.
            System.out.println("DOB invalid " + dob + " not a valid calendar date!");
            return false;
        }
        if (!isAllowedAge(today, birthday)) {           //checks if birthday does not meet age requirement.
            System.out.println("DOB invalid: " + dob + " younger than 16 years old.");
            return false;
        }
        if (!isValidMajor(major)) {                     //checks if the major is valid.
            System.out.println("Major code invalid: " + major);
            return false;
        }
        if(!isNumeric(creditsCompleted)){               //checks if the credits are a number.
            System.out.println("Credits completed invalid: not an integer!");
            return false;
        }
        if (Integer.parseInt(creditsCompleted) < 0) {   //checks if the credits given are a valid amount.
            System.out.println("Credits completed invalid: cannot be negative!");
            return false;
        }
        if(!(Double.parseDouble(creditsCompleted) % 1 == 0)){   //checks if the credits are an integer.
            System.out.println("Credits completed invalid: not an integer!");
            return false;
        }
        return true;
    }

    /**
     Helper method for isAllowed() method, checks if student is allowed age.
     @param today date object containing current day.
     @param dob the student's date of birth.
     @return false if the student is too young, true otherwise.
     */
    private boolean isAllowedAge (Date today, Date dob){
        int yearDifference = today.getYear() - dob.getYear();
        int monthDifference = today.getMonth() - dob.getMonth();
        int dayDifference = today.getDay() - dob.getDay();
        if (yearDifference > Constant.MINIMUM_AGE.getValue()) {         //checks if student is of age.
            return true;
        }
        if (yearDifference < Constant.MINIMUM_AGE.getValue()) {
            return false;
        }
        if (monthDifference > 0) {
            return true;
        }
        if (monthDifference < 0) {
            return false;
        }
        return dayDifference >= 0;
    }

    /**
     Helper method for isAllowed() method, checks if a major is valid.
     @param major the major in question.
     @return false if major is not in the Major Enum class, true if it is.
     */
    private boolean isValidMajor (String major){
        for (Major validMajor : Major.values()) {
            if (major.toUpperCase().equals(validMajor.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     Prints a list of the students from a specified school.
     @param school school that you want to list from.
     */
    private void printList(String school){
        boolean allowedSchool = false;
        for (Major allowedMajor: Major.values()) {                          //first checks if the school is valid.
            if (school.toUpperCase().equals(allowedMajor.getSchool())) {
                allowedSchool = true;
                break;
            }
        }
        if(allowedSchool){
            System.out.println("* Students in " + school + " *");
            this.roster.list(school);
            System.out.println("* end of list **");
        } else {
            System.out.println("School doesn't exist: " + school);
        }
    }

    /**
      Prints error code saying that the roster is empty.
     */
    private void rosterEmpty() {
        System.out.println("Student roster is empty!");
    }

    /**
       Checks if a given string is numeric.
       @param string string to check.
       @return true if numeric, false if not.
     */
    public static boolean isNumeric(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}