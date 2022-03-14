package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.providers.IsLoadBallButtonPress;
import frc.robot.shooter.Shooter;
import frc.robot.yawControl.YawControl;

import java.util.function.DoubleSupplier;

public class DeputeGetReadyToShootOiBinder {

    public DeputeGetReadyToShootOiBinder(Shooter shooter, Arc arc, YawControl yawControl,
                                         DoubleSupplier distanceSupplier, DoubleSupplier angleSupplier, Trigger getReady) {
        getReady.whileActiveOnce(new GetReadyToShoot(shooter, arc, yawControl, distanceSupplier, angleSupplier)
                .alongWith(new InstantCommand(()-> IsLoadBallButtonPress.setPress(true))));
        getReady.whenInactive(new InstantCommand(()-> IsLoadBallButtonPress.setPress(false)));
    }
}
