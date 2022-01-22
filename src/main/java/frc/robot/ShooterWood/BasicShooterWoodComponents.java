package frc.robot.ShooterWood;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

import static frc.robot.ShooterWood.ShooterWoodConstants.*;

public class BasicShooterWoodComponents implements ShooterWoodComponents {

    private WPI_TalonSRX masterMotor;
    private WPI_VictorSPX slaveMotor;
    private CtreEncoder encoder;
    private CtrePIDController controller;
    private FlywheelSim flywheelSim;

    public BasicShooterWoodComponents() {
        masterMotor = new WPI_TalonSRX(7);
        masterMotor.configFactoryDefault();
        encoder = new CtreEncoder(masterMotor);
        slaveMotor = new WPI_VictorSPX(8);
        slaveMotor.follow(masterMotor);
        controller = new CtrePIDController(masterMotor, encoder,
                new PIDFTerms(PIDF_P,PIDF_I,PIDF_D,PIDF_F), PIDControlMode.Velocity);
        controller.setPIDFTerms(controller.getPIDFTerms());
    }

    @Override
    public WPI_TalonSRX getMasterMotor() {
        return masterMotor;
    }

    @Override
    public WPI_VictorSPX getSlaveMotor() {
        return slaveMotor;
    }

    @Override
    public Counter getCounter() {
        return encoder;
    }

    @Override
    public CtrePIDController getController() {
        return controller;
    }
}
