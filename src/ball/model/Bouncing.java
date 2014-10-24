package ball.model;

import ball.Ball;
import ball.ui.BallWorld;

public class Bouncing implements Behaviour {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;
    private Ball ball;
    private int y;

    public Bouncing(int direction) {
        this.direction = direction;
    }

    @Override
    public void apply(Ball ball) {
        this.ball = ball;
        this.y = ball.center().y;
        direction = reverseDirectionIfNecessary();
        move();
    }

    /**
     * ********************************************************************************
     * <p/>
     * Do not change Bouncing ALGORITHM below.
     * <p/>
     * *********************************************************************************
     */

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean movingTooLow() {
        return y + ball.radius() >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return y - ball.radius() <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private void move() {
        ball.setY(y + (MOVEMENT_SPEED * direction));
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
