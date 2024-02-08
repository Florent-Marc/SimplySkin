package com.SimplySkin.common.event.register;

import com.SimplySkin.Constant;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {

    public static SoundEvent example1, example2;

    public static void registerSounds(){
        example1 = registerSound("example1");
        example2 = registerSound("example2");
    }

    private static SoundEvent registerSound(String name){
        ResourceLocation loc = new ResourceLocation(Constant.MODID, name);
        SoundEvent event = new SoundEvent(loc);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
