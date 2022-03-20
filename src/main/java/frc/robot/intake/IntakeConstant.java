package frc.robot.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeConstant {

    static final DoubleSolenoid.Value PISTON_OPEN = DoubleSolenoid.Value.kForward;
    static final DoubleSolenoid.Value PISTON_CLOSE = DoubleSolenoid.Value.kReverse;
    static final double INTAKE_SPEED = 0.8;
    static double JOYSTICK_VALUE = 0;
    public static double OPEN_INTAKE_WITH_DELAY_SECONDS = 0.1;

    public static class FrontComponentConstants {

        static final int FRONT_MOTOR_ID = 5;
        static final int FRONT_SOLENOID_FORWARD_CHANNEL = 0;
        static final int FRONT_SOLENOID_REVERSE_CHANNEL = 1;
        static final double CURRENT_LIMIT_ENABLED_FRONT = 30;
        static final double SUPPLY_TRIGGER_THRESHOLD_CURRENT_FRONT = 0;
        static final double SUPPLY_TRIGGER_THRESHOLD_TIME_FRONT = 0;
        static final boolean SUPPLY_CURRENT_LIMIT_ENABLED_FRONT = true;
        static final double STATOR_CURRENT_LIMIT_FRONT = 0;
        static final double STATOR_TRIGGER_THRESHOLD_CURRENT_FRONT = 0;
        static final double STATOR_TRIGGER_THRESHOLD_TIME_FRONT = 0;
        static final boolean STATOR_CURRENT_LIMIT_ENABLED_FRONT = false;
        static final double OPEN_LOOP_RAMP_FRONT = 0;
        static final double CLOSE_LOOP_RAMP_FRONT = 0;
    }

    public static class BackComponentsConstants {

        static final int BACK_MOTOR_ID = 6;
        static final int BACK_SOLENOID_FORWARD_CHANNEL = 2;
        static final int BACK_SOLENOID_REVERSE_CHANNEL = 3;
        static final double SUPPLY_CURRENT_LIMIT_BACK = 30;
        static final double SUPPLY_TRIGGER_THRESHOLD_CURRENT_BACK = 0;
        static final double SUPPLY_TRIGGER_THRESHOLD_TIME_BACK = 0;
        static final boolean SUPPLY_CURRENT_LIMIT_ENABLED_BACK = true;
        static final double STATOR_CURRENT_LIMIT_BACK = 0;
        static final double STATOR_TRIGGER_THRESHOLD_CURRENT_BACK = 0;
        static final double STATOR_TRIGGER_THRESHOLD_TIME_BACK = 0;
        static final boolean STATOR_CURRENT_LIMIT_ENABLED_BACK = false;
        static final double OPEN_LOOP_RAMP_BACK = 0;
        static final double CLOSE_LOOP_RAMP_BACK = 0;
    }
}
