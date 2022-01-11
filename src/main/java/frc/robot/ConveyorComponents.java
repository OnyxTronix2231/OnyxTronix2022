package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public interface ConveyorComponents {
        WPI_TalonFX getFirstMotor();
        WPI_TalonFX getSecondMotor();

    }
