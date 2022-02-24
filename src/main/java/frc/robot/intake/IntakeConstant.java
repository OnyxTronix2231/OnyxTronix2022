package frc.robot.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeConstant {

    static final DoubleSolenoid.Value PISTON_OPEN = DoubleSolenoid.Value.kForward;
    static final DoubleSolenoid.Value PISTON_CLOSE = DoubleSolenoid.Value.kReverse;
    public static final double INTAKE_SPEED = 0.8;
    public static double JOYSTICK_VALUE = 0;

    public static class FrontComponentsConstants {

        static final int FRONT_MOTOR_ID = 5;
        static final int FRONT_SOLENOID_FORWARD_CHANNEL = 0;
        static final int FRONT_SOLENOID_REVERSE_CHANNEL = 1;
    }

    public static class BackComponentConstants {

        static final int BACK_MOTOR_ID = 6;
        static final int BACK_SOLENOID_FORWARD_CHANNEL = 2;
        static final int BACK_SOLENOID_REVERSE_CHANNEL = 3;
    }
}
