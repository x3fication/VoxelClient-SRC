package me.nullnet.voxelclient.mixins;

import com.mojang.authlib.GameProfile;
import me.nullnet.voxelclient.Main;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_5250;
import net.minecraft.class_640;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_640.class})
public abstract class PlayerListEntryMixin {
   @Shadow
   @Nullable
   private class_2561 field_3743;

   @Shadow
   public abstract GameProfile method_2966();

   @Inject(
      method = {"getDisplayName"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getDisplayName(CallbackInfoReturnable<class_2561> cir) {
      class_5250 prefix;
      class_5250 newDisplayName;
      if (Main.devs.contains(this.method_2966().getName())) {
         prefix = class_2561.method_43470("[").method_10862(class_2583.field_24360.method_10977(class_124.field_1063)).method_10852(class_2561.method_43470("Voxel").method_10862(class_2583.field_24360.method_10977(class_124.field_1064).method_10982(true))).method_10852(class_2561.method_43470("Developer").method_10862(class_2583.field_24360.method_10977(class_124.field_1076))).method_10852(class_2561.method_43470("] ").method_10862(class_2583.field_24360.method_10977(class_124.field_1063)));
         newDisplayName = this.field_3743 != null ? prefix.method_10852(this.field_3743.method_27661()) : prefix;
         cir.setReturnValue(newDisplayName);
      }

      if (Main.betaTesters.contains(this.method_2966().getName())) {
         prefix = class_2561.method_43470("[").method_10862(class_2583.field_24360.method_10977(class_124.field_1063)).method_10852(class_2561.method_43470("Voxel").method_10862(class_2583.field_24360.method_10977(class_124.field_1064).method_10982(true))).method_10852(class_2561.method_43470("Tester").method_10862(class_2583.field_24360.method_10977(class_124.field_1076))).method_10852(class_2561.method_43470("] ").method_10862(class_2583.field_24360.method_10977(class_124.field_1063)));
         newDisplayName = this.field_3743 != null ? prefix.method_10852(this.field_3743.method_27661()) : prefix;
         cir.setReturnValue(newDisplayName);
      }

   }
}
