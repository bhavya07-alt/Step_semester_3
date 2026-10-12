
package OOP.class_problems;

import java.util.Scanner;

abstract class Booking {
    private static final double BOOKING_FEE = 50.0;

    double distanceKm;

    Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateBaseFare();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateBaseFare() {
        return 2500.0 + distanceKm * 4.0;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;
                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;
                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }

            System.out.printf("%s: %.2f%n",
                    mode, booking.calculateTotal());
        }

        sc.close();
    }
}
