package frc.robot.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ClimberConstants {

   static final int RIGHT_SOLENOID_FORWARD_CHANNEL = 5; // TODO: CHECK AND FIX
   static final int RIGHT_SOLENOID_REVERSE_CHANNEL = 6; // TODO: CHECK AND FIX
   static final int LEFT_SOLENOID_FORWARD_CHANNEL = 4; // TODO: CHECK AND FIX
   static final int LEFT_SOLENOID_REVERSE_CHANNEL = 7; // TODO: CHECK AND FIX
   static final int LEFT_MOTOR_DEVICE_NUMBER = 13;
   static final int RIGHT_MOTOR_DEVICE_NUMBER = 14;
   static final int DESIRED_ENCODER_UNITS = 0; //TODO: CHECK AND FIX
   static final DoubleSolenoid.Value RIGHT_SOLENOID_OPEN_VALUE = DoubleSolenoid.Value.kForward;
   static final DoubleSolenoid.Value RIGHT_SOLENOID_CLOSE_VALUE = DoubleSolenoid.Value.kReverse;
   static final DoubleSolenoid.Value LEFT_SOLENOID_OPEN_VALUE = DoubleSolenoid.Value.kForward;
   static final DoubleSolenoid.Value LEFT_SOLENOID_CLOSE_VALUE = DoubleSolenoid.Value.kReverse;
   static final double OPEN_CLIMBER_SPEED = 0;
   static final double CLOSE_CLIMBER_SPEED = 0;
}
