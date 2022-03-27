package frc.robot.providers;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ReleaseArmsButtonClicked extends InstantCommand {

    public ReleaseArmsButtonClicked(ButtonProvider buttonProvider) {
        super(() -> buttonProvider.setClickedRelease(true));
    }
}
