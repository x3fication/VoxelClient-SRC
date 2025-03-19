package me.nullnet.voxelclient.mixins;

import java.util.ArrayList;
import java.util.Iterator;
import me.nullnet.voxelclient.Main;
import me.nullnet.voxelclient.utils.ColorUtil;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_9779;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_329.class})
public abstract class InGameHUDMixin {
   @Inject(
      method = {"render"},
      at = {@At("TAIL")}
   )
   public void renderMainHud(class_332 context, class_9779 tickCounter, CallbackInfo ci) {
      class_310 client = class_310.method_1551();
      if (client != null && client.field_1772 != null) {
         ArrayList<class_2561> hudText = new ArrayList();
         if (Main.hudVisible) {
            if (Main.isDev) {
               hudText.add(ColorUtil.translate("&n&5&lVoxel&r&n&dClient &8[&b%s&8] [&cDEV&8]".formatted(new Object[]{"1.4.1"})));
            } else {
               hudText.add(ColorUtil.translate("&n&5&lVoxel&r&n&dClient &8[&b%s&8]".formatted(new Object[]{"1.4.1"})));
            }

            if (Main.hudServerVisible) {
               if (Main.privateMode) {
                  hudText.add(ColorUtil.translate("&5Server &8›› &d[HIDDEN]"));
               } else {
                  String serverName = client.method_1558() != null ? client.method_1558().field_3761 : "None";
                  hudText.add(ColorUtil.translate("&5Server &8›› &d" + serverName));
               }
            }

            if (Main.hudFPSVisible) {
               hudText.add(ColorUtil.translate("&5FPS &8›› &d" + client.method_47599()));
            }

            if (Main.hudPlayersVisible) {
               hudText.add(ColorUtil.translate("&5Players &8›› &d" + client.field_1724.field_3944.method_2880().size()));
            }

            if (Main.hudEngineVisible) {
               hudText.add(ColorUtil.translate("&5Engine &8>> &d" + client.field_1724.field_3944.method_52790()));
            }
         }

         int yOffset = 5;

         for(Iterator var7 = hudText.iterator(); var7.hasNext(); yOffset += 10) {
            class_2561 line = (class_2561)var7.next();
            context.method_51433(client.field_1772, line.getString(), 2, yOffset, 16777215, true);
         }
      }

   }
}
