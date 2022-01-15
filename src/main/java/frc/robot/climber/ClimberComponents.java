package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import sensors.Switch.Microswitch;
import sensors.counter.Counter;

public interface ClimberComponents {

    CtreMotionMagicController getMotionMagicController();

    Counter getCounter();

    WPI_TalonFX getRailMotor();

    WPI_TalonFX getArmMotor();

    DoubleSolenoid getSolenoid();

    Microswitch getOuterMicroSwitch();

    Microswitch getInnerMicroSwitch();
}
