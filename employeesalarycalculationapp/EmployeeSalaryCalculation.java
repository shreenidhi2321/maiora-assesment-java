package employeesalarycalculationapp;
import java.util.Scanner;

public class EmployeeSalaryCalculation {
	
		    public static double calculateWeeklySalary(double hourlyRate, double hoursWorked) {
	        double regularHours = Math.min(hoursWorked, 40);
	        double overtimeHours = Math.max(hoursWorked - 40, 0);

	        double regularPay = regularHours * hourlyRate;
	        double overtimePay = overtimeHours * hourlyRate * 1.5;

	        return regularPay + overtimePay;
	    }

	    public static double calculateMonthlySalary(double hourlyRate, double weeklyHours) {
	        double weeklySalary = calculateWeeklySalary(hourlyRate, weeklyHours);
	        double grossMonthlySalary = weeklySalary * 4; // Assuming 4 weeks per month
	        double taxDeduction = grossMonthlySalary * 0.10;
	        return grossMonthlySalary - taxDeduction;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter hourly rate: ");
	        double hourlyRate = scanner.nextDouble();

	        System.out.print("Enter hours worked per week: ");
	        double weeklyHours = scanner.nextDouble();

	        double netMonthlySalary = calculateMonthlySalary(hourlyRate, weeklyHours);

	        System.out.println("Net Monthly Salary after 10% tax "+ netMonthlySalary);
	        scanner.close();
	    }
	}



