package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.climber.Climber;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.drivetrain.DriveTrain;

import java.util.function.DoubleSupplier;

public class ClimbUntilRobotPitchAngle extends ParallelDeadlineGroup {

    public ClimbUntilRobotPitchAngle(AdvancedClimber advancedClimber, DoubleSupplier speedSupplier) {
        super(new WaitUntilRobotPitchAngle(advancedClimber), new ClimbBySpeed(advancedClimber, speedSupplier));
    }
}
