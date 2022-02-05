package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arc extends SubsystemBase {

    private final ArcComponents arcComponents;

    public Arc(ArcComponents arcComponents) {
            this.arcComponents = arcComponents;
        }

        public void periodic() {
            arcComponents.getLinearServo().updateCurrentPosition();
            //System.out.println(arcComponents.getLinearServo().getPosition());
    }

    public void setSpeed(double speed) {
        arcComponents.getLinearServo().setMotorSpeed(speed);
    }

    public void setPos(double position) {
        arcComponents.getLinearServo().setPosition(position);
    }

    public void stop() {
        arcComponents.getLinearServo().setMotorSpeed(0);
    }

    public boolean isOnTarget() {
        return arcComponents.getLinearServo().isOnTarget();
    }
}
