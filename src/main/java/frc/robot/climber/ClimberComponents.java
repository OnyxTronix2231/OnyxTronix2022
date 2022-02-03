package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import pid.CtreMotionMagicController;
import sensors.Switch.Microswitch;
import sensors.counter.Counter;

public interface ClimberComponents {

    CtreMotionMagicController getArmLeftMotionMagicController();
    CtreMotionMagicController getArmRightMotionMagicController();

    CtreMotionMagicController getRailMotionMagicController();

    Counter getArmCounter();

    Counter getRailCounter();

    WPI_TalonFX getRailMotor();

    WPI_TalonFX getArmMotorRight();

    WPI_TalonFX getArmMotorLeft();


//    DigitalInput getOuterHallEffect();

    DigitalInput getInnerHallEffect();
}
