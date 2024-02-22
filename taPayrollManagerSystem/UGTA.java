package taPayrollManagerSystem;

//This child class creates an undergraduate TA object that will inherit methods
//from its abstract parent class and implement them in its own way, separate from
//the graduate TA class.
public class UGTA extends TA{
	
	private static final int MAXHOURS = 20; 
	private double hourlyRate; 
	private int projectHours; 
	
	//This initial constructor creates a new undergraduate TA object with
	//firstName, lastName, and hourlyRate with the initial amount of project
	//hours being 0.
	public UGTA(String firstName, String lastName, double hourlyRate) {
		
		super(firstName, lastName);
		this.hourlyRate = hourlyRate;
		projectHours = 0;
	
	}
	
	//If adding hours to numHours wont surpass the MAXHOURS limit, this method
	//will do so and return true, otherwise, it will return false since an
	//undergraduate can only work for 20 hours. 
	@Override
	public boolean addHours(int hours) {
		
		if (!(hours + numHours > MAXHOURS)) {
			numHours += hours;
			return true;
		}
	
		return false;
	}
	
	//Since grading two projects takes an hour, if grading the given projects
	//and adding that time to the number of hours worked won't surpass MAXHOURS,
	//the method will do so, add to project hours, and then add projectHours
	//and return true, otherwise, return false.
	@Override
	public boolean gradeProjects(int projects) {
		
		if (projects%2 == 0 && (numHours + projects/2 <= 20)) {
			
			numProjects += projects;
			projectHours += (projects/2);
			return true;
		
		}
		
		return false;
	}

	//This method will calculate the paychecks by multiplying projectHours and
	//office hours by hourly rate and returning thier sum.
	@Override
	public double getPayCheck() {
		return numHours*hourlyRate + projectHours*hourlyRate;
	}

}
