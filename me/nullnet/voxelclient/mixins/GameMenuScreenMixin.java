package me.nullnet.voxelclient.mixins;

import java.util.function.Supplier;
import me.nullnet.voxelclient.client.screens.GameMenuExtrasScreen;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_4185;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_7919;
import net.minecraft.class_8021;
import net.minecraft.class_7845.class_7939;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({class_433.class})
public abstract class GameMenuScreenMixin extends class_437 {
   @Unique
   private static final class_2561 MORE_TEXT = class_2561.method_43471("createWorld.tab.more.title");

   protected GameMenuScreenMixin() {
      super((class_2561)null);
   }

   @Shadow
   protected abstract class_4185 method_47900(class_2561 var1, Supplier<class_437> var2);

   @Shadow
   public abstract void method_25393();

   @Redirect(
      method = {"initWidgets"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/minecraft/client/gui/widget/GridWidget$Adder;add(Lnet/minecraft/client/gui/widget/Widget;)Lnet/minecraft/client/gui/widget/Widget;",
   ordinal = 0
)
   )
   private class_8021 replaceAdvancementsBtn(class_7939 instance, class_8021 advancementsBtn) {
      class_4185 buttonWidget = this.method_47900(MORE_TEXT, () -> {
         return new GameMenuExtrasScreen((class_433)this);
      });
      if (class_310.method_1551().method_1542()) {
         buttonWidget.field_22763 = false;
         buttonWidget.method_47400(class_7919.method_47407(class_2561.method_30163("Not available in singleplayer!")));
      }

      return instance.method_47612(buttonWidget);
   }

   public boolean method_25404(int keyCode, int scanCode, int modifiers) {
      return class_437.method_25438(keyCode) && GameMenuExtrasScreen.copyServerIP() ? true : super.method_25404(keyCode, scanCode, modifiers);
   }
}
