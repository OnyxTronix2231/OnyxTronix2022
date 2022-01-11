package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import sensors.counter.CtreEncoder;

import java.beans.Encoder;

public interface TurretComponents {

    WPI_TalonFX getMotor();
    CtreEncoder getEncoder();
    CtreMotionMagicController getController();
}
