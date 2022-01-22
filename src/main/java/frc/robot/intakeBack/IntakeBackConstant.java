package frc.robot.intakeBack;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeBackConstant {

   public static final DoubleSolenoid.Value SOLENOID_OPEN = DoubleSolenoid.Value.kForward;
   public static final DoubleSolenoid.Value SOLENOID_CLOSE = DoubleSolenoid.Value.kReverse;

   public static final int MOTOR_ID = 9;
   public static final int SOLENOID_FORWARD_CHANNEL = 1;
   public static final int SOLENOID_REVERSE_CHANNEL = 2;
}
