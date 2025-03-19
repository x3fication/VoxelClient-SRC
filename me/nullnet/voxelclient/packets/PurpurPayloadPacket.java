package me.nullnet.voxelclient.packets;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.minecraft.class_2540;
import net.minecraft.class_2960;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.class_8710.class_9154;

public record PurpurPayloadPacket(long position) implements class_8710 {
   public static final class_9139<class_2540, PurpurPayloadPacket> CODEC = class_8710.method_56484(PurpurPayloadPacket::write, PurpurPayloadPacket::new);
   public static final class_9154<PurpurPayloadPacket> ID = new class_9154(class_2960.method_60655("fastlogin", "main"));

   private PurpurPayloadPacket(class_2540 buf) {
      this(buf.readLong());
   }

   public PurpurPayloadPacket(long position) {
      this.position = position;
   }

   public void write(class_2540 buf) {
      ByteArrayDataOutput out = ByteStreams.newDataOutput();
      out.writeInt(0);
      out.writeLong(this.position);
      buf.method_52983(out.toByteArray());
   }

   public class_9154<PurpurPayloadPacket> method_56479() {
      return ID;
   }

   public long position() {
      return this.position;
   }
}
