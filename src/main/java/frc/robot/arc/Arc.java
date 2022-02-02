package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.arc.ArcConstants.ArcCalculations.getLinearServoPositionFromAngle;

public class Arc extends SubsystemBase {

    private final ArcComponents arcComponents;

    public Arc(ArcComponents arcComponents) {
        this.arcComponents = arcComponents;
    }

    public void periodic() {
        arcComponents.getLinearServo().updateCurrentPosition();
    }

    public void setSpeed(double speed) {
        arcComponents.getLinearServo().setSpeed(speed);
    }

    public void initMoveArcToAngle(double angle) {
        arcComponents.getLinearServo().setPosition(getLinearServoPositionFromAngle(angle));
    }

    public void setPos(double position) {
        arcComponents.getLinearServo().setPosition(position);
        arcComponents.getLinearServo().updateCurrentPosition();
    }

    public void stop() {
        arcComponents.getLinearServo().setSpeed(0);
    }

    public boolean inPosition() {
        return arcComponents.getLinearServo().isOnTarget();
    }
}
