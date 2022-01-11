package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class ShooterComponentsBase implements ShooterComponents{
    private WPI_TalonFX masterMotor;

    @Override
    public WPI_TalonFX getMasterMotor() {
        return masterMotor;
    }

}
