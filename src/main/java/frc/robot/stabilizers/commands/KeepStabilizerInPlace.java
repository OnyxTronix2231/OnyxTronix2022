package frc.robot.stabilizers.commands;

import frc.robot.stabilizers.Stabilizer;

import static frc.robot.stabilizers.StabilizerConstants.KEEP_STABILIZER_IN_PLACE_SPEED;

public class KeepStabilizerInPlace extends MoveStabilizerBySpeed{

    public KeepStabilizerInPlace(Stabilizer stabilizer) {
        super(stabilizer, ()-> KEEP_STABILIZER_IN_PLACE_SPEED);
    }
}
