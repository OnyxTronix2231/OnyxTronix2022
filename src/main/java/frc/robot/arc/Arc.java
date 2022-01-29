package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arc extends SubsystemBase {

    private ArcComponents arcComponents;

    public Arc(ArcComponents arcComponents) {
        this.arcComponents = arcComponents;
    }

    public void periodic() {
        arcComponents.getLinearServo().updateCurrentPosition();
    }

    public void setSpeed(double speed) {
        arcComponents.getLinearServo().setSpeed(speed);
    }

    public void stop() {
        arcComponents.getLinearServo().setSpeed(0);
    }
}