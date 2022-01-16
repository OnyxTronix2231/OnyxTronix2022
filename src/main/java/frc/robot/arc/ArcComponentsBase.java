package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import pid.interfaces.MotionMagicController;
import sensors.Switch.TalonSrxForwardMicroswitch;
import sensors.Switch.TalonSrxReverseMicroswitch;
import sensors.counter.Counter;
import sensors.counter.CtreEncoder;

import static frc.robot.arc.ArcConstents.*;

public class ArcComponentsBase implements ArcComponents{

    private WPI_TalonSRX motor;
    private CtreEncoder encoder;
    private CtreMotionMagicController controller;
    private TalonSrxForwardMicroswitch forwardLimitSwitch;
    private TalonSrxReverseMicroswitch reverseLimitSwitch;

    public ArcComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();
        encoder = new CtreEncoder(motor);
        controller = new CtreMotionMagicController(motor, encoder,
                new PIDFTerms(KP, KI, KD, KF),
                MAX_ACCELERATION, CRUISE_VELOCITY, ACCELERATION_SMOOTHING);
        forwardLimitSwitch = new TalonSrxForwardMicroswitch(motor, LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyOpen);
        reverseLimitSwitch = new TalonSrxReverseMicroswitch(motor, LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyOpen);
    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }

    @Override
    public Counter getCounter() {
        return encoder;
    }

    @Override
    public MotionMagicController getController() {
        return controller;
    }

    @Override
    public TalonSrxReverseMicroswitch getReverseLimitSwitch() {
        return reverseLimitSwitch;
    }

    @Override
    public TalonSrxForwardMicroswitch getForwardLimitSwitch() {
        return forwardLimitSwitch;
    }
}
