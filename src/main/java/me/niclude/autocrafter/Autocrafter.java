package me.niclude.autocrafter;

import me.niclude.autocrafter.blocks.AutoCraftingTableBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Autocrafter implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("autocrafter");

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("autocrafter", "group")).build();


	public static final AutoCraftingTableBlock AUTOMATIC_CRAFTING_TABLE = new AutoCraftingTableBlock(FabricBlockSettings.of(Material.METAL).strength(3.0f));
	public static final Item CRAFTING_BLUEPRINT = new Item(new FabricItemSettings().group(ITEM_GROUP));


	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("autocrafter", "automatic_crafting_table"), AUTOMATIC_CRAFTING_TABLE);
		Registry.register(Registry.ITEM, new Identifier("autocrafter", "automatic_crafting_table"), new BlockItem(AUTOMATIC_CRAFTING_TABLE, new FabricItemSettings().group(ITEM_GROUP)));

		Registry.register(Registry.ITEM, new Identifier("autocrafter", "crafting_blueprint"), CRAFTING_BLUEPRINT);

		LOGGER.info("autocrafter initialized");
	}
}
