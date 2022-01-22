package frc.robot.intakeBack;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public interface IntakeBackComponents {

    WPI_TalonSRX getMotor();

    DoubleSolenoid getSolenoid();
}
