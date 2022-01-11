package frc.robot.turret;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.turret.TurretConstants.*;

public class TurretComponentsBase implements TurretComponents    {

    private WPI_TalonFX masterMotor;

    public TurretComponentsBase(){
        masterMotor = new WPI_TalonFX(TURRET_MOTOR_PORT);
        masterMotor.configFactoryDefault();
    }

    public WPI_TalonFX getMotor(){
        return masterMotor;
    }
}
