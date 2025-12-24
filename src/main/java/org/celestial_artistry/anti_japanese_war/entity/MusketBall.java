package org.celestial_artistry.anti_japanese_war.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import org.celestial_artistry.anti_japanese_war.init.ModEntities;
import org.celestial_artistry.anti_japanese_war.init.ModItems;

public class MusketBall extends AbstractArrow {
    private static final EntityDataAccessor<Integer> BULLET_DAMAGE = SynchedEntityData.defineId(MusketBall.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> PIERCING_LEVEL = SynchedEntityData.defineId(MusketBall.class, EntityDataSerializers.INT);

    private int bulletDamage = 10;
    public Entity shootingEntity;

    public MusketBall(EntityType<? extends AbstractArrow> type, Level world) {
        super(type, world);
        this.setBoundingBox(new AABB(this.getX() - 0.05, this.getY() - 0.05, this.getZ() - 0.05,
                this.getX() + 0.05, this.getY() + 0.05, this.getZ() + 0.05));
    }

    public MusketBall(Level world, LivingEntity shooter, int damage) {
        super(ModEntities.MUSKET_BALL.get(), shooter, world);
        this.bulletDamage = damage;
        this.shootingEntity = shooter;
        this.setPos(shooter.getX(), shooter.getEyeY(), shooter.getZ());

        double offsetX = -Math.sin(shooter.getYRot() * Math.PI / 180.0) * 0.16;
        double offsetY = -0.1;
        double offsetZ = Math.cos(shooter.getYRot() * Math.PI / 180.0) * 0.16;

        this.setPos(this.getX() + offsetX, this.getY() + offsetY, this.getZ() + offsetZ);

        Vec3 lookVec = shooter.getLookAngle();
        this.setDeltaMovement(lookVec.scale(3.0));
        this.setBoundingBox(new AABB(this.getX() - 0.05, this.getY() - 0.05, this.getZ() - 0.05,
                this.getX() + 0.05, this.getY() + 0.05, this.getZ() + 0.05));
    }

    public MusketBall(EntityType<? extends ThrowableProjectile> type, Level world, double x, double y, double z) {
        super(ModEntities.MUSKET_BALL.get(), x, y, z, world);
        this.setBoundingBox(new AABB(x - 0.05, y - 0.05, z - 0.05,
                x + 0.05, y + 0.05, z + 0.05));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(BULLET_DAMAGE, 10);
        this.getEntityData().define(PIERCING_LEVEL, 0);
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(ModItems.MUSKET_BALL.get());
    }

    @Override
    protected void onHit(HitResult result) {
        if (result.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityResult = (EntityHitResult) result;
            Entity hitEntity = entityResult.getEntity();

            if (hitEntity instanceof LivingEntity livingEntity) {
                DamageSource damageSource = this.damageSources().thrown(this, this.shootingEntity);
                livingEntity.hurt(damageSource, this.bulletDamage);
            }
        }

        if (shouldPierce()) {
            return;
        }

        this.discard();
    }

    private boolean shouldPierce() {
        return false;
    }

    public void setBulletDamage(int damage) {
        this.bulletDamage = damage;
    }

    public int getBulletDamage() {
        return this.bulletDamage;
    }

    public void setShootingEntity(Entity entity) {
        this.shootingEntity = entity;
    }

    public Entity getShootingEntity() {
        return this.shootingEntity;
    }
}
