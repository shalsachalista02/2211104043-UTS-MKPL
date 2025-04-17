public class EmployeeData {
	public String employeeId, firstName, lastName, idNumber, address;
	public int yearJoined, monthJoined, dayJoined;
	public boolean isForeigner, gender;

	public EmployeeData(String employeeId, String firstName, String lastName, String idNumber, String address,
						int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.isForeigner = isForeigner;
		this.gender = gender;
	}
}
