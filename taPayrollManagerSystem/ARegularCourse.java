package taPayrollManagerSystem;

//This class has a constructor that will create an ARegularCourse object and
//its methods will be used to perform various tasks like adding TAs, 
//holding their office hours and more. 
public class ARegularCourse {
	
	
	private String department; 
	private int courseNumber; 
	private int TAMaxNum; 
	LarryList TAList;  
	
	//This constructor creates an ARegularCourse object whose fields are
	//assigned accordingly to the parameters and a new LarryList is also
	//initialized with the capacity TAMaxNum, indicating the maximum amount of
	//TAs this course can have. 
    public ARegularCourse(String department, int courseNumber, int TAMaxNum) {
    	
    	this.department = department;
    	this.courseNumber = courseNumber;
    	this.TAMaxNum = TAMaxNum;
    	TAList = new LarryList(TAMaxNum);
    
    }
    
    //This method combines the department name and course number, separates
    //them with a space and returns the new String as the courseName.
    public String getCourseName() {
        return department + " " + courseNumber;
    }
    
    //This method first checks if the provided name is valid, that someone with
    //the same name doesn't exist in the list, that the list is not full, and 
    //that the hourly salary is more than 0. If it passes that test, then it
    //creates a new UGTA object with the provided name and hourly salary and
    //adds it to the the TAList. 
    public boolean addUGTA(String firstName, String lastName,
                           double hourlySalary) {
        
    	if (!(isValidName(firstName, lastName)) || TAList.isFull() ||
        	TAList.findName(firstName, lastName) != null || hourlySalary <= 0) {	
        	return false;
        }
        
       	TAList.add(new UGTA(firstName, lastName, hourlySalary));
       	
       	return true;
    }
    
    //This method, much like the addUGTA one, checks for all the exceptions
    //and if none found, then a new GTA object will be created and added to the
    //TAList.
    public boolean addGradTA(String firstName, String lastName,
                             double yearlySalary) {
    	
    	if (!(isValidName(firstName, lastName)) || TAList.isFull() ||
           	TAList.findName(firstName, lastName) != null || yearlySalary <= 0) {
           	return false;
        }
    	
    	TAList.add(new GTA(firstName, lastName, yearlySalary));
    	
    	return true;
    }
    
    //This method uses the getCurrCapacityAmt() method from the LarryList
    //class to return the size of our current TAList for this course.
    public int getTACapacity() {
    	return TAList.getCurrCapacityAmt();
    }

    //This method uses the numCanBeAdded() method from the LarryList class
    //to return the amount of free spaces in the TAList for this course.
    public int extraCapacity() {
        return TAList.numCanBeAdded();
    }

    //This method first checks if the provided name is valid, that someone with
    //the same name exists in the list, and that the numHours parameter is more
    //than 0. If no exceptions are found then the method finds the TA in the 
    //list with the provided name and adds numHours hours for them.
    public boolean holdSomeOfficeHours(String firstName, String lastName,
                                       int numHours) {
    	
    	if (!(isValidName(firstName, lastName)) || numHours <= 0 ||
            TAList.findName(firstName, lastName) == null) {
         	return false;
        }
    	
    	TA temp = TAList.findName(firstName, lastName);
    	
    	return temp.addHours(numHours);
    	
    }

    //Much like the previous method, this one checks if a valid name is 
    //provided and that a TA with the name provided exists in the TAList. If
    //yes, the method assigns the TA object with the matching name to the temp
    //variable and returns the number of hours they have. 
    public int numOfficeHoursHeld(String firstName, String lastName) {
    	
    	if (!(isValidName(firstName, lastName)) ||
            TAList.findName(firstName, lastName) == null) {
         	return -1;
    	}
    	
    	TA temp = TAList.findName(firstName, lastName);
    	
    	return temp.getHours();
    }

    //This method first checks if the provided name is valid, that the name
    //exists in the TAList, and that the number of projects are more than 0.
    //If yes, then it finds the TA with matching name, assign the temp variable
    //to that TA object, and calls the gradeProjects() method on the object.
    public boolean gradeProjects(String firstName, String lastName,
                                 int numProjects) {
    	
    	if (!(isValidName(firstName, lastName)) || numProjects <= 0 ||
            TAList.findName(firstName, lastName) == null) {
           	return false;
        }
    	
    	TA temp = TAList.findName(firstName, lastName);
    	
    	return temp.gradeProjects(numProjects);
    }
    
    //This method first checks if the provided name is valid and if a TA
    //with matching name exists. If yes, then it finds the TA, assigns it to 
    //the temp variable and then uses the projectsGraded() method to get the
    //amount of projects graded by the TA. 
    public int numProjectsGraded(String firstName, String lastName) {
    	
    	if (!(isValidName(firstName, lastName)) ||
            TAList.findName(firstName, lastName) == null) {
           	return -1;
        }
    	
    	TA temp = TAList.findName(firstName, lastName);
    	
    	return temp.projectsGraded();
    }

    //As usual, the method first checks if the name is valid and that TA of 
    //that name exists in the TAList. If yes, then it assigns that TA to the
    //temp variable and then calls the getPayCheck method on it to return the
    //amount of money the TA made in one pay period.
    public double getPaycheckAmount(String firstName, String lastName) {
    	
    	if (!(isValidName(firstName, lastName)) ||
            TAList.findName(firstName, lastName) == null) {
          	return -1.0;
        }
    	
    	TA temp = TAList.findName(firstName, lastName);
    	
    	return temp.getPayCheck();
    }
    
    //This protected method checks if the provided firstName and lastName are
    //null or blank and if yes, it returns false, otherwise, true.
    protected boolean isValidName (String firstName, String lastName) {
    	
    	if (firstName == null || lastName == null ||
    		firstName.isBlank() || lastName.isBlank()) {
    		return false;
    	}
    	
    	return true;
    }

}
