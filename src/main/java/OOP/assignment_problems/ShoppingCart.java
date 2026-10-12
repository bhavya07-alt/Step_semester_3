
package OOP.assignment_problems;

public class ShoppingCart {
    private final double[] prices;
    private int itemCount;
    private final String cartId;

    public ShoppingCart(String cartId, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.cartId = cartId;
        prices = new double[capacity];
        itemCount = 0;
    }

    public void addItem(double price) {
        if (price >= 0 && itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else if (itemCount >= prices.length) {
            System.out.println("Cart is full");
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}
