package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import java.util.Arrays;
import java.util.function.BooleanSupplier;

public class WaitUntilReadyToShoot extends WaitUntilCommand {

    public WaitUntilReadyToShoot(BooleanSupplier... condition) {

        super(() -> Arrays.stream(condition).allMatch(BooleanSupplier::getAsBoolean));
    }
}
