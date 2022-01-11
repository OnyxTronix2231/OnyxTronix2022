package frc.robot.Intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import static frc.robot.Intake.IntakeConstant.*;

public class IntakeComponentsBase implements IntakeComponents{


    private WPI_TalonSRX motor;
    private DoubleSolenoid solenoid;


    public IntakeComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,SOLENOID_FORWARD_CHANNEL,SOLENOID_REVERSE_CHANNEL);
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
