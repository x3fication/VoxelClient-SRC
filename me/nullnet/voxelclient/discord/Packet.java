package me.nullnet.voxelclient.discord;

import com.google.gson.JsonObject;

public record Packet(Opcode opcode, JsonObject data) {
   public Packet(Opcode opcode, JsonObject data) {
      this.opcode = opcode;
      this.data = data;
   }

   public Opcode opcode() {
      return this.opcode;
   }

   public JsonObject data() {
      return this.data;
   }
}
