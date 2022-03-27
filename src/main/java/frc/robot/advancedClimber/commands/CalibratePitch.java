package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.advancedClimber.AdvancedClimber;

public class CalibratePitch extends InstantCommand {

    public CalibratePitch(AdvancedClimber advancedClimber) {
        super(() -> advancedClimber.calibratePitch());
    }
}
