
package OOP.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

interface LibraryItem {
    int borrowingDays();
    String getTitle();
}

class Book implements LibraryItem {
    private final String title;

    Book(String title) {
        this.title = title;
    }

    public int borrowingDays() {
        return 14;
    }

    public String getTitle() {
        return title;
    }
}

class DVD implements LibraryItem {
    private final String title;

    DVD(String title) {
        this.title = title;
    }

    public int borrowingDays() {
        return 7;
    }

    public String getTitle() {
        return title;
    }
}

class Magazine implements LibraryItem {
    private final String title;

    Magazine(String title) {
        this.title = title;
    }

    public int borrowingDays() {
        return 3;
    }

    public String getTitle() {
        return title;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            switch (type.toUpperCase()) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid item type");
            }

            LocalDate dueDate =
                    currentDate.plusDays(item.borrowingDays());

            System.out.println(item.getTitle() + ": " + dueDate);
        }

        sc.close();
    }
}
