package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import sensors.counter.CtreCANCoder;

public interface TurretComponents {

    WPI_TalonFX getMotor();

    CtreCANCoder getEncoder();

    CtreMotionMagicController getController();
}
