package frc.robot.arc;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import sensors.counter.TalonEncoder;

import static frc.robot.arc.ArcConstants.ComponentsConstants.*;


public class ArcComponentsBase implements ArcComponents {

    private final WPI_TalonSRX motor;
    private final TalonEncoder encoder;

    public ArcComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();

        encoder = new TalonEncoder(motor);
    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }
}
