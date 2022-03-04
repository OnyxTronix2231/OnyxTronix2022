package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.commands.ShootByRPM;

public class ShootBall extends ParallelCommandGroup {

    public ShootBall(Loader loader, BallTrigger ballTrigger, Shooter shooter, Arc arc) {
        super(





                new ShootByRPM(shooter, () -> 4000), new MoveArcToAngle(arc, () -> 62),
                new WaitUntilCommand(() -> shooter.isOnTarget()).andThen(
                        new ParallelCommandGroup(
                                new MoveBallTriggerBySpeed(ballTrigger, () -> 0.6),
                                new MoveLoaderBySpeed(loader, () -> 0.8))));
    }
}
