package ball.model;

import ball.Ball;

public class Elastic implements Behaviour {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;
    private Ball ball;
    private int radius;

    Elastic(int growthDirection) {
        this.growthDirection = growthDirection;
    }

    @Override
    public void apply(Ball ball) {
        this.ball = ball;
        this.radius = ball.radius();
        growthDirection = reverseGrowthDirectionIfNecessary();
        next();
    }

    /**
     * ********************************************************************************
     * <p/>
     * Do not change Elastic ALGORITHM below.
     * <p/>
     * *********************************************************************************
     */

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private void next() {
        ball.setRadius(radius + (GROWTH_RATE * growthDirection));
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }
}
