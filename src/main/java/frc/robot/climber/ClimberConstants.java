package frc.robot.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ClimberConstants {

    static final int SOLENOID_FORWARD_CHANNEL = 5; // TODO: CHECK AND FIX
    static final int SOLENOID_REVERSE_CHANNEL = 6; // TODO: CHECK AND FIX
    static final int LEFT_MOTOR_DEVICE_NUMBER = 14;
    static final int RIGHT_MOTOR_DEVICE_NUMBER = 15;
    static final int DESIRED_ENCODER_UNITS = 0; //TODO: CHECK AND FIX
    static final DoubleSolenoid.Value SOLENOID_OPEN_VALUE = DoubleSolenoid.Value.kForward;
    static final DoubleSolenoid.Value SOLENOID_CLOSE_VALUE = DoubleSolenoid.Value.kReverse;

    static final double OPEN_CLIMBER_SPEED = 0.8;
    static final double CLOSE_CLIMBER_SPEED = 0.6;
    static final double SLOW_ARM_SPEED = 1;
    static final double SUPPLY_CURRENT_LIMIT = 20;
    static final double SUPPLY_TRIGGER_THRESHOLD_CURRENT = 0;
    static final double SUPPLY_TRIGGER_THRESHOLD_TIME = 0;
    static final double STATOR_CURRENT_LIMIT = 0;
    static final double STATOR_TRIGGER_THRESHOLD_CURRENT = 0;
    static final double STATOR_TRIGGER_THRESHOLD_TIME = 0;
    static final boolean SUPPLY_CURRENT_LIMIT_ENABLED = true;
    static final boolean STATOR_CURRENT_LIMIT_ENABLED = false;

    static final double OPEN_LOOP_RAMP = 0;
    static final double CLOSE_LOOP_RAMP = 0;
}
