package frc.robot.climber;

import static frc.robot.climber.ClimberConstants.ClimberConstantsA.BACKWARD_CHANNEL;
import static frc.robot.climber.ClimberConstants.ClimberConstantsA.FORWARD_CHANNEL;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class ClimberComponentsBase implements ClimberComponents {

    private WPI_TalonFX masterMotor;
    private WPI_TalonFX slaveMotor;
    private DoubleSolenoid solenoid;

    public ClimberComponentsBase() {
        masterMotor = new WPI_TalonFX(0);
        masterMotor.configFactoryDefault();

        slaveMotor = new WPI_TalonFX(1);
        slaveMotor.configFactoryDefault();
        slaveMotor.follow(masterMotor);

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_CHANNEL, BACKWARD_CHANNEL);
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
    public DoubleSolenoid getSolenoid() {
        return solenoid;
    }

}
