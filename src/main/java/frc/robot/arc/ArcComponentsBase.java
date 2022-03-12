package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.StatusFrameConfig;
import pid.CtreMotionMagicController;
import pid.PIDFTerms;
import sensors.Switch.TalonSrxReverseMicroswitch;
import sensors.counter.Counter;
import sensors.counter.TalonEncoder;

import static frc.robot.arc.ArcConstants.*;
import static frc.robot.arc.ArcConstants.ComponentsConstants.MOTOR_ID;

public class ArcComponentsBase implements ArcComponents {

    private final WPI_TalonSRX motor;
    private final TalonEncoder encoder;
    private final TalonSrxReverseMicroswitch reverseMicroswitch;
    private final CtreMotionMagicController controller;

    public ArcComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();
        motor.setInverted(true);
        motor.config_IntegralZone(0, INTEGRAL_ZONE);

        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        encoder = new TalonEncoder(motor);

        new StatusFrameConfig(motor).disablePID1();

        controller = new CtreMotionMagicController(motor, encoder, new PIDFTerms(KP, KI, KD, KF),
                MAX_ACC, CRUISE_VELOCITY, ACC_SMOOTHING);

        reverseMicroswitch = new TalonSrxReverseMicroswitch(motor, LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyClosed);
    }

    @Override
    public TalonSrxReverseMicroswitch getReverseMicroSwitch() {
        return reverseMicroswitch;
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
    public CtreMotionMagicController getController() {
        return controller;
    }
}

