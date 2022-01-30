package frc.robot.arc;

import sensors.linearServo.LinearServo;
import static frc.robot.arc.ArcConstants.*;

public class ArcComponentsBase implements ArcComponents {

    private final LinearServo linearServo;

    public ArcComponentsBase() {
        linearServo = new LinearServo(ARCH_CHANNEL, ARCH_MAX_LENGTH, ARC_MAX_SPEED);
    }

    @Override
    public LinearServo getLinearServo() {
        return linearServo;
    }
}
