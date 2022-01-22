package frc.robot.intakeForward;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public interface IntakeForwardComponents {

    WPI_TalonSRX getMotor();

    DoubleSolenoid getSolenoid();
}
