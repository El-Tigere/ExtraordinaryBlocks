package de.eltigere.extraordinaryblocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExtraordinaryBlocks.MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExtraordinaryBlocks.MODID);

    public static final RegistryObject<Block> BLACK_BLOCK = registerBlock("black_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(1.5f, 6f)), new Item.Properties());

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        BLOCK_ITEMS.register(modEventBus);
    }

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier, Item.Properties itemProperties) {
        RegistryObject<Block> registryObject = BLOCKS.register(name, supplier);
        BLOCK_ITEMS.register(name, () -> new BlockItem(registryObject.get(), itemProperties));
        return registryObject;
    }
}
