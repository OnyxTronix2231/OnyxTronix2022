package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public interface IntakeComponents {

    WPI_TalonFX getMotor();

    DoubleSolenoid getSolenoid();
}
