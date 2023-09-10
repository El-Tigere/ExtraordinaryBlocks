package de.eltigere.extraordinaryblocks;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ExtraordinaryBlocks.MODID)
public class ExtraordinaryBlocks {

    public static final String MODID = "extraordinaryblocks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExtraordinaryBlocks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        // register mod content
        BlockRegistry.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("common setup of Extraordinary Blocks Mod");
    }
}
