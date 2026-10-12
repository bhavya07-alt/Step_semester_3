
package OOP.class_problems;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxStudents) {
        presentStudents = new String[maxStudents];
        presentCount = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = name;
            presentCount++;
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}
