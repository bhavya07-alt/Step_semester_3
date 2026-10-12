
package OOP.class_problems;

import java.util.Scanner;

interface Payment {
    double calculateAmount(double amount);
    String getType();
}

class CardPayment implements Payment {
    public double calculateAmount(double amount) {
        return amount * 1.02;
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment implements Payment {
    public double calculateAmount(double amount) {
        return amount * 1.01;
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment implements Payment {
    public double calculateAmount(double amount) {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment();
                    break;
                case "WALLET":
                    payment = new WalletPayment();
                    break;
                case "BANKTRANSFER":
                    payment = new BankTransferPayment();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid payment type");
            }

            double adjusted = payment.calculateAmount(amount);
            System.out.printf("%s: %.2f%n",
                    payment.getType(), adjusted);

            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
