package frc.robot.conveyor.ballTrigger;

import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.DISTANCE_WHEN_BALL_IDENTIFIED;

public class BallTrigger extends SubsystemBase {

    private final BallTriggerComponents ballTriggerComponents;
    private boolean lastBallIdentifiedChecked;

    public BallTrigger(BallTriggerComponents ballTriggerComponents) {
        this.ballTriggerComponents = ballTriggerComponents;
        lastBallIdentifiedChecked = identifiedBall();
    }

    public void moveBallTriggerBySpeed(double speed) {
        ballTriggerComponents.getMotor().set(speed);
    }

    public void stop() {
        moveBallTriggerBySpeed(0);
    }

    public boolean identifiedBall() {
        return ballTriggerComponents.getDistanceSensor()
                .getRange(Rev2mDistanceSensor.Unit.kMillimeters) <= DISTANCE_WHEN_BALL_IDENTIFIED;
    }

    public boolean isBallOut() {
        boolean ballOut = false;
        boolean currentBallIdentifiedCheck = identifiedBall();
        if (lastBallIdentifiedChecked && !currentBallIdentifiedCheck) {
            ballOut = true;
        }
        lastBallIdentifiedChecked = currentBallIdentifiedCheck;
        return ballOut;
    }
}
