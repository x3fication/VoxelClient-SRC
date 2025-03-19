package me.nullnet.voxelclient.mixins;

import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({class_310.class})
public abstract class MinecraftClientMixin {
   @ModifyConstant(
      method = {"getWindowTitle"},
      constant = {@Constant(
   stringValue = "Minecraft"
)}
   )
   String modifyMinecraftConst(String constant) {
      return "VoxelClient | Minecraft";
   }
}
