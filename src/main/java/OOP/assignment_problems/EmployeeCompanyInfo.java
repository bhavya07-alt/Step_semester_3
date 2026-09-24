package OOP.assignment_problems;

public class EmployeeCompanyInfo {

    String empName;
    double salary;

    static String companyName =
            "Bright Horizon Technologies";

    static int employeeCount = 0;

    EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println(
                "Employees on record: " + employeeCount
        );
    }

    public static void main(String[] args) {

        EmployeeCompanyInfo employee1 =
                new EmployeeCompanyInfo("Ravi", 50000);

        EmployeeCompanyInfo employee2 =
                new EmployeeCompanyInfo("Priya", 60000);

        EmployeeCompanyInfo employee3 =
                new EmployeeCompanyInfo("Arjun", 55000);

        EmployeeCompanyInfo.printCompanyInfo();
    }
}