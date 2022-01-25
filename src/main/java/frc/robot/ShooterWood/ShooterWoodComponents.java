package frc.robot.ShooterWood;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import pid.CtrePIDController;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

public interface ShooterWoodComponents {

        WPI_TalonSRX getMasterMotor();

        WPI_VictorSPX getSlaveMotor();

        Counter getCounter();

        CtrePIDController getController();

}