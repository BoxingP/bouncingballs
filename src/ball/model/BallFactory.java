package ball.model;

import ball.Ball;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, Bouncing.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
                bouncingElasticBall(350, 50, Ball.DEFAULT_RADIUS, Bouncing.DOWN, Elastic.SHRINK)
        };
    }

    public static Ball bouncingElasticBall(int centerX, int centerY, int radius, int bouncingDirection, int shrinkDirection) {
        return new BallImpl(centerX, centerY, radius, new Bouncing(bouncingDirection), new Elastic(shrinkDirection));
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        return new BallImpl(centerX, centerY, Ball.DEFAULT_RADIUS, new Bouncing(direction));
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        return new BallImpl(centerX, centerY, radius, new Elastic(direction));
    }
}
