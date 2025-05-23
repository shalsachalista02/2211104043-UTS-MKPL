package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private String employeeId;
    private PersonalIdentity identity;

    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;

    private boolean isForeigner;
    private boolean gender; // true = Laki-laki, false = Perempuan

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private String spouseName;
    private String spouseIdNumber;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(EmployeeData data) {
        this.employeeId = data.employeeId;
        this.identity = data.identity;
        this.yearJoined = data.yearJoined;
        this.monthJoined = data.monthJoined;
        this.dayJoined = data.dayJoined;
        this.isForeigner = data.isForeigner;
        this.gender = data.gender;

        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }

    /**
     * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya 
     * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
     * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
     */
    public void setMonthlySalary(int grade) {
        int baseSalary;
switch (grade) {
	case 1:
		baseSalary = 3000000;
		break;
	case 2:
		baseSalary = 5000000;
		break;
	case 3:
		baseSalary = 7000000;
		break;
	default:
		baseSalary = 0;
		break;
	}
		
        // Jika pegawai adalah warga negara asing, gaji diperbesar 50%
        if (isForeigner) {
            baseSalary *= 1.5;
        }
        this.monthlySalary = baseSalary;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;  // Memperbaiki penetapan spouseIdNumber
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int getAnnualIncomeTax() {
        // Menghitung berapa lama pegawai bekerja dalam setahun ini
        LocalDate date = LocalDate.now();

        if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
        } else {
            monthWorkingInYear = 12;
        }

        // Menghitung pajak dengan metode calculateTax
        boolean isMarried = !spouseIdNumber.isEmpty();  // Jika ada spouseIdNumber, berarti sudah menikah

        return TaxFunction.calculateTax(
            monthlySalary,
            otherMonthlyIncome,
            monthWorkingInYear,
            annualDeductible,
            isMarried,
            childIdNumbers.size()
        );
    }
}
