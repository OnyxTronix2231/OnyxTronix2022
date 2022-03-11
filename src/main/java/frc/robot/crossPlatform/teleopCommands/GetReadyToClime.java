package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenPiston;
import frc.robot.turret.Turret;
import frc.robot.turret.commands.RotateToAngleRTR;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.CLIME_ARC_ANGLE;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.CLIME_TURRET_ANGLE;

public class GetReadyToClime extends ParallelCommandGroup {

    public GetReadyToClime(Turret turret, Arc arc, Intake intakeForward) {
        super(new RotateToAngleRTR(turret, () -> CLIME_TURRET_ANGLE),
                new MoveArcToAngle(arc, () -> CLIME_ARC_ANGLE),
                new OpenPiston(intakeForward));
    }
}