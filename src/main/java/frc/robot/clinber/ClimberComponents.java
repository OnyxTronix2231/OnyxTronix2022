package frc.robot.clinber;

import com.ctre.phoenix.motorcontrol.IMotorController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public interface ClimberComponents {

    IMotorController motor();

    DoubleSolenoid solenoid();
}
