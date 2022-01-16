package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import pid.interfaces.PIDController;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

import static frc.robot.shooter.ShooterConstants.*;

public class ShooterComponentsBase implements ShooterComponents{

    private WPI_TalonFX masterMotor;
    private WPI_TalonFX slaveMotor;
    private CtreEncoder encoder;
    private CtrePIDController controller;

    public ShooterComponentsBase(){
        masterMotor = new WPI_TalonFX(MASTER_MOTOR_ID);
        masterMotor.configFactoryDefault();
        slaveMotor = new WPI_TalonFX(SLAVE_MOTOR_ID);
        slaveMotor.configFactoryDefault();
        slaveMotor.follow(masterMotor);
        encoder = new CtreEncoder(masterMotor);
        controller = new CtrePIDController(masterMotor, encoder,
                new PIDFTerms(PIDF_P,PIDF_I,PIDF_D,PIDF_F), PIDControlMode.Velocity);
        controller.setPIDFTerms(controller.getPIDFTerms());
    }

    @Override
    public WPI_TalonFX getMasterMotor() {
        return masterMotor;
    }

    @Override
    public IMotorController getSlaveMotor() {
        return slaveMotor;
    }

    @Override
    public Counter getCounter() {
        return encoder;
    }

    @Override
    public PIDController getController() {
        return controller;
    }
}
