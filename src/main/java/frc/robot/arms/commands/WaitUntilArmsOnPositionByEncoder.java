package frc.robot.arms.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;

import java.util.function.IntSupplier;

    public class WaitUntilArmsOnPositionByEncoder extends CommandBase {

        private final Arms arms;
        private final IntSupplier positionSupplier;
        private int currentPosition;
        private final int stage;
        private final AdvancedClimber advancedClimber;

        public WaitUntilArmsOnPositionByEncoder(AdvancedClimber advancedClimber, Arms arms, IntSupplier positionInEncoderUnitsSupplier, int stage) {
            this.arms = arms;
            this.stage = stage;
            this.positionSupplier = positionInEncoderUnitsSupplier;
            this.advancedClimber = advancedClimber;
        }

        @Override
        public void initialize() {
            System.out.println("value:" + arms.getEncoderUnits());
            currentPosition = (int)(arms.getEncoderUnits()) + positionSupplier.getAsInt();
            arms.setMaxClimbUnits(currentPosition);
        }

        @Override
        public boolean isFinished() {
            return arms.isEncoderOnTarget(currentPosition) || advancedClimber.getStage() != stage;
        }

        @Override
        public void end(boolean interrupted) {
            if(stage == advancedClimber.getStage() && arms.isEncoderOnTarget(currentPosition)) {
                advancedClimber.setStage(stage + 1);
                System.out.println("Stage" + stage);
            }
        }
    }
