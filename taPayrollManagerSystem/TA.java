package taPayrollManagerSystem;

//This abstract class defines what a TA object must contain and sets a model
//that will later be implemented and modified by two of its children classes. 
public abstract class TA {
	
	
	protected String firstName; 
	protected String lastName; 
	protected int numHours; 
	protected int numProjects; 
	
	//This constructor is used to create a TA object with firstName and lastName
	//All TAs start out with 0 office hours held and 0 projects graded
	public TA (String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		numHours = 0;
		numProjects = 0;
	
	}
	
	//When called on a TA object, this method will return the number of office
	//hours that TA has held
	public int getHours () {
		return numHours;
	}
	
	//When called on a TA object, this method will return the number of projects
	//that TA has graded
	public int projectsGraded () {
		return numProjects;
	}
	
	//When called on a TA object, this method will return true if the TA's
	//firstName and lastName match the ones in the parameter and if yes, return
	//true, otherwise, return false. 
	public boolean checkName (String firstName, String lastName) {
		
		if (this.firstName.equals(firstName) && this.lastName.equals(lastName)) {
			return true;
		}
		
		return false;
	}
	
	//To be implemented later, this method will add office hours for the TA it
	//is called on.
	public abstract boolean addHours (int hours);
	
	//To be implemented later, this method will add to the number of projects
	//graded by the TA it is called on.
	public abstract boolean gradeProjects (int projects);
	
	//To be implemented later, this method will return the paycheck amount for
	//the TA it is called on. 
	public abstract double getPayCheck ();
	
}
