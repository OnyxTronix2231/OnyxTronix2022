package Intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class IntakeConstant {

   public static final DoubleSolenoid.Value SOLENOID_OPEN = DoubleSolenoid.Value.kForward;
   public static final DoubleSolenoid.Value SOLENOID_CLOSE = DoubleSolenoid.Value.kReverse;

   public static final int MOTOR_ID = 0;
   public static final int SOLENOID_FORWARD_CHANNEL = 0;
   public static final int SOLENOID_REVERSE_CHANNEL = 0;
}
