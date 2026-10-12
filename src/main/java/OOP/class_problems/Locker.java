
package OOP.class_problems;

public class Locker {
    private String combination;
    private final int lockerNumber;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combination.equals(currentCode)) {
            combination = newCode;
            System.out.println("Code changed successfully");
            return true;
        } else {
            System.out.println("Incorrect current code. Change rejected");
            return false;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}
