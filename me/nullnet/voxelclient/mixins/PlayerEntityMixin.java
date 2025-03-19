package me.nullnet.voxelclient.mixins;

import java.util.Objects;
import me.nullnet.voxelclient.Main;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2960;
import net.minecraft.class_742;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin({class_742.class})
public abstract class PlayerEntityMixin {
   private final class_2960 CAPE_TEXTURE = class_2960.method_60655("voxelclient", "capes/cape1.png");

   @Inject(
      at = {@At("RETURN")},
      method = {"getSkinTextures"},
      cancellable = true
   )
   private void getSkinTextures(CallbackInfoReturnable<class_8685> info) {
      class_742 th = (class_742)this;
      class_8685 ogtex;
      class_8685 modtex;
      if ((Main.devs.contains(th.method_5667().toString()) || Main.betaTesters.contains(th.method_5667().toString())) && Objects.equals(Main.originalUuid, th.method_5667().toString())) {
         ogtex = (class_8685)info.getReturnValue();
         if (ogtex == null) {
            return;
         }

         modtex = new class_8685(ogtex.comp_1626(), ogtex.comp_1911(), this.CAPE_TEXTURE, ogtex.comp_1628(), ogtex.comp_1629(), ogtex.comp_1630());
         info.setReturnValue(modtex);
      } else {
         ogtex = (class_8685)info.getReturnValue();
         if (ogtex == null) {
            return;
         }

         modtex = new class_8685(ogtex.comp_1626(), ogtex.comp_1911(), ogtex.comp_1627(), ogtex.comp_1628(), ogtex.comp_1629(), ogtex.comp_1630());
         info.setReturnValue(modtex);
      }

   }
}
