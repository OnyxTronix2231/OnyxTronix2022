package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import pid.CtreMotionMagicController;
import sensors.Switch.TalonSrxReverseMicroswitch;
import sensors.counter.Counter;

public interface ArcComponents {

    WPI_TalonSRX getMotor();

    TalonSrxReverseMicroswitch getReverseMicroSwitch();

    Counter getCounter();

    CtreMotionMagicController getController();
}
