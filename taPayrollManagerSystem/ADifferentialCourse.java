package taPayrollManagerSystem;

//This class extends ARegular course and inherits all of its fields & methods.
//Additionally, this class will implement certain methods like adding TAs
//differently because differential courses can have as many TAs as they want, 
//unlike regular courses.
public class ADifferentialCourse extends ARegularCourse{
	
	//This default constructor calls the super constructor from the parent class
	//to assign a new ADifferentialCourse object.
	public ADifferentialCourse(String department, int courseNumber, 
								int TAMaxNum) {
		super(department, courseNumber, TAMaxNum);
	}
	
	//This overridden method first checks if the provided name is
	//valid, that a TA of that name exists in the TAList and that the hourlyPay
	//is more than 0. If yes, then it checks if the list is full, and if yes 
	//it resizes the TAList and then adds a UGTA object with the provided 
	//firstName, lastName and hourlySalary to TAList. 
	@Override
	public boolean addUGTA(String firstName, String lastName,
            double hourlySalary) {
		
		if (!(isValidName(firstName, lastName)) ||
		TAList.findName(firstName, lastName) != null || hourlySalary <= 0) {
			return false;
		}
		
		if (TAList.isFull()) {
			TAList.resize();
		}
		
		TAList.add(new UGTA(firstName, lastName, hourlySalary));
		
		return true;
	}
	
	//This overridden method also first checks if the provided name is
	//valid, that a TA of that name exists in the TAList and that the hourlyPay
	//is more than 0. If yes, then it checks if the list is full, and if yes 
	//it resizes the TAList and then adds a GTA object with the provided 
	//firstName, lastName and hourlySalary to TAList. 
	@Override
	public boolean addGradTA(String firstName, String lastName,
              double yearlySalary) {
		
		if (!(isValidName(firstName, lastName)) ||
			TAList.findName(firstName, lastName) != null || yearlySalary <= 0) {
			return false;
		}
		
		if (TAList.isFull()) {
			TAList.resize();
		}
		
		TAList.add(new GTA(firstName, lastName, yearlySalary));
		
		return true;
	}
}
