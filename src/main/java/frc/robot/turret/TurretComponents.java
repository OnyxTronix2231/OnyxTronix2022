package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import sensors.counter.CtreCANCoder;
import sensors.counter.CtreEncoder;

public interface TurretComponents {

    WPI_TalonFX getMotor();

    CtreEncoder getEncoder();

    CtreMotionMagicController getController();
}
