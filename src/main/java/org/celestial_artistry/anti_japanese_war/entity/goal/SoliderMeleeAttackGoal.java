package org.celestial_artistry.anti_japanese_war.entity.goal;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class SoliderMeleeAttackGoal extends MeleeAttackGoal {

    private final PathfinderMob pathfinderMob;

    public SoliderMeleeAttackGoal(PathfinderMob p_25552_) {
        super(p_25552_, 1.2D, false);
        this.pathfinderMob = p_25552_;
    }


    @Override
    public void stop() {
        super.stop();
        pathfinderMob.setAggressive(false);
    }

    @Override
    public void start() {
        super.start();
        pathfinderMob.setAggressive(true);
    }
}
