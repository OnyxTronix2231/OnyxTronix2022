package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import sensors.Switch.Microswitch;

public interface ClimberComponents {

    WPI_TalonFX getMasterMotor();

    IMotorController getSlaveMotor();

    DoubleSolenoid getSolenoid();

    Microswitch getOuterMicroSwitch();

    Microswitch getInnerMicroSwitch();
}
