package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import static frc.robot.intake.IntakeConstant.*;

public class IntakeBackComponentsBase implements IntakeComponents {
    private final WPI_TalonSRX motor;
    private final DoubleSolenoid solenoid;

    public IntakeBackComponentsBase() {
        motor = new WPI_TalonSRX(BACK_MOTOR_ID);
        motor.configFactoryDefault();
        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, BACK_SOLENOID_FORWARD_CHANNEL,
                BACK_SOLENOID_REVERSE_CHANNEL);
    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }

    @Override
    public DoubleSolenoid getSolenoid() {
        return solenoid;
    }

}
