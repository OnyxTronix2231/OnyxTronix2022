package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import java.beans.Encoder;

public interface TurretComponents {

    WPI_TalonFX getMotor();
    Encoder getEncoder();
}
