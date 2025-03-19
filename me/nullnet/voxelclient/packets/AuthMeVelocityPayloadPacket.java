package me.nullnet.voxelclient.packets;

import net.minecraft.class_2540;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.class_8710.class_9154;

public record AuthMeVelocityPayloadPacket() implements class_8710 {
   public static final class_9139<class_2540, AuthMeVelocityPayloadPacket> CODEC = class_8710.method_56484(AuthMeVelocityPayloadPacket::write, AuthMeVelocityPayloadPacket::new);
   public static final class_9154<AuthMeVelocityPayloadPacket> ID = new class_9154(class_2960.method_60655("authmevelocity", "main"));

   private AuthMeVelocityPayloadPacket(class_2540 buf) {
      this();
   }

   public AuthMeVelocityPayloadPacket() {
   }

   private void write(class_2540 buf) {
      buf.method_52997(0);
      buf.method_10814("LOGIN");
      buf.method_52997(0);
      buf.method_10814(class_310.method_1551().method_53462().getName());
   }

   public class_9154<AuthMeVelocityPayloadPacket> method_56479() {
      return ID;
   }
}
