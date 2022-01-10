package Intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static Intake.IntakeConstant.*;

public class IntakeComponentsBase implements IntakeComponents{


    private WPI_TalonSRX motor;


    public IntakeComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();
    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }
}
