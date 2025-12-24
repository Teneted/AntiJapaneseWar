package org.celestial_artistry.anti_japanese_war.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.celestial_artistry.anti_japanese_war.entity.goal.RangedGunAttackGoal;
import org.celestial_artistry.anti_japanese_war.entity.goal.SoliderHurtByTargetGoal;
import org.celestial_artistry.anti_japanese_war.entity.goal.SoliderMeleeAttackGoal;
import org.celestial_artistry.anti_japanese_war.init.ModItems;
import org.celestial_artistry.anti_japanese_war.item.GunItem;
import org.celestial_artistry.anti_japanese_war.item.MusketBallItem;

import javax.annotation.Nullable;

public class CpcSolider extends PathfinderMob implements RangedAttackMob {

    private final RangedGunAttackGoal<CpcSolider> gunAttackGoal = new RangedGunAttackGoal<>(this, 1.0D, 20, 15.0F);
    private final SoliderMeleeAttackGoal meleeAttackGoal = new SoliderMeleeAttackGoal(this);

    public CpcSolider(EntityType<? extends PathfinderMob> p_32133_, Level p_32134_) {
        super(p_32133_, p_32134_);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F).add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new SoliderHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, JapaneseKatanaSolider.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, JapaneseSolider.class, true));
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_32146_, DifficultyInstance p_32147_, MobSpawnType p_32148_, @Nullable SpawnGroupData p_32149_, @Nullable CompoundTag p_32150_) {
        p_32149_ = super.finalizeSpawn(p_32146_, p_32147_, p_32148_, p_32149_, p_32150_);
        RandomSource randomsource = p_32146_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_32147_);
        this.populateDefaultEquipmentEnchantments(randomsource, p_32147_);
        this.reassessWeaponGoal();
        this.setCanPickUpLoot(randomsource.nextFloat() < 0.55F * p_32147_.getSpecialMultiplier());
        return p_32149_;
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource p_218949_, DifficultyInstance p_218950_) {
        super.populateDefaultEquipmentSlots(p_218949_, p_218950_);
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ModItems.CPC_SOLIDER_HELMET.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.CPC_RIFLE.get()));
        System.out.println("Setting main hand item " + this.getMainHandItem());
    }

    @Override
    protected float getStandingEyeHeight(Pose p_32154_, EntityDimensions p_32155_) {
        return 1.74F;
    }

    @Override
    public double getMyRidingOffset() {
        return -0.6D;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_32152_) {
        super.readAdditionalSaveData(p_32152_);
        this.reassessWeaponGoal();
    }

    @Override
    public void setItemSlot(EquipmentSlot p_32138_, ItemStack p_32139_) {
        super.setItemSlot(p_32138_, p_32139_);
        if (!this.level().isClientSide) {
            this.reassessWeaponGoal();
        }
    }

    public void reassessWeaponGoal() {
        if (this.level() != null && !this.level().isClientSide) {
            this.goalSelector.removeGoal(this.gunAttackGoal);
            this.goalSelector.removeGoal(this.meleeAttackGoal);
            ItemStack itemstack = this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof GunItem));
            if (itemstack.getItem() instanceof GunItem) {
                int i = 20;
                if (this.level().getDifficulty() != Difficulty.HARD) {
                    i = 40;
                }

                this.gunAttackGoal.setMinAttackInterval(i);
                this.goalSelector.addGoal(4, this.gunAttackGoal);
            } else {
                this.goalSelector.addGoal(4, this.meleeAttackGoal);
            }

        }
    }

    @Override
    public void performRangedAttack(LivingEntity p_32141_, float p_32142_) {
        ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof GunItem)));
        MusketBall musketBall = getMobMusketBall(this, itemstack, p_32142_);
        if (this.getMainHandItem().getItem() instanceof net.minecraft.world.item.BowItem)
            musketBall = ((GunItem)this.getMainHandItem().getItem()).customMusketBall(musketBall);
        double d0 = p_32141_.getX() - this.getX();
        double d1 = p_32141_.getY(0.3333333333333333D) - musketBall.getY();
        double d2 = p_32141_.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        musketBall.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(musketBall);
    }

    public static MusketBall getMobMusketBall(LivingEntity p_37301_, ItemStack p_37302_, float p_37303_) {
        MusketBallItem musketBallItem = (MusketBallItem)(p_37302_.getItem() instanceof MusketBallItem ? p_37302_.getItem() : ModItems.MUSKET_BALL.get());
        MusketBall musketBall = musketBallItem.createMusketBall(p_37301_.level(), p_37302_, p_37301_);
        musketBall.setEnchantmentEffectsFromEntity(p_37301_, p_37303_);
        return musketBall;
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_33579_) {
        return SoundEvents.PLAYER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PLAYER_DEATH;
    }

    @Override
    public boolean canFireProjectileWeapon(ProjectileWeaponItem p_32144_) {
        return p_32144_ == ModItems.MUSKET_BALL.get();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}
