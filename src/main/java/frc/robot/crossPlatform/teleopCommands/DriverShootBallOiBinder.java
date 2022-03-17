package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;
import frc.robot.yawControl.YawControl;

import java.util.function.BooleanSupplier;

public class DriverShootBallOiBinder {

    public DriverShootBallOiBinder(Shooter shooter, Arc arc, BallTrigger ballTrigger, Loader loader,
                                   YawControl yawControl, BooleanSupplier conditionsSupplier,
                                   Trigger releaseBallsWhenReady, Trigger shootCloseToHighTarget, Trigger realiseBalls) {
        releaseBallsWhenReady.whileActiveContinuous(new WhenSubsystemsReadyReleaseBall(conditionsSupplier, loader, ballTrigger));

        shootCloseToHighTarget.whileActiveContinuous(new ShootBallCloseToHighTarget(shooter, arc, yawControl, loader,
                ballTrigger));

        realiseBalls.whenActive(new InstantCommand(() -> shooter.setRealeBallsButtonpress(true)));
        realiseBalls.whenInactive(new InstantCommand(() -> shooter.setRealeBallsButtonpress(false)));
    }
}
