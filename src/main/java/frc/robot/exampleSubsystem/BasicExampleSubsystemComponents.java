package frc.robot.exampleSubsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.exampleSubsystem.ExampleSubsystemConstants.ExampleSubsystemConstantsA.EXAMPLE_MOTOR_ID;

public class BasicExampleSubsystemComponents implements ExampleSubsystemComponents {

    private final WPI_TalonSRX exampleMotor;

    public BasicExampleSubsystemComponents() {
        exampleMotor = new WPI_TalonSRX(EXAMPLE_MOTOR_ID);
        exampleMotor.configFactoryDefault();
        exampleMotor.configAllSettings(getConfiguration());
    }

    public TalonSRXConfiguration getConfiguration() {
        final TalonSRXConfiguration config = new TalonSRXConfiguration();
        return config;
    }

    @Override
    public WPI_TalonSRX getExampleMotor() {
        return exampleMotor;
    }
}
