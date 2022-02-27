package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import sensors.Switch.TalonSrxForwardMicroswitch;
import sensors.Switch.TalonSrxReverseMicroswitch;

public interface ArcComponents {

    WPI_TalonSRX getMotor();
    TalonSrxForwardMicroswitch getForwardMicroSwitch();
    TalonSrxReverseMicroswitch getReverseMicroSwitch();
}
