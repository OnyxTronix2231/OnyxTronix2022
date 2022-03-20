package frc.robot.stabilizers;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import sensors.counter.TalonEncoder;

public interface StabilizerComponents {

    WPI_TalonFX getMotor();

    TalonEncoder getEncoder();
}
