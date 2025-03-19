package me.nullnet.voxelclient.mixins;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_751;
import net.minecraft.class_766;
import net.minecraft.class_8519;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin({class_442.class})
public abstract class TitleScreenMixin extends class_437 {
   @Shadow
   private float field_49514;
   private static final Logger LOGGER = LoggerFactory.getLogger(TitleScreenMixin.class);
   private static final List<class_8519> SPLASHES = new ArrayList();
   private static final class_751 PANORAMA_RENDERER = new class_751(class_2960.method_60655("voxelclient", "background/bg"));
   private static final class_766 ROTATING_PANORAMA_RENDERER;
   private class_751 cubeMapRenderer;
   @Nullable
   private class_8519 splashText;

   protected TitleScreenMixin(class_2561 title) {
      super(title);
   }

   @Inject(
      method = {"init"},
      at = {@At("HEAD")}
   )
   private void modifySplashText(CallbackInfo ci) {
      if (this.splashText == null && SPLASHES.isEmpty()) {
         SPLASHES.add(new class_8519("Bribe. Grief. Larp. Clout. Repeat."));
         SPLASHES.add(new class_8519("Griefing is cool ngl"));
         SPLASHES.add(new class_8519("@shiblrr is cooking"));
         SPLASHES.add(new class_8519("VoxelClient on top fr"));
         SPLASHES.add(new class_8519("Don't try LEGO Fortnite!"));
         SPLASHES.add(new class_8519("Griefing: Because why not?"));
         SPLASHES.add(new class_8519("Using bugs to make the world burn."));
         SPLASHES.add(new class_8519("Whats a server without a little destruction?"));
         SPLASHES.add(new class_8519("Let the chaos begin, one exploit at a time."));
         SPLASHES.add(new class_8519("Where griefing meets creativity."));
         SPLASHES.add(new class_8519("Grief the world, one block at a time."));
         SPLASHES.add(new class_8519("Why? Its fun."));
         this.splashText = (class_8519)SPLASHES.get(ThreadLocalRandom.current().nextInt(SPLASHES.size()));
      }

   }

   public void method_25420(class_332 context, int mouseX, int mouseY, float delta) {
      ROTATING_PANORAMA_RENDERER.method_3317(context, this.field_22789, this.field_22790, this.field_49514, delta);
   }

   static {
      ROTATING_PANORAMA_RENDERER = new class_766(PANORAMA_RENDERER);
   }
}
