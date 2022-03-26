package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.advancedClimber.commands.CalibratePitch;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenPiston;
import frc.robot.stabilizers.Stabilizer;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import frc.robot.turret.Turret;
import frc.robot.turret.commands.RotateToAngleRTR;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.CLIME_ARC_ANGLE;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.CLIME_TURRET_ANGLE;

public class GetReadyToClime extends ParallelCommandGroup {

    public GetReadyToClime(AdvancedClimber advancedClimber, Turret turret, Arc arc, Intake intakeForward) {
        super(  new CalibratePitch(advancedClimber),
                new RotateToAngleRTR(turret, () -> CLIME_TURRET_ANGLE),
                new MoveArcToAngle(arc, () -> CLIME_ARC_ANGLE),
                new MoveStabilizerBySpeed(advancedClimber, ()-> 0),
                new OpenPiston(intakeForward));
    }
}
