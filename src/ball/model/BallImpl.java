package ball.model;

import ball.Ball;

import java.awt.*;

public abstract class BallImpl implements Ball {
    protected int x;
    protected int y;
    protected int radius;

    protected BallImpl(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    protected BallImpl(int x, int y) {
        this(x, y, DEFAULT_RADIUS);
    }

    // DO NOT CHANGE
    @Override
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    @Override
    public Point center() {
        return new Point(x, y);
    }

    // DO NOT CHANGE
    @Override
    public abstract void update();
}
