package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.RGB.Color;
import frc.robot.RGB.commands.BlinkInfinity;
import frc.robot.RGB.commands.BlinkNumTimes;
import frc.robot.RGB.commands.ChangeIntake;
import frc.robot.RGB.commands.SetColor;
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
                new SequentialCommandGroup(new WaitUntilCommand(()-> loader.identifiedBall() || ballTrigger.isBallIdentified()), new SetColor(Color.Yellow)));
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        CommandScheduler.getInstance().schedule(new RGB_DefaultStaticColor());
    }
}
