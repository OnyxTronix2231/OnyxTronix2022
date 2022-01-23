package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberComponentsBase implements ClimberComponents {

    private WPI_TalonFX railMotor;
    private WPI_TalonFX armMotor;
    private DoubleSolenoid solenoid;
    private DigitalInput outerHallEffect;
    private DigitalInput innerHallEffect;
    private CtreMotionMagicController armMotionMagicController;
    private CtreMotionMagicController railMotionMagicController;
    private CtreEncoder armEncoder;
    private CtreEncoder railEncoder;

    public ClimberComponentsBase() {
        railMotor = new WPI_TalonFX(0);
        railMotor.configFactoryDefault();

        armMotor = new WPI_TalonFX(1);
        armMotor.configFactoryDefault();

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_CHANNEL, BACKWARD_CHANNEL);

        outerHallEffect = new DigitalInput(0);

        innerHallEffect = new DigitalInput(1);

        armEncoder = new CtreEncoder(armMotor);

        railEncoder = new CtreEncoder(railMotor);

        armMotionMagicController = new CtreMotionMagicController(armMotor, armEncoder, new PIDFTerms(ARM_kP, ARM_kI, ARM_kD, ARM_kF), ARM_ACCELERATION,
                ARM_CRUISE_VELOCITY, ARM_ACCELERATION_SMOOTHING);
        railMotionMagicController = new CtreMotionMagicController(railMotor, railEncoder, new PIDFTerms(RAIL_kP, RAIL_kI, RAIL_kD, RAIL_kF), RAIL_ACCELERATION,
                RAIL_CRUISE_VELOCITY, RAIL_ACCELERATION_SMOOTHING);
    }

    @Override
    public CtreMotionMagicController getArmMotionMagicController() {
        return armMotionMagicController;
    }

    @Override
    public CtreMotionMagicController getRailMotionMagicController() {
        return railMotionMagicController;
    }

    @Override
    public Counter getArmCounter() {
        return armEncoder;
    }

    @Override
    public Counter getRailCounter() {
        return railEncoder;
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
    public DigitalInput getOuterHallEffect() {
        return outerHallEffect;
    }

    @Override
    public DigitalInput getInnerHallEffect() {
        return innerHallEffect;
    }
}
