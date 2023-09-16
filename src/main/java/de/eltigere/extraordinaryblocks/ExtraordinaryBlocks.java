package de.eltigere.extraordinaryblocks;

import com.mojang.logging.LogUtils;
import de.eltigere.extraordinaryblocks.blockentities.FogBlockBE;
import de.eltigere.extraordinaryblocks.blockentities.renderers.FogBlockBER;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraftforge.client.event.EntityRenderersEvent;
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
        //modEventBus.addListener(ExtraordinaryBlocks::onRegisterNamedRenderTypes);
        modEventBus.addListener(ExtraordinaryBlocks::onRegisterEntityRenderers);

        MinecraftForge.EVENT_BUS.register(this);

        // register mod content
        BlockRegistry.register(modEventBus);
        BlockEntityRegistry.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("common setup of Extraordinary Blocks Mod");
    }

    /*private static void onRegisterNamedRenderTypes(RegisterNamedRenderTypesEvent event) {
        event.register("fog", RenderType.solid(), Sheets.solidBlockSheet());
    }*/

    private static void onRegisterEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityRegistry.FOG_BET.get(), FogBlockBER::new);
    }
}
