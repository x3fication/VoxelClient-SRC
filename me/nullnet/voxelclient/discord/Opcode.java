package me.nullnet.voxelclient.discord;

public enum Opcode {
   Handshake,
   Frame,
   Close,
   Ping,
   Pong;

   private static final Opcode[] VALUES = values();

   public static Opcode valueOf(int i) {
      return VALUES[i];
   }

   // $FF: synthetic method
   private static Opcode[] $values() {
      return new Opcode[]{Handshake, Frame, Close, Ping, Pong};
   }
}
