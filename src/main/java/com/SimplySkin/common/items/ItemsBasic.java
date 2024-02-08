package com.SimplySkin.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemsBasic extends Item {

    public ItemsBasic(String registryAndunlocalizedname, CreativeTabs creativeTabs, int stackcount, int durability)
    {
        this.setTranslationKey(registryAndunlocalizedname);
        this.setRegistryName(registryAndunlocalizedname);
        this.setCreativeTab(creativeTabs);
        this.setMaxStackSize(stackcount);
        this.setMaxDamage(durability);
        ItemsRegister.INSTANCE.getItems().add(this);
    }

}
