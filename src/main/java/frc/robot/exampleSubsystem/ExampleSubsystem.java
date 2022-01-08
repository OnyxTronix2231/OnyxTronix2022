package frc.robot.exampleSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

    private final ExampleSubsystemComponents components;

    public ExampleSubsystem(final ExampleSubsystemComponents components) {
        this.components = components;
    }

    public void setMotor(double speed) {
        components.getExampleMotor().set(ControlMode.PercentOutput, speed);
    }

    public void stop() {
        setMotor(0);
    }
}
