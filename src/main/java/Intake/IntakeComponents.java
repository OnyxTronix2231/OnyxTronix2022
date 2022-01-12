package Intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public interface IntakeComponents {

    WPI_TalonSRX getMotor();

    DoubleSolenoid getSolenoid();
}
