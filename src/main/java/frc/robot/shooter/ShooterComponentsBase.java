package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import pid.interfaces.PIDController;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

import static frc.robot.shooter.ShooterConstants.*;

public class ShooterComponentsBase implements ShooterComponents{

    private WPI_TalonSRX masterMotor;
    private WPI_TalonSRX slaveMotor;
    private CtreEncoder encoder;
    private EncoderSim simEncoder;
    private CtrePIDController controller;
    private FlywheelSim flywheelSim;

    public ShooterComponentsBase() {
        masterMotor = new WPI_TalonSRX(MASTER_MOTOR_ID);
        masterMotor.configFactoryDefault();

        slaveMotor = new WPI_TalonSRX(SLAVE_MOTOR_ID);
        slaveMotor.configFactoryDefault();
        slaveMotor.follow(masterMotor);

        encoder = new CtreEncoder(masterMotor);

        controller = new CtrePIDController(masterMotor, encoder,
                new PIDFTerms(KP, KI, KD, KF), PIDControlMode.Velocity);
        controller.setPIDFTerms(controller.getPIDFTerms());

        flywheelSim = new FlywheelSim(DCMotor.getFalcon500(2), 1, 0.01 );
    }

    @Override
    public WPI_TalonSRX getMasterMotor() {
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
