package me.nullnet.voxelclient.client;

import me.nullnet.voxelclient.packets.AtlasPayloadPacket;
import me.nullnet.voxelclient.packets.AuthMeVelocityPayloadPacket;
import me.nullnet.voxelclient.packets.CMDBRIPayloadPacket;
import me.nullnet.voxelclient.packets.ChatSentryPayloadPacket;
import me.nullnet.voxelclient.packets.CloudSyncPayloadPacket;
import me.nullnet.voxelclient.packets.DRSPayloadPacket;
import me.nullnet.voxelclient.packets.ECBPayloadPacket;
import me.nullnet.voxelclient.packets.LuckPermsPayloadPacket;
import me.nullnet.voxelclient.packets.PurpurPayloadPacket;
import me.nullnet.voxelclient.packets.SignedVelocityPayloadPacket;
import me.nullnet.voxelclient.packets.T2CPayloadPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class MainClient implements ClientModInitializer {
   public void onInitializeClient() {
      PayloadTypeRegistry.playC2S().register(PurpurPayloadPacket.ID, PurpurPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(AuthMeVelocityPayloadPacket.ID, AuthMeVelocityPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(AtlasPayloadPacket.ID, AtlasPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(ChatSentryPayloadPacket.ID, ChatSentryPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(CloudSyncPayloadPacket.ID, CloudSyncPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(CMDBRIPayloadPacket.ID, CMDBRIPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(DRSPayloadPacket.ID, DRSPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(ECBPayloadPacket.ID, ECBPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(LuckPermsPayloadPacket.ID, LuckPermsPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(SignedVelocityPayloadPacket.ID, SignedVelocityPayloadPacket.CODEC);
      PayloadTypeRegistry.playC2S().register(T2CPayloadPacket.ID, T2CPayloadPacket.CODEC);
   }
}
