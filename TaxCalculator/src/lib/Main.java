package lib;

public class Main {
    public static void main(String[] args) {
        PersonalIdentity identity = new PersonalIdentity("John", "Doe", "123456789", "Jalan Raya No. 123");
        EmployeeData data = new EmployeeData("E001", identity, 2020, 5, 15, false, true);

        Employee employee = new Employee(data);
        employee.setMonthlySalary(2); // Set grade 2
        employee.setAnnualDeductible(5000000); // Set deductible
        employee.setAdditionalIncome(2000000); // Set other income
        employee.setSpouse("Jane Doe", "987654321");

        employee.addChild("Alice", "C001");
        employee.addChild("Bob", "C002");

        int tax = employee.getAnnualIncomeTax();
        System.out.println("Annual Income Tax: " + tax);
    }
}
