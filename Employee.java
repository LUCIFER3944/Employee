import java.util.Scanner;

public class Employee {
    private String name;
    private String mobileNumber;
    private double monthlySalary;
    private double ta;
    private double da;
    private double hra;

    public Employee(String name, String mobileNumber, double monthlySalary, double ta, double da, double hra) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.monthlySalary = monthlySalary;
        this.ta = ta;
        this.da = da;
        this.hra = hra;
    }

    public double calculateAnnualSalary() {
        return (monthlySalary * 12) + ta + da + hra;
    }

    public double calculateTax() {
        double annualSalary = calculateAnnualSalary();
        double tax;
        if (annualSalary <= 250000) {
            tax = 0;
        } else if (annualSalary <= 500000) {
            tax = (annualSalary - 250000) * 0.05;
        } else if (annualSalary <= 1000000) {
            tax = 12500 + (annualSalary - 500000) * 0.2;
        } else {
            tax = 112500 + (annualSalary - 1000000) * 0.3;
        }
        return tax;
    }

    public double calculateNetSalary() {
        return calculateAnnualSalary() - calculateTax();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Employee Salary Calculator");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter mobile number: ");
        String mobileNumber = scanner.nextLine();

        System.out.print("Enter monthly salary: ");
        double monthlySalary = scanner.nextDouble();

        System.out.print("Enter TA (Travel Allowance): ");
        double ta = scanner.nextDouble();

        System.out.print("Enter DA (Dearness Allowance): ");
        double da = scanner.nextDouble();

        System.out.print("Enter HRA (House Rent Allowance): ");
        double hra = scanner.nextDouble();

        Employee employee = new Employee(name, mobileNumber, monthlySalary, ta, da, hra);

        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + employee.name);
        System.out.println("Mobile Number: " + employee.mobileNumber);
        System.out.println("Monthly Salary: " + employee.monthlySalary);
        System.out.println("Annual Salary: " + employee.calculateAnnualSalary());
        System.out.println("Tax Deducted: " + employee.calculateTax());
        System.out.println("Net Salary: " + employee.calculateNetSalary());
    }
}
