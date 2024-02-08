package com.SimplySkin.common.blocks;

import com.SimplySkin.Constant;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.List;

@Mod.EventBusSubscriber(modid = Constant.MODID)
public class BlocksRegister {

    public static final BlocksRegister INSTANCE = new BlocksRegister();
    private List<Block> blocks;

    public void init() {
        blocks = Lists.newArrayList();
        //Blocks.register();
        registerItemBlock();
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    //==================================================FORGE===========================================================
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        for (Block block : blocks) {
            registerBlocksModels(block);
        }
    }

    public void registerBlocksModels(Block block) {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(block),
                0,
                new ModelResourceLocation(
                        new ResourceLocation(
                                Constant.MODID,
                                Item.getItemFromBlock(block).getTranslationKey().substring(5)
                        ),
                        "inventory")
        );
    }

    public void registerItemBlock() {
        for (Block b : blocks) {
            ItemBlock ib = new ItemBlock(b);
            ib.setRegistryName(b.getRegistryName());
            GameRegistry.findRegistry(Item.class).register(ib);
        }
    }

}
