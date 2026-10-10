package com.parsa.engineering;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public final class ModBlocks {
    public static final Block GENERATOR = register("generator",
        "Generator", "Prototype ready. Energy system is the next upgrade.");
    public static final Block CRUSHER = register("crusher",
        "Crusher", "Crusher online. Recipe processing is planned for the next upgrade.");
    public static final Block ELECTRIC_FURNACE = register("electric_furnace",
        "Electric Furnace", "Furnace online. Power and smelting automation are next.");

    private ModBlocks() {}

    private static Block register(String name, String displayName, String message) {
        Identifier id = Identifier.fromNamespaceAndPath(ParsaEngineering.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

        Block block = new IndustrialMachineBlock(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL)
                .strength(3.5F, 6.0F)
                .requiresCorrectToolForDrops()
                .setId(blockKey),
            displayName, message
        );
        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        BlockItem item = new BlockItem(block,
            new Item.Properties().useBlockDescriptionPrefix().setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return block;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.accept(GENERATOR);
            entries.accept(CRUSHER);
            entries.accept(ELECTRIC_FURNACE);
        });
    }
}
