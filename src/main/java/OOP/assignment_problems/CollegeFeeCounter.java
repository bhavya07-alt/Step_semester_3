
package OOP.assignment_problems;

import java.util.Scanner;

abstract class Student {
    private static final double TRANSPORT_FEE = 12000.0;
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    double calculateOtherFees() {
        return 0.0;
    }

    boolean usesBus() {
        return false;
    }

    double calculateTotalFee() {
        double total = calculateTuition() + calculateOtherFees();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 40000.0;
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 40000.0;
    }

    @Override
    double calculateOtherFees() {
        return 60000.0;
    }
}

class ScholarshipStudent extends Student {
    ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    double calculateTuition() {
        return 20000.0;
    }

    @Override
    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }

            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
