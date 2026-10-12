
package OOP.assignment_problems;

import java.util.Scanner;

interface SaverMode {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    boolean supportsSaver() {
        return false;
    }

    double calculateUnits(boolean saver) {
        double units = getPower() * hours / 1000.0;

        if (saver && supportsSaver()) {
            units *= SaverMode.SAVER_FACTOR;
        }

        return units;
    }

    double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 1500.0;
    }

    @Override
    boolean supportsSaver() {
        return true;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    @Override
    double getPower() {
        return 500.0;
    }

    @Override
    boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = sc.hasNext("SAVER");
            if (saver) {
                sc.next();
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid appliance");
            }

            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(saver);
            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
