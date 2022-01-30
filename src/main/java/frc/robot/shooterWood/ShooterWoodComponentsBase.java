package frc.robot.shooterWood;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

import static frc.robot.shooterWood.ShooterWoodConstants.*;

public class ShooterWoodComponentsBase implements ShooterWoodComponents {

    private WPI_TalonSRX masterMotor;
    private WPI_VictorSPX slaveMotor;
    private CtreEncoder encoder;
    private CtrePIDController controller;

    public ShooterWoodComponentsBase() {
        masterMotor = new WPI_TalonSRX(7);
        masterMotor.configFactoryDefault();
        encoder = new CtreEncoder(masterMotor);
        slaveMotor = new WPI_VictorSPX(8);
        slaveMotor.follow(masterMotor);
        slaveMotor.setInverted(true);
        controller = new CtrePIDController(masterMotor, encoder,
                new PIDFTerms(PIDF_P , PIDF_I , PIDF_D , PIDF_F) , PIDControlMode.Velocity);
        controller.setPIDFTerms(controller.getPIDFTerms());
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
    public CtrePIDController getController() {
        return controller;
    }
}
