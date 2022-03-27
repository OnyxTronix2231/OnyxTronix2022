package frc.robot.RGB.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RGB.Color;
import frc.robot.RGB.OnyxRGB;

public class TurnOff extends InstantCommand {

    public TurnOff() {
        super(() -> OnyxRGB.getInstance().turnOff());
    }
}
