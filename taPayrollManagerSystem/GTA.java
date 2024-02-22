package taPayrollManagerSystem;

//This class will create graduate TA objects and it extends the prototype of the
//abstract TA class. It will implement the abstract methods from its parent class
//in a different way than the UGTA class.
public class GTA extends TA{
	
	private static final int MAXPROJECTS = 150; 
	private double yearlyRate; 

	//Initial constructor that creates a Graduate TA object with firstName,
	//lastName and yearly salary.
	public GTA(String firstName, String lastName, double yearlyRate) {
		
		super(firstName, lastName);
		this.yearlyRate = yearlyRate;
		
	}
	
	//Since a graduate TA can hold unlimited office hours, this method will 
	//simply just add the hours provided in the parameter to numHours and return
	//true.
	@Override
	public boolean addHours(int hours) {
		
		numHours += hours;
		return true;
	
	}

	//If a graduate TA won't surpass the maximum amount of projects they can
	//grade after grading the number of projects provided in the parameter, then
	//this method will add projects to numProjects and return true. Otherwise,
	//it will return false.
	@Override
	public boolean gradeProjects(int projects) {
		
		if (projects + numProjects <= MAXPROJECTS) {
			numProjects += projects;
			return true;
		}
		
		return false;
	}
	
	//This method just generates a paycheck by dividing the yearly salary by the
	//number of pay periods, which is 21 in this case, and returning that.
	@Override
	public double getPayCheck() {
		return yearlyRate/21;
	}

}
