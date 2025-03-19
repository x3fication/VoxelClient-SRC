package me.nullnet.voxelclient.mixins;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.nullnet.voxelclient.Main;
import net.minecraft.class_2561;
import net.minecraft.class_5244;
import net.minecraft.class_642;
import net.minecraft.class_4267.class_4270;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_4270.class})
public abstract class MultiplayerServerListWidget$ServerEntryMixin {
   @Shadow
   @Final
   private class_642 field_19120;
   private final Pattern IPv4Pattern = Pattern.compile("(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}(2[0-4][0-9]|25[0-5]|1[0-9]{2}|[1-9][0-9]|[0-9])");

   @Inject(
      method = {"render"},
      at = {@At("HEAD")}
   )
   private void overwriteMOTDGet(CallbackInfo ci) {
      class_2561 original = this.field_19120.field_3757;
      boolean isOnline = this.field_19120.field_3758 != -1L && this.field_19120.field_3753 != null && this.field_19120.field_3753 != class_5244.field_39003;
      if (Main.privateMode) {
         this.field_19120.field_3757 = this.transformMOTD(original, isOnline);
         this.field_19120.field_3752 = this.censorIPs(this.field_19120.field_3752);
      }

   }

   @Unique
   private class_2561 transformMOTD(class_2561 original, boolean isOnline) {
      if (!isOnline) {
         return original;
      } else {
         return !Main.privateMode ? original : class_2561.method_30163("[HIDDEN]");
      }
   }

   public String censorIPs(String s) {
      if (s.length() < 7) {
         return s;
      } else if (s.indexOf(46) == -1) {
         return s;
      } else if (s.indexOf(48) == -1 && s.indexOf(49) == -1 && s.indexOf(50) == -1) {
         return s;
      } else {
         Matcher matcher = this.IPv4Pattern.matcher(s);
         return matcher.replaceAll("xxx.xxx.xxx.xxx");
      }
   }
}
