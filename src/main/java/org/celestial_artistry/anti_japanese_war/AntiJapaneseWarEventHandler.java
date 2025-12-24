package org.celestial_artistry.anti_japanese_war;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.celestial_artistry.anti_japanese_war.init.ModEntities;
import org.celestial_artistry.anti_japanese_war.init.ModItems;
import org.celestial_artistry.anti_japanese_war.util.Helpers;

@Mod.EventBusSubscriber(modid = AntiJapaneseWarMod.MOD_ID)
public class AntiJapaneseWarEventHandler {

    @SubscribeEvent
    public static void foundHighlandBarleySeeds(PlayerInteractEvent.RightClickBlock event) {
        var player = event.getEntity();
        var level = event.getLevel();
        var pos = event.getPos();
        BlockState blockState = event.getLevel().getBlockState(pos);
        if (player.getMainHandItem().getItem() instanceof HoeItem) {
            if (!level.isClientSide && level.random.nextInt(18) == 0) {
                level.playSound(player, pos, SoundEvents.HOE_TILL,  SoundSource.BLOCKS, 1.0F, 1.0F);
                player.getMainHandItem().hurtAndBreak(1, player, (p_41300_) -> {
                    p_41300_.broadcastBreakEvent(event.getHand());
                });
                if (blockState.is(Blocks.GRASS_BLOCK)) {
                    level.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
                } else if (blockState.is(Blocks.GRASS)) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                } else if (blockState.is(Blocks.TALL_GRASS)) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.HIGHLAND_BARLEY_SEEDS.get())));
            }
        }
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        var entity = event.getEntity();
        var level = entity.level();
        boolean isSolider = entity.getType() == ModEntities.JAPANESE_SOLIDER.get()
                || entity.getType() == ModEntities.JAPANESE_KATANA_SOLIDER.get()
                || entity.getType() == ModEntities.KMT_SOLIDER.get()
                || entity.getType() == ModEntities.CPC_SOLIDER.get();
        if (isSolider) {
            if (!level.isClientSide) {
                ItemStack iron_nugget = new ItemStack(Items.IRON_NUGGET);
                iron_nugget.setCount(level.random.nextInt(1, 2));
                level.addFreshEntity(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), iron_nugget));
            }
        }
    }

    @SubscribeEvent
    public static void onEntitySpawn(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.JAPANESE_SOLIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Helpers::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ModEntities.JAPANESE_KATANA_SOLIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Helpers::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ModEntities.CPC_SOLIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Helpers::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
        event.register(ModEntities.KMT_SOLIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Helpers::checkSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
    }
}
