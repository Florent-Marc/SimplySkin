package com.SimplySkin.common.utils;


import com.SimplySkin.Constant;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.compress.utils.IOUtils;
import org.jline.utils.Log;
import org.lwjgl.opengl.Display;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class Window {


    public static void setIcon() {
        InputStream inputStream = null;
        InputStream inputStream1 = null;

        try {

            inputStream = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(Constant.MODID, "textures/icon_16x16.png")).getInputStream();
            inputStream1 = Minecraft.getMinecraft().getResourceManager().getResource(new ResourceLocation(Constant.MODID, "textures/icon_32x32.png")).getInputStream();

            Display.setIcon(new ByteBuffer[]{readImageToBuffer(inputStream), readImageToBuffer(inputStream1)});
        } catch (IOException exception) {
            Log.error("Couldn't set icon", exception);

        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(inputStream1);
        }

    }

    public static ByteBuffer readImageToBuffer(InputStream imageStream) throws IOException {
        BufferedImage bufferedimage = ImageIO.read(imageStream);
        int[] aint = bufferedimage.getRGB(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), null, 0, bufferedimage.getWidth());
        ByteBuffer bytebuffer = ByteBuffer.allocate(4 * aint.length);

        for (int i : aint) {
            bytebuffer.putInt(i << 8 | i >> 24 & 255);
        }

        bytebuffer.flip();
        return bytebuffer;
    }
}
