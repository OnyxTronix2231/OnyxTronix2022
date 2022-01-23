package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import pid.CtreMotionMagicController;
import sensors.Switch.Microswitch;
import sensors.counter.Counter;

public interface ClimberComponents {

    CtreMotionMagicController getArmMotionMagicController();

    CtreMotionMagicController getRailMotionMagicController();

    Counter getArmCounter();

    Counter getRailCounter();

    WPI_TalonFX getRailMotor();

    WPI_TalonFX getArmMotor();

    DoubleSolenoid getSolenoid();

//    DigitalInput getOuterHallEffect();

    DigitalInput getInnerHallEffect();
}
