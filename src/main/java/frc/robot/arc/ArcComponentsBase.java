package frc.robot.arc;

import sensors.linearServo.LinearServo;

import static frc.robot.arc.ArcConstants.RobotConstants.*;

public class ArcComponentsBase implements ArcComponents {

    private final LinearServo linearServo;

    public ArcComponentsBase() {
        linearServo = new LinearServo(LINEAR_SERVO_CHANNEL, LINEAR_SERVO_MAX_LENGTH, LINEAR_SERVO_MAX_SPEED);
    }

    @Override
    public LinearServo getLinearServo() {
        return linearServo;
    }
}
