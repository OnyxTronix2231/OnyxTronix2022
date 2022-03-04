package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenAndIntake;

import java.util.function.DoubleSupplier;

public class IntakeAndLoadBalls extends ParallelCommandGroup {

    public IntakeAndLoadBalls(Intake intake, BallTrigger ballTrigger, Loader loader,
                              DoubleSupplier loaderSpeedSupplier, DoubleSupplier ballTriggerSpeedSupplier,
                              DoubleSupplier intakeSpeedSupplier) {
        super(new LoadBalls(loader, ballTrigger, loaderSpeedSupplier,
                        ballTriggerSpeedSupplier),
                new OpenAndIntake(intake, intakeSpeedSupplier));
    }
}
