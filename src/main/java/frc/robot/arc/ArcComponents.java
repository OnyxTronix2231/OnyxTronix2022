package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import pid.interfaces.MotionMagicController;
import sensors.Switch.TalonSrxForwardMicroswitch;
import sensors.Switch.TalonSrxReverseMicroswitch;
import sensors.counter.Counter;
import sensors.linearServo.LinearServo;

public interface ArcComponents {

    LinearServo getLinearServo();
}
