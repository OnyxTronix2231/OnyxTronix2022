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
import sensors.linearServo.LinearServo;

import static frc.robot.arc.ArcConstents.*;

public class ArcComponentsBase implements ArcComponents {

    private LinearServo linearServo;

    public ArcComponentsBase() {
        linearServo = new LinearServo(ARCH_CHANNEL, ARCH_MAX_LENGTH, ARC_MAX_SPEED);
    }

    @Override
    public LinearServo getLinearServo() {
        return linearServo;
    }




}
