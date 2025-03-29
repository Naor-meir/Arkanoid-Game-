package GameInfo;

/**
 * The type Counter.
 */
public class Counter {
    private int counter = 0;

    /**
     * Increase.
     *
     * @param number the number
     */
// add number to current count.
    public void increase(int number) {
        this.counter = counter + number;
    }

    /**
     * Decrease.
     *
     * @param number the number
     */
// subtract number from current count.
    void decrease(int number) {
        this.counter = counter - number;
        if (this.counter < 0) {
            this.counter = 0;
        }
    }

    /**
     * Gets value.
     *
     * @return the value
     */
// get current count.
    public int getValue() {
        return this.counter;
    }

    /**
     * Sets counter.
     *
     * @param counter the counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
}