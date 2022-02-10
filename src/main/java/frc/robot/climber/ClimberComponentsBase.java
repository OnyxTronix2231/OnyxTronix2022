package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;
import sensors.counter.TalonEncoder;

import static frc.robot.climber.ClimberConstants.*;

public class ClimberComponentsBase implements ClimberComponents {

    private WPI_TalonFX railMotorMaster;
    private WPI_TalonFX railMotorSlave;
    private WPI_TalonFX armMotorRight;
    private WPI_TalonFX armMotorLeft;
//  private DigitalInput outerHallEffect;
    private DigitalInput innerHallEffect;
    private CtreMotionMagicController rightArmMotionMagicController;
    private CtreMotionMagicController leftArmMotionMagicController;
    private CtreMotionMagicController railMotionMagicController;
    private CtreEncoder leftArmEncoder;
    private CtreEncoder rightArmEncoder;
    private CtreEncoder railEncoder;

    public ClimberComponentsBase() {
        railMotorMaster = new WPI_TalonFX(RAIL_MASTER_MOTOR_ID);
        railMotorMaster.configFactoryDefault();

        railMotorSlave = new WPI_TalonFX(RAIL_SLAVE_MOTOR_ID);
        railMotorSlave.configFactoryDefault();
        railMotorSlave.setInverted(true);
        railMotorSlave.follow(railMotorMaster);

        armMotorRight  = new WPI_TalonFX(ARM_RIGHT_MOTOR_ID);
        armMotorRight.configFactoryDefault();

        armMotorLeft = new WPI_TalonFX(ARM_LEFT_MOTOR_ID);
        armMotorLeft.configFactoryDefault();

        //outerHallEffect = new DigitalInput(0);
        innerHallEffect = new DigitalInput(INNER_HALL_EFFECT_CHANNEL);
        rightArmEncoder = new TalonEncoder(armMotorRight);
        leftArmEncoder = new TalonEncoder(armMotorLeft);
        railEncoder = new TalonEncoder(railMotorMaster);

        leftArmMotionMagicController = new CtreMotionMagicController(armMotorLeft, leftArmEncoder, new PIDFTerms(ARM_RIGHT_kP, ARM_RIGHT_kI, ARM_RIGHT_kD, ARM_RIGHT_kF), ARM_ACCELERATION,
                ARM_CRUISE_VELOCITY, ARM_ACCELERATION_SMOOTHING);
        rightArmMotionMagicController = new CtreMotionMagicController(armMotorRight, rightArmEncoder, new PIDFTerms(ARM_LEFT_KP, ARM_LEFT_KI, ARM_LEFT_KD, ARM_LEFT_KF), ARM_ACCELERATION,
                ARM_CRUISE_VELOCITY, ARM_ACCELERATION_SMOOTHING);
        railMotionMagicController = new CtreMotionMagicController(railMotorMaster, railEncoder, new PIDFTerms(RAIL_kP, RAIL_kI, RAIL_kD, RAIL_kF), RAIL_ACCELERATION,
                RAIL_CRUISE_VELOCITY, RAIL_ACCELERATION_SMOOTHING);
    }

    @Override
    public CtreMotionMagicController getArmRightMotionMagicController() {
        return rightArmMotionMagicController;
    }

    @Override
    public CtreMotionMagicController getArmLeftMotionMagicController() {
        return leftArmMotionMagicController;
    }

    @Override
    public CtreMotionMagicController getRailMotionMagicController() {
        return railMotionMagicController;
    }

    @Override
    public Counter getArmCounterRight() {
        return rightArmEncoder;
    }

    @Override
    public Counter getArmCounterLeft() {
        return leftArmEncoder;
    }

    @Override
    public Counter getRailCounter() {
        return railEncoder;
    }

    @Override
    public WPI_TalonFX getRailMotor() {
        return railMotorMaster;
    }

    @Override
    public WPI_TalonFX getArmMotorLeft() {
        return armMotorLeft;
    }

    @Override
    public WPI_TalonFX getArmMotorRight() {
        return armMotorRight;
    }

//    @Override
//    public DigitalInput getOuterHallEffect() {
//        return outerHallEffect;
//    }

    @Override
    public DigitalInput getInnerHallEffect() {
        return innerHallEffect;
    }
}
