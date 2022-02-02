package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import pid.interfaces.PIDController;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

import static frc.robot.shooter.ShooterConstants.*;

public class ShooterComponentsBase implements ShooterComponents{

    private final WPI_TalonFX masterMotor;
    private final WPI_TalonFX slaveMotor;
    private final CtreEncoder encoder;
    private final CtrePIDController controller;

    public ShooterComponentsBase() {
        masterMotor = new WPI_TalonFX(MASTER_MOTOR_ID);
        masterMotor.configFactoryDefault();
        
        slaveMotor = new WPI_TalonFX(SLAVE_MOTOR_ID);
        slaveMotor.configFactoryDefault();
        slaveMotor.follow(masterMotor);

        encoder = new CtreEncoder(masterMotor);

        controller = new CtrePIDController(masterMotor, encoder,
                new PIDFTerms(KP, KI, KD, KF), PIDControlMode.Velocity);
        controller.setPIDFTerms(controller.getPIDFTerms());
    }

    @Override
    public WPI_TalonFX getMasterMotor() {
        return masterMotor;
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
