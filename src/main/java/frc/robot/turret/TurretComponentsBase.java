package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class TurretComponentsBase implements TurretComponents    {

    private WPI_TalonFX masterMotor;

    public TurretComponentsBase(){
        masterMotor = new WPI_TalonFX(0);
        masterMotor.configFactoryDefault();
    }

    public WPI_TalonFX getMasterMotor(){
        return masterMotor;
    }
}
