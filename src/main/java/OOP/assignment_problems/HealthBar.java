
package OOP.assignment_problems;

public class HealthBar {
    private int health;
    private final int maxHealth;

    public HealthBar(int maxHealth) {
        if (maxHealth < 0) {
            throw new IllegalArgumentException("Maximum health cannot be negative");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            health = Math.max(0, health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            health = Math.min(maxHealth, health + amount);
        }
    }

    public int getHealth() {
        return health;
    }
}
