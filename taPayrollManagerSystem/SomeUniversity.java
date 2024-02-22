package taPayrollManagerSystem;

//This class provides methods for a university create either a regular course
//or a differential course. 
public class SomeUniversity {
	
	//This static method creates an ARegularCourse object with the department,
	//courseNumber, and TAMaxNum as provided in the parameter after checking
	//if the course is valid or not. It returns the new object created. 
    public static ARegularCourse createARegularCourse(String department,
                                                  int courseNumber,
                                                  int TAMaxNum) {
    	
    	if (!isValidCourse(department, courseNumber, TAMaxNum)) {
    		return null;
    	}
    	
    	return new ARegularCourse(department, courseNumber, TAMaxNum);
    }
    
    //This static method creates an ADifferentialCourse object with the 
  	//department, courseNumber, and TAMaxNum as provided in the parameter after 
  	//checking if the course is valid or not. It returns the new object created. 
    public static ARegularCourse createADifferentialCourse(String department,
                                                       int courseNumber,
                                                       int TAMaxNum) {
    	
    	if (!isValidCourse(department, courseNumber, TAMaxNum)) {
    		return null;
    	}
    	
    	return new ADifferentialCourse(department, courseNumber, TAMaxNum);
    }
    
    //This private method checks if a provided course information is valid by
    //checking that the department isn't null or empty, that the courseNumber is
    //more than 99, and that the TAMaxNum is more than 0.
    private static boolean isValidCourse (String department, int courseNumber, 
    								int TAMaxNum) {
    	
    	if (department == null || department.isEmpty() ||
    			courseNumber < 100 || TAMaxNum <= 0 ) {
    		return false;
    	}
    	
    	return true;
    }
    							
}
