package me.nullnet.voxelclient.packets;

import net.minecraft.class_2540;
import net.minecraft.class_2960;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.class_8710.class_9154;

public record LuckPermsPayloadPacket(String randomJson) implements class_8710 {
   public static final class_9139<class_2540, LuckPermsPayloadPacket> CODEC = class_8710.method_56484(LuckPermsPayloadPacket::write, LuckPermsPayloadPacket::new);
   public static final class_9154<LuckPermsPayloadPacket> ID = new class_9154(class_2960.method_60655("luckperms", "update"));

   private LuckPermsPayloadPacket(class_2540 buf) {
      this(buf.method_19772());
   }

   public LuckPermsPayloadPacket(String randomJson) {
      this.randomJson = randomJson;
   }

   public void write(class_2540 buf) {
      buf.method_10814(this.randomJson);
   }

   public class_9154<LuckPermsPayloadPacket> method_56479() {
      return ID;
   }

   public String randomJson() {
      return this.randomJson;
   }
}
