package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import static frc.robot.climber.ClimberConstants.*;


public class ClimberComponentsBase {

    private final WPI_TalonFX leftMotor;
    private final WPI_TalonFX rightMotor;
    private final DoubleSolenoid doubleSolenoid;

    public ClimberComponentsBase() {
        leftMotor = new WPI_TalonFX(LEFT_MOTOR_DEVICE_NUMBER);
        leftMotor.configFactoryDefault();
        rightMotor = new WPI_TalonFX(RIGHT_MOTOR_DEVICE_NUMBER);
        rightMotor.configFactoryDefault();
        doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, SOLENOID_FORWARD_CHANNEL
                , SOLENOID_REVERSE_CHANNEL);



    }
}
