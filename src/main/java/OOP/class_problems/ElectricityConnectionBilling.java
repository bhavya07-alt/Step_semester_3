
package OOP.class_problems;

import java.util.Scanner;

abstract class ElectricityConnection {
    double units;

    ElectricityConnection(double units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class HomeConnection extends ElectricityConnection {
    HomeConnection(double units) {
        super(units);
    }

    @Override
    double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class ShopConnection extends ElectricityConnection {
    ShopConnection(double units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8.0 + 100;
    }
}

class FactoryConnection extends ElectricityConnection {
    FactoryConnection(double units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();

            ElectricityConnection connection;

            switch (type) {
                case "HOME":
                    connection = new HomeConnection(units);
                    break;
                case "SHOP":
                    connection = new ShopConnection(units);
                    break;
                case "FACTORY":
                    connection = new FactoryConnection(units);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid connection type");
            }

            double bill = connection.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
