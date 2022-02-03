package frc.robot.climber;

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
    private WPI_TalonFX armMotorRightMaster;
    private WPI_TalonFX armMotorLeftMaster;
    private WPI_TalonFX armMotorRightSlave;
    private WPI_TalonFX armMotorLeftSlave;
    private Microswitch outerMicroSwitch;
    private Microswitch innerMicroSwitch;
    private CtreMotionMagicController armLeftMotionMagicController;
    private CtreMotionMagicController armRightMotionMagicController;
    private CtreMotionMagicController railMotionMagicController;
    private CtreEncoder armEncoder;
    private CtreEncoder railEncoder;

    public ClimberComponentsBase() {
        railMotor = new WPI_TalonFX(0);
        railMotor.configFactoryDefault();

        armMotorRightMaster  = new WPI_TalonFX(1);
        armMotorRightMaster.configFactoryDefault();

        armMotorLeftMaster  = new WPI_TalonFX(2);
        armMotorLeftMaster.configFactoryDefault();

        armMotorRightSlave = new WPI_TalonFX(3);
        armMotorRightSlave.configFactoryDefault();

        armMotorLeftSlave = new WPI_TalonFX(4);
        armMotorLeftSlave.configFactoryDefault();

        armMotorRightSlave.follow(armMotorRightMaster);
        armMotorLeftSlave.follow(armMotorLeftMaster);
        //solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_CHANNEL, BACKWARD_CHANNEL);

        outerMicroSwitch = new Microswitch(new DigitalInput(0));

        innerMicroSwitch = new Microswitch(new DigitalInput(3));

        armEncoder = new CtreEncoder(armMotorRightMaster);

        railEncoder = new CtreEncoder(railMotor);

        armLeftMotionMagicController = new CtreMotionMagicController(armMotorLeftMaster, armEncoder, new PIDFTerms(ARM_kP, ARM_kI, ARM_kD, ARM_kF), ARM_ACCELERATION,
                ARM_CRUISE_VELOCITY, ARM_ACCELERATION_SMOOTHING);
        armRightMotionMagicController = new CtreMotionMagicController(armMotorRightMaster, armEncoder, new PIDFTerms(ARM_kP, ARM_kI, ARM_kD, ARM_kF), ARM_ACCELERATION,
                ARM_CRUISE_VELOCITY, ARM_ACCELERATION_SMOOTHING);
        railMotionMagicController = new CtreMotionMagicController(railMotor, railEncoder, new PIDFTerms(RAIL_kP, RAIL_kI, RAIL_kD, RAIL_kF), RAIL_ACCELERATION,
                RAIL_CRUISE_VELOCITY, RAIL_ACCELERATION_SMOOTHING);
    }

    @Override
    public CtreMotionMagicController getArmRightMotionMagicController() {
        return armRightMotionMagicController;
    }
    @Override
    public CtreMotionMagicController getArmLeftMotionMagicController() {
        return armLeftMotionMagicController;
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
    public WPI_TalonFX getArmMotorLeft() {
        return armMotorLeftMaster;
    }
    @Override
    public WPI_TalonFX getArmMotorRight() {
        return armMotorRightMaster;
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
