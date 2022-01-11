package frc.robot.Intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public interface IntakeComponents {

    WPI_TalonSRX getMotor();
    DoubleSolenoid getSolenoid();
}
