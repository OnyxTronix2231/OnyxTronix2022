package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.DelayedIntakeAndLoadBalls;
import frc.robot.crossPlatform.teleopCommands.IntakeAndLoadBalls;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.Path;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.intake.Intake;

public class AutoMoveAndIntake extends ParallelDeadlineGroup {
    static final double LOADER_SPEED_SUPPLIER = 0.5;
    static final double BALL_TRIGGER_SPEED_SUPPLIER = 0.5;
    static final double INTAKE_SPEED_SUPPLIER = 0.5;

    public AutoMoveAndIntake(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                             BallTrigger ballTrigger, Path path) {
        super(
                new MoveByPath(driveTrain, path).andThen(new WaitCommand(0.6)),

                new ConditionalCommand(new DelayedIntakeAndLoadBalls(backIntake, ballTrigger, loader, ()-> LOADER_SPEED_SUPPLIER,
                ()-> BALL_TRIGGER_SPEED_SUPPLIER, ()-> INTAKE_SPEED_SUPPLIER), new IntakeAndLoadBalls(frontIntake, ballTrigger, loader, ()-> LOADER_SPEED_SUPPLIER,
                ()-> BALL_TRIGGER_SPEED_SUPPLIER, ()-> INTAKE_SPEED_SUPPLIER), path::isReversed)
        );
    }
}
