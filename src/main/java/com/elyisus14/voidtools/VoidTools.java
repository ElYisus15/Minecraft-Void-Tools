package com.elyisus14.voidtools;

import static com.elyisus14.voidtools.ToolTiers.VOID_TIER;

import com.elyisus14.voidtools.Food.VoidApple;
import com.elyisus14.voidtools.Food.VoidCarrot;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.SoundType;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(VoidTools.MODID)
public class VoidTools {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "voidtools";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "voidtools" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "voidtools" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "voidtools" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
//Blocks
    // Creates a new Block with the id "voidtools:example_block", combining the namespace and path
    public static final DeferredBlock<Block> VOID_BLOCK = BLOCKS.registerSimpleBlock("void_block", BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE).strength(75f,3600000.0f)
            .requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK));

//Item Blocks
    // Creates a new BlockItem with the id "voidtools:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> VOID_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("void_block", VOID_BLOCK, new Item.Properties().rarity(Rarity.EPIC));

//Foods
    public static final DeferredHolder<Item,Item> VOID_APPLE = ITEMS.register("void_apple",
            () -> new VoidApple(new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(40).saturationModifier(1.125f).build())));

    public static final DeferredHolder<Item,Item> VOID_CARROT = ITEMS.register("void_carrot",
            () -> new VoidCarrot(new Item.Properties().fireResistant().rarity(Rarity.EPIC)
                    .food(new FoodProperties.Builder().alwaysEdible().nutrition(40).saturationModifier(1.125f).build())));

//Items
    public static final DeferredItem<Item> VOID_INGOT = ITEMS.registerSimpleItem("void_ingot", new Item.Properties().rarity(Rarity.EPIC));
    public static final DeferredItem<Item> VOID_SHARD = ITEMS.registerSimpleItem("void_shard", new Item.Properties().rarity(Rarity.EPIC));
    public static final DeferredItem<Item> VOID_ROD = ITEMS.registerSimpleItem("void_rod", new Item.Properties().rarity(Rarity.EPIC));

//Tools
    public static final Supplier<SwordItem> VOID_SWORD = ITEMS.register("void_sword", () -> new SwordItem(VOID_TIER, new Item.Properties().rarity(Rarity.EPIC).attributes(SwordItem.createAttributes(VOID_TIER, 20, 9f)).setNoRepair().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true))));
    public static final Supplier<PickaxeItem> VOID_PICK = ITEMS.register("void_pick", () -> new PickaxeItem(VOID_TIER, new Item.Properties().rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(VOID_TIER, 14, 8f)).setNoRepair().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true))));
    public static final Supplier<ShovelItem> VOID_SHOVEL = ITEMS.register("void_shovel", () -> new ShovelItem(VOID_TIER, new Item.Properties().rarity(Rarity.EPIC).attributes(ShovelItem.createAttributes(VOID_TIER, 11, 6f)).setNoRepair().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true))));
    public static final Supplier<HoeItem> VOID_HOE = ITEMS.register("void_hoe", () -> new HoeItem(VOID_TIER, new Item.Properties().rarity(Rarity.EPIC).attributes(HoeItem.createAttributes(VOID_TIER, 12, 5f)).setNoRepair().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true))));
    public static final Supplier<AxeItem> VOID_AXE = ITEMS.register("void_axe", () -> new AxeItem(VOID_TIER, new Item.Properties().rarity(Rarity.EPIC).attributes(AxeItem.createAttributes(VOID_TIER, 23, 7f)).setNoRepair().fireResistant().component(DataComponents.UNBREAKABLE, new Unbreakable(true))));

//Creative Tab
    // Creates a creative tab with the id "voidtools:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> VOID_TOOLS_TAB = CREATIVE_MODE_TABS.register("voidtools1tab_elyisus14", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.voidtools")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> VOID_PICK.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(VOID_SWORD.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(VOID_SHOVEL.get());
                output.accept(VOID_PICK.get());
                output.accept(VOID_AXE.get());
                output.accept(VOID_HOE.get());
                output.accept(VOID_ROD.get());
                output.accept(VOID_SHARD.get());
                output.accept(VOID_INGOT.get());
                output.accept(VOID_BLOCK_ITEM.get());
                output.accept(VOID_APPLE.get());
                output.accept(VOID_CARROT.get());
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public VoidTools(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (VoidTools) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

//        if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
//            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
//        }

//        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

//        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(VOID_BLOCK_ITEM);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept((ItemLike) VOID_SHOVEL);
            event.accept((ItemLike) VOID_PICK);
            event.accept((ItemLike) VOID_AXE);
            event.accept((ItemLike) VOID_HOE);
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept((ItemLike) VOID_APPLE);
            event.accept((ItemLike) VOID_CARROT);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept((ItemLike) VOID_SWORD);
        }
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
