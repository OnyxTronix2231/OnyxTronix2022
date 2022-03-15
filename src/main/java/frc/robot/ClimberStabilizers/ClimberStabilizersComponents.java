package frc.robot.ClimberStabilizers;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.counter.TalonEncoder;

public interface ClimberStabilizersComponents {

    WPI_TalonFX getMotor();

    TalonEncoder getEncoder();
}
