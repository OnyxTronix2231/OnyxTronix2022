package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import sensors.counter.TalonEncoder;

import static frc.robot.climber.ClimberConstants.*;


public class ClimberComponentsBase implements ClimberComponents {

    private final WPI_TalonFX leftMotor;
    private final WPI_TalonFX rightMotor;
    private final DoubleSolenoid leftDoubleSolenoid;
    private final DoubleSolenoid rightDoubleSolenoid;
    private final TalonEncoder leftEncoder;
    private final TalonEncoder rightEncoder;

    public ClimberComponentsBase() {
        leftMotor = new WPI_TalonFX(LEFT_MOTOR_DEVICE_NUMBER);
        leftMotor.configFactoryDefault();
        rightMotor = new WPI_TalonFX(RIGHT_MOTOR_DEVICE_NUMBER);
        rightMotor.configFactoryDefault();
        rightDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RIGHT_SOLENOID_FORWARD_CHANNEL
                , RIGHT_SOLENOID_REVERSE_CHANNEL);
        leftDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, LEFT_SOLENOID_FORWARD_CHANNEL
                , LEFT_SOLENOID_REVERSE_CHANNEL);
        leftEncoder = new TalonEncoder(leftMotor);
        rightEncoder = new TalonEncoder(rightMotor);
    }

    @Override
    public WPI_TalonFX getRightMotor() {
        return rightMotor;
    }

    @Override
    public WPI_TalonFX getLeftMotor() {
        return leftMotor;
    }

    @Override
    public DoubleSolenoid getLeftDoubleSolenoid() {
        return leftDoubleSolenoid;
    }

    @Override
    public DoubleSolenoid getRightDoubleSolenoid() {
        return rightDoubleSolenoid;
    }

    @Override
    public TalonEncoder getLeftEncoder() {
        return leftEncoder;
    }

    @Override
    public TalonEncoder getRightEncoder() {
        return rightEncoder;
    }
}
