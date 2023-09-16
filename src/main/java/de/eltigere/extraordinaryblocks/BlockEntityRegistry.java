package de.eltigere.extraordinaryblocks;

import de.eltigere.extraordinaryblocks.blockentities.FogBlockBE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BETS = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExtraordinaryBlocks.MODID); // block entity types -> bets

    public static final RegistryObject<BlockEntityType<FogBlockBE>> FOG_BET = BETS.register("fog_block", () -> BlockEntityType.Builder.of(FogBlockBE::new, BlockRegistry.FOG_BLOCK.get()).build(null));

    public static void register(IEventBus modEventBus) {
        BETS.register(modEventBus);
    }
}
