package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import sensors.Switch.TalonSrxForwardMicroswitch;
import sensors.Switch.TalonSrxReverseMicroswitch;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.TalonEncoder;

import static frc.robot.arc.ArcConstants.ComponentsConstants.*;
import static frc.robot.arc.ArcConstants.*;


public class ArcComponentsBase implements ArcComponents {

    private final WPI_TalonSRX motor;
    private final TalonEncoder encoder;
    private final TalonSrxReverseMicroswitch reverseMicroswitch;
    private final CtrePIDController controller;

    public ArcComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();

        encoder = new TalonEncoder(motor);

        controller = new CtrePIDController(motor, encoder, new PIDFTerms(KP, KI, KD, KF), PIDControlMode.Position);

        reverseMicroswitch = new TalonSrxReverseMicroswitch(motor, LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyOpen);
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
    public CtrePIDController getController() {
        return controller;
    }
}

