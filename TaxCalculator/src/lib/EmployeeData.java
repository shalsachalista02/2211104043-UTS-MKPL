package lib;

public class EmployeeData {
	public String employeeId;
    public PersonalIdentity identity;
	public int yearJoined, monthJoined, dayJoined;
	public boolean isForeigner, gender;

	public EmployeeData(String employeeId, PersonalIdentity identity,
					int yearJoined, int monthJoined, int dayJoined, 
                    boolean isForeigner, boolean gender) {
	this.employeeId = employeeId;
	this.identity = identity;
	this.yearJoined = yearJoined;
	this.monthJoined = monthJoined;
	this.dayJoined = dayJoined;
	this.isForeigner = isForeigner;
	this.gender = gender;
    }
}
