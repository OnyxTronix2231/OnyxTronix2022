package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import sensors.Switch.Microswitch;
import sensors.Switch.TalonSrxForwardMicroswitch;
import sensors.Switch.TalonSrxReverseMicroswitch;
import sensors.counter.TalonEncoder;

import static frc.robot.arc.ArcConstants.ComponentsConstants.*;


public class ArcComponentsBase implements ArcComponents {

    private final WPI_TalonSRX motor;
    private final TalonEncoder encoder;
    private final TalonSrxForwardMicroswitch forwardMicroswitch;
    private final TalonSrxReverseMicroswitch reverseMicroswitch;

    public ArcComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();

        encoder = new TalonEncoder(motor);

        forwardMicroswitch = new TalonSrxForwardMicroswitch(motor, LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyOpen);
        reverseMicroswitch = new TalonSrxReverseMicroswitch(motor, LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyOpen);
    }
    
    @Override
    public TalonSrxReverseMicroswitch getReverseMicroswitch(){
        return reverseMicroswitch;
    }
    @Override
    public TalonSrxForwardMicroswitch getForwardMicroswitch(){
        return forwardMicroswitch;
    }
    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }
}
