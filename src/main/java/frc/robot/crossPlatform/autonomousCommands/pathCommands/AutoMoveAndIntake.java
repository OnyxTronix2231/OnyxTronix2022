package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.IntakeAndLoadBalls;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.Path;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.intake.Intake;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.*;

public class AutoMoveAndIntake extends ParallelDeadlineGroup {

    public AutoMoveAndIntake(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                             BallTrigger ballTrigger, Path path) {
        super(new MoveByPath(driveTrain, path).andThen(new WaitCommand(1))
                ,
                new IntakeAndLoadBalls(path.isReversed() ? backIntake : frontIntake,
                        ballTrigger, loader, () -> LOADER_SPEED_SUPPLIER, () -> BALL_TRIGGER_SPEED_SUPPLIER,
                        () -> INTAKE_SPEED_SUPPLIER)
        );
    }
}
