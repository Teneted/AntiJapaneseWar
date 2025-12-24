package org.celestial_artistry.anti_japanese_war.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.celestial_artistry.anti_japanese_war.AntiJapaneseWarMod;
import org.celestial_artistry.anti_japanese_war.init.ModItems;
import org.celestial_artistry.anti_japanese_war.item.GunItem;
import org.celestial_artistry.anti_japanese_war.item.MachineGunItem;

import java.util.Objects;

@SuppressWarnings("removal")
public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AntiJapaneseWarMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModItems.ITEMS.getEntries().forEach(item -> {
            if (item.get() instanceof GunItem) {
                gunItem(item.get());
            } else if (item.get() instanceof SwordItem) {
                handheldItem(item.get());
            } else if (item.get() instanceof ForgeSpawnEggItem) {
                spawnEggItem(item.get());
            }else if (item.get() instanceof MachineGunItem) {
                handheldItem(item.get());
            }else {
                basicItem(item.get());
            }
        });
    }

    public ItemModelBuilder gunItem(Item item)
    {
        return gunItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)));
    }

    public ItemModelBuilder gunItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(15, 80, -60)
                .translation(1, 0, -3)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(-45, -90, 0)
                .translation(0, 0, -3)
                .end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(-30, 90, 0)
                .scale(1.5f, 1.5f, 1.5f)
                .end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(-30, -90, 0)
                .scale(1.5f, 1.5f, 1.5f)
                .end()
                .end();
    }

    public ItemModelBuilder handheldItem(Item item)
    {
        return handheldItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)));
    }

    public ItemModelBuilder handheldItem(ResourceLocation item)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/handheld"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()));
    }

    public ItemModelBuilder spawnEggItem(Item item)
    {
        return spawnEggItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)));
    }

    public ItemModelBuilder spawnEggItem(ResourceLocation item)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
    }

}
