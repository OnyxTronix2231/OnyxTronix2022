package frc.robot.RGB.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.RGB.Color;
import frc.robot.RGB.OnyxRGB;

public class SetColor extends InstantCommand {

    public SetColor(Color color) {
        super(() -> OnyxRGB.getInstance().setColor(color));
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Changed to color");
    }
}
