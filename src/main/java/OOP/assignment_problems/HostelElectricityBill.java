
package OOP.assignment_problems;

import java.util.Scanner;

interface Room {
    double calculateBill();
    String getType();
}

class SingleRoom implements Room {
    private final int units;

    SingleRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 8.0;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom implements Room {
    private final int units;
    private final int occupants;

    SharedRoom(int units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class AcRoom implements Room {
    private final int units;

    AcRoom(int units) {
        this.units = units;
    }

    public double calculateBill() {
        return units * 10.0 + 200;
    }

    public String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(units, occupants);
                    break;
                case "AC":
                    room = new AcRoom(units);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid room type");
            }

            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
