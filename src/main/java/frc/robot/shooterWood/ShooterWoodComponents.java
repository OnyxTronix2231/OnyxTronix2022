package frc.robot.shooterWood;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import pid.CtrePIDController;
import sensors.counter.Counter;

public interface ShooterWoodComponents {

        WPI_TalonSRX getMasterMotor();

        WPI_VictorSPX getSlaveMotor();

        Counter getCounter();

        CtrePIDController getController();
}
