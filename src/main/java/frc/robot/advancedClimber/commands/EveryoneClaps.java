package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;
import frc.robot.vision.Vision;
import frc.robot.vision.commands.ChangeLimelightLedMode;
import vision.limelight.enums.LimelightLedMode;

public class EveryoneClaps extends SequentialCommandGroup {

    public EveryoneClaps() {
        super(new ChangeLimelightLedMode(LimelightLedMode.forceBlink));
    }
}
