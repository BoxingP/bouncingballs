package ball.model;

import ball.Ball;

import java.awt.*;

public class BallImpl implements Ball {
    protected int x;
    protected int y;
    protected int radius;
    protected Behaviour[] behaviours;

    protected BallImpl(int x, int y, int radius, Behaviour... behaviours) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.behaviours = behaviours;
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
    public void update(){
        for(Behaviour behaviour:behaviours){
            behaviour.apply(this);
        }
    };

    @Override
    public void setY(int y) {
        this.y= y;
    }

    @Override
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
