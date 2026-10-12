
package OOP.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

interface SubscriptionPlan {
    int validityDays();
    String getName();
    LocalDate getStartDate();
}

class BasicPlan implements SubscriptionPlan {
    private final String name;
    private final LocalDate startDate;

    BasicPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public int validityDays() {
        return 30;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}

class StandardPlan implements SubscriptionPlan {
    private final String name;
    private final LocalDate startDate;

    StandardPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public int validityDays() {
        return 90;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}

class PremiumPlan implements SubscriptionPlan {
    private final String name;
    private final LocalDate startDate;

    PremiumPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public int validityDays() {
        return 365;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}

public class StreamingRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            SubscriptionPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    plan = new StandardPlan(name, startDate);
                    break;
                case "PREMIUM":
                    plan = new PremiumPlan(name, startDate);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid plan type");
            }

            LocalDate renewalDate =
                    plan.getStartDate().plusDays(plan.validityDays());

            System.out.println(plan.getName() + ": " + renewalDate);
        }

        sc.close();
    }
}
