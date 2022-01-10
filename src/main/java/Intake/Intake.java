package Intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

    private final IntakeComponents components;

    public Intake(IntakeComponents components) {
        this.components = components;
    }
}
