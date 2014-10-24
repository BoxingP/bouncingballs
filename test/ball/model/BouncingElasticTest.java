package ball.model;

import ball.Ball;
import org.junit.Test;

import static ball.BallTestHarness.*;

public class BouncingElasticTest {
    @Test
    public void shouldGoDownAndDecreaseRadius() {
        Ball bouncingElasticBall = BallFactory.bouncingElasticBall(0, 100, 20, Bouncing.DOWN, Elastic.SHRINK);

        bouncingElasticBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(100), bouncingElasticBall);
        assertRadiusIs(oneStepInwardsFrom(20), bouncingElasticBall);
    }
}
