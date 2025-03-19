package me.nullnet.voxelclient.mixins;

import me.nullnet.voxelclient.Main;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_500;
import net.minecraft.class_4185.class_7840;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_500.class})
public abstract class MultiplayerScreenMixin extends class_437 {
   @Shadow
   private class_4185 field_3041;

   protected MultiplayerScreenMixin(class_2561 title) {
      super(title);
   }

   @Inject(
      method = {"init"},
      at = {@At("RETURN")}
   )
   private void onInit(CallbackInfo ci) {
      class_7840 builder = class_4185.method_46430(class_2561.method_43470("PrivateMode: ").method_10852(class_2561.method_43470(Main.privateMode ? "ON" : "OFF").method_10862(class_2583.field_24360.method_10977(Main.privateMode ? class_124.field_1060 : class_124.field_1061))), (buttonx) -> {
         this.toggleStatus();
      }).method_46437(98, 20);
      class_4185 button = builder.method_46431();
      class_4185 editButton = this.field_3041;
      if (editButton != null) {
         button.method_48229(editButton.method_46426() - button.method_25368() - 10, editButton.method_46427());
      }

      this.method_37063(button);
   }

   @Unique
   private void toggleStatus() {
      Main.privateMode = !Main.privateMode;
      this.method_25396().stream().filter((widget) -> {
         return widget instanceof class_4185;
      }).map((widget) -> {
         return (class_4185)widget;
      }).filter((button) -> {
         return button.method_25369().getString().contains("PrivateMode");
      }).forEach((button) -> {
         button.method_25355(class_2561.method_43470("PrivateMode: ").method_10852(class_2561.method_43470(Main.privateMode ? "ON" : "OFF").method_10862(class_2583.field_24360.method_10977(Main.privateMode ? class_124.field_1060 : class_124.field_1061))));
      });
   }
}
