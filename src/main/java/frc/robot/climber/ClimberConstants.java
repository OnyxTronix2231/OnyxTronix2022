package frc.robot.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ClimberConstants {

   static final int SOLENOID_FORWARD_CHANNEL = 5; // TODO: CHECK AND FIX
   static final int SOLENOID_REVERSE_CHANNEL = 6; // TODO: CHECK AND FIX
   static final int LEFT_MOTOR_DEVICE_NUMBER = 13;
   static final int RIGHT_MOTOR_DEVICE_NUMBER = 14;
   static final DoubleSolenoid.Value SOLENOID_OPEN_VALUE = DoubleSolenoid.Value.kForward;
   static final DoubleSolenoid.Value SOLENOID_CLOSE_VALUE = DoubleSolenoid.Value.kReverse;
}
