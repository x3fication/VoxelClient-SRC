package me.nullnet.voxelclient.mixins;

import me.nullnet.voxelclient.client.screens.GameMenuExtrasScreen;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_751;
import net.minecraft.class_766;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_437.class})
public abstract class ScreenMixin {
   @Shadow
   public int field_22789;
   @Shadow
   public int field_22790;
   private static final class_751 PANORAMA_RENDERER = new class_751(class_2960.method_60655("voxelclient", "background/bg"));
   private static final class_766 ROTATING_PANORAMA_RENDERER;

   @Inject(
      method = {"renderBackground"},
      at = {@At("TAIL")}
   )
   public void renderBackground(class_332 context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
      if (!(class_310.method_1551().field_1755 instanceof class_433) && !(class_310.method_1551().field_1755 instanceof GameMenuExtrasScreen)) {
         ROTATING_PANORAMA_RENDERER.method_3317(context, this.field_22789, this.field_22790, 1.0F, delta);
      }

   }

   static {
      ROTATING_PANORAMA_RENDERER = new class_766(PANORAMA_RENDERER);
   }
}
