package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import pid.CtreMotionMagicController;
import sensors.counter.Counter;

public interface ClimberComponents {

    CtreMotionMagicController getArmLeftMotionMagicController();

    CtreMotionMagicController getArmRightMotionMagicController();

    CtreMotionMagicController getRailMotionMagicController();

    Counter getArmCounterRight();

    Counter getArmCounterLeft();

    Counter getRailCounter();

    WPI_TalonFX getRailMotor();

    WPI_TalonFX getArmMotorRight();

    WPI_TalonFX getArmMotorLeft();

//    DigitalInput getOuterHallEffect();

    DigitalInput getInnerHallEffect();
}
