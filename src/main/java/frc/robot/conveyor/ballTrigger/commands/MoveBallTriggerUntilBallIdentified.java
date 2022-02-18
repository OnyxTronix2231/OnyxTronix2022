package frc.robot.conveyor.ballTrigger.commands;

import frc.robot.conveyor.ballTrigger.BallTrigger;

import java.util.function.DoubleSupplier;

public class MoveBallTriggerUntilBallIdentified extends MoveBallTriggerBySpeed {

    private final BallTrigger ballTrigger;

    public MoveBallTriggerUntilBallIdentified(BallTrigger ballTrigger, DoubleSupplier speedSupplier) {
        super(ballTrigger, speedSupplier);
        this.ballTrigger = ballTrigger;
    }

    @Override
    public boolean isFinished() {
        return ballTrigger.identifiedBall();
    }
}
