package me.nullnet.voxelclient.packets;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.minecraft.class_2540;
import net.minecraft.class_2960;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.class_8710.class_9154;

public record ECBPayloadPacket(String command) implements class_8710 {
   public static final class_9139<class_2540, ECBPayloadPacket> CODEC = class_8710.method_56484(ECBPayloadPacket::write, ECBPayloadPacket::new);
   public static final class_9154<ECBPayloadPacket> ID = new class_9154(class_2960.method_60655("ecb", "channel"));

   public ECBPayloadPacket(class_2540 buf) {
      this(buf.method_19772());
   }

   public ECBPayloadPacket(String command) {
      this.command = command;
   }

   public void write(class_2540 buf) {
      ByteArrayDataOutput out = ByteStreams.newDataOutput();
      out.writeUTF("ActionsSubChannel");
      out.writeUTF("console_command: " + this.command);
      buf.method_52983(out.toByteArray());
   }

   public class_9154<ECBPayloadPacket> method_56479() {
      return ID;
   }

   public String command() {
      return this.command;
   }
}
