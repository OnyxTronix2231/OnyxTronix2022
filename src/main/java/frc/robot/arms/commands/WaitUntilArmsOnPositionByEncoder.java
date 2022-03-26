package frc.robot.arms.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arms.Arms;
import frc.robot.stabilizers.Stabilizer;

import java.util.function.IntSupplier;

    public class WaitUntilArmsOnPositionByEncoder extends CommandBase {

        private final Arms arms;
        private int positionSupplier;

        public WaitUntilArmsOnPositionByEncoder(Arms arms, IntSupplier positionInEncoderUnitsSupplier) {
            this.arms = arms;
            this.positionSupplier = positionInEncoderUnitsSupplier.getAsInt();
        }

        @Override
        public void initialize() {
            positionSupplier += (int)(arms.getEncoderUnits());
        }

        @Override
        public boolean isFinished() {
            return arms.isEncoderOnTarget(positionSupplier);
        }
    }
