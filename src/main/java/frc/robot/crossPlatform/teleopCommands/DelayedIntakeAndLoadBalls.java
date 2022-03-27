package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.RGB.logicCommands.RGB_ActiveIntake;
import frc.robot.RGB.logicCommands.RGB_DefaultStaticColor;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenAndIntakeWithDelay;

import java.util.function.DoubleSupplier;

public class DelayedIntakeAndLoadBalls extends ParallelCommandGroup {

    public DelayedIntakeAndLoadBalls(Intake intake, BallTrigger ballTrigger, Loader loader,
                              DoubleSupplier loaderSpeedSupplier, DoubleSupplier ballTriggerSpeedSupplier,
                              DoubleSupplier intakeSpeedSupplier) {
        super(new LoadBalls(loader, ballTrigger, loaderSpeedSupplier),
                new OpenAndIntakeWithDelay(intake, intakeSpeedSupplier),
                new RGB_ActiveIntake());
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        CommandScheduler.getInstance().schedule(new RGB_DefaultStaticColor());
    }
}
