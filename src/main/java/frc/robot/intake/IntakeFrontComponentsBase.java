package frc.robot.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import static frc.robot.intake.IntakeConstant.FrontComponentsConstants.*;

public class IntakeFrontComponentsBase implements IntakeComponents {
    private final WPI_TalonFX motor;
    private final DoubleSolenoid solenoid;

    public IntakeFrontComponentsBase() {
        motor = new WPI_TalonFX(FRONT_MOTOR_ID);
        motor.configFactoryDefault();
        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FRONT_SOLENOID_FORWARD_CHANNEL,
                FRONT_SOLENOID_REVERSE_CHANNEL);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public DoubleSolenoid getSolenoid() {
        return solenoid;
    }
}
