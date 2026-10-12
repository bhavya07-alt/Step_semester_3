
package OOP.assignment_problems;

import java.util.Scanner;

interface EmployeeBonus {
    double calculateBonus();
    String getName();
}

class FullTimeEmployee implements EmployeeBonus {
    private final String name;
    private final double salary;

    FullTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }

    public String getName() {
        return name;
    }
}

class PartTimeEmployee implements EmployeeBonus {
    private final String name;
    private final double salary;

    PartTimeEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }

    public String getName() {
        return name;
    }
}

class Intern implements EmployeeBonus {
    private final String name;

    Intern(String name, double salary) {
        this.name = name;
    }

    public double calculateBonus() {
        return 2000.0;
    }

    public String getName() {
        return name;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            double salary = sc.nextDouble();

            EmployeeBonus employee;

            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;
                case "INTERN":
                    employee = new Intern(name, salary);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid employee type");
            }

            double bonus = employee.calculateBonus();
            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
