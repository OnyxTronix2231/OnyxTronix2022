package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import sensors.Switch.TalonSrxForwardMicroswitch;
import sensors.Switch.TalonSrxReverseMicroswitch;
import pid.interfaces.PIDController;
import sensors.counter.Counter;

public interface ArcComponents {

    WPI_TalonSRX getMotor();

    TalonSrxReverseMicroswitch getReverseMicroSwitch();

    TalonSrxForwardMicroswitch getForwardMicroSwitch();

    Counter getCounter();

    PIDController getController();
}
