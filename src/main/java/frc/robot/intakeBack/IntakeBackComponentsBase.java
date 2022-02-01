package frc.robot.intakeBack;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.intakeForward.IntakeComponents;

import static frc.robot.intakeBack.IntakeBackConstant.*;

public class IntakeBackComponentsBase implements IntakeComponents {
    private final WPI_TalonSRX motor;
    private final DoubleSolenoid solenoid;

    public IntakeBackComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, SOLENOID_FORWARD_CHANNEL, SOLENOID_REVERSE_CHANNEL);
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
