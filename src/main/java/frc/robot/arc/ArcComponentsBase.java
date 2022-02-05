package frc.robot.arc;

import static frc.robot.arc.ArcConstants.RobotConstants.*;

public class ArcComponentsBase implements ArcComponents {

    private final LinearServo linearServo;

    public ArcComponentsBase() {
        linearServo = new LinearServo(ARC_CHANNEL, ARC_MAX_LENGTH, ARC_MAX_SPEED);
    }

    @Override
    public LinearServo getLinearServo() {
        return linearServo;
    }
}
