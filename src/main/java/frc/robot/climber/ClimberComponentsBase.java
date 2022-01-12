package frc.robot.climber;

import static frc.robot.climber.ClimberConstants.BACKWARD_CHANNEL;
import static frc.robot.climber.ClimberConstants.FORWARD_CHANNEL;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import sensors.Switch.Microswitch;

public class ClimberComponentsBase implements ClimberComponents {

    private WPI_TalonFX masterMotor;
    private WPI_TalonFX slaveMotor;
    private DoubleSolenoid solenoid;
    private Microswitch outerMicroSwitch;
    private Microswitch innerMicroSwitch;

    public ClimberComponentsBase() {
        masterMotor = new WPI_TalonFX(0);
        masterMotor.configFactoryDefault();

        slaveMotor = new WPI_TalonFX(1);
        slaveMotor.configFactoryDefault();
        slaveMotor.follow(masterMotor);

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_CHANNEL, BACKWARD_CHANNEL);

        outerMicroSwitch = new Microswitch(new DigitalInput(0));

        innerMicroSwitch = new Microswitch(new DigitalInput(1));
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

    @Override
    public Microswitch getOuterMicroSwitch() {
        return outerMicroSwitch;
    }

    @Override
    public Microswitch getInnerMicroSwitch() {
        return innerMicroSwitch;
    }

}
