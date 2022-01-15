package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.Switch.Microswitch;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberComponentsBase implements ClimberComponents {

    private WPI_TalonFX railMotor;
    private WPI_TalonFX armMotor;
    private DoubleSolenoid solenoid;
    private Microswitch outerMicroSwitch;
    private Microswitch innerMicroSwitch;
    private CtreMotionMagicController motionMagicController;
    private CtreEncoder encoder;

    public ClimberComponentsBase() {
        railMotor = new WPI_TalonFX(0);
        railMotor.configFactoryDefault();

        armMotor = new WPI_TalonFX(1);
        armMotor.configFactoryDefault();

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_CHANNEL, BACKWARD_CHANNEL);

        outerMicroSwitch = new Microswitch(new DigitalInput(0));

        innerMicroSwitch = new Microswitch(new DigitalInput(1));

        encoder = new CtreEncoder(armMotor);

        motionMagicController = new CtreMotionMagicController(armMotor, encoder, new PIDFTerms(kP,kI,kD,kF),ACCELERATION,
                CRUISE_VELOCITY, ACCELERATION_SMOOTHING);

    }

    @Override
    public CtreMotionMagicController getMotionMagicController() {
        return motionMagicController;
    }

    @Override
    public Counter getCounter() {
        return encoder;
    }

    @Override
    public WPI_TalonFX getRailMotor() {
        return railMotor;
    }

    @Override
    public WPI_TalonFX getArmMotor() {
        return armMotor;
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
