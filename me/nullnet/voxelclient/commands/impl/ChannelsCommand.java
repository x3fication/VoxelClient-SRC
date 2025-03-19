package me.nullnet.voxelclient.commands.impl;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.Set;
import me.nullnet.voxelclient.utils.ColorUtil;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.class_2960;

public class ChannelsCommand {
   public void register() {
      ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
         dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("vchannels").executes(ChannelsCommand::executeRoot)).then(ClientCommandManager.literal("list").executes(ChannelsCommand::listChannels))).then(((LiteralArgumentBuilder)ClientCommandManager.literal("check").executes(ChannelsCommand::executeRoot)).then(ClientCommandManager.argument("channel", StringArgumentType.greedyString()).executes(ChannelsCommand::checkChannel)))).then(((LiteralArgumentBuilder)ClientCommandManager.literal("send").executes(ChannelsCommand::executeRoot)).then(((RequiredArgumentBuilder)ClientCommandManager.argument("channel", StringArgumentType.string()).executes(ChannelsCommand::executeRoot)).then(ClientCommandManager.argument("message", StringArgumentType.greedyString()).executes(ChannelsCommand::sendToChannel)))));
      });
   }

   private static int executeRoot(CommandContext<FabricClientCommandSource> context) {
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &cBad usage!"));
      return 1;
   }

   private static int listChannels(CommandContext<FabricClientCommandSource> ctx) {
      Set<class_2960> openChannels = ClientPlayNetworking.getSendable();
      Set<class_2960> ignoreChannels = Set.of(new class_2960[]{class_2960.method_60654("voicechat:add_group"), class_2960.method_60654("owo:local_packet"), class_2960.method_60654("voicechat:player_state"), class_2960.method_60654("voicechat:secret"), class_2960.method_60654("fabric:attachment_sync_v1"), class_2960.method_60654("xaerominimap:main"), class_2960.method_60654("essential:"), class_2960.method_60654("tcdcommons:cpn"), class_2960.method_60654("jade:server_ping_v1"), class_2960.method_60654("jade:show_overlay"), class_2960.method_60654("architectury:spawn_entity_packet"), class_2960.method_60654("jade:receive_data"), class_2960.method_60654("voicechat:joined_group"), class_2960.method_60654("voicechat:remove_category"), class_2960.method_60654("voicechat:remove_group"), class_2960.method_60654("voicechat:add_category"), class_2960.method_60654("shulkerboxtooltip:ec_update"), class_2960.method_60654("voicechat:player_states"), class_2960.method_60654("owo:sync_screen_handler_properties"), class_2960.method_60654("xaeroworldmap:main"), class_2960.method_60654("shulkerboxtooltip:s2c_handshake"), class_2960.method_60654("fabric-screen-handler-api-v1:open_screen")});
      if (openChannels.isEmpty()) {
         ((FabricClientCommandSource)ctx.getSource()).getPlayer().method_7353(ColorUtil.translate("&8[&5&lVoxel&8] &8[&5Channels&8] &cDidn't find any open channels."), false);
         return 1;
      } else {
         openChannels.forEach((channel) -> {
            if (!ignoreChannels.contains(channel)) {
               ((FabricClientCommandSource)ctx.getSource()).getPlayer().method_7353(ColorUtil.translate("&8[&5&lVoxel&8] &8[&5Channels&8] &7Channel: &d" + String.valueOf(channel)), false);
            }

         });
         return 1;
      }
   }

   private static int sendToChannel(CommandContext<FabricClientCommandSource> ctx) {
      String channel = (String)ctx.getArgument("channel", String.class);
      String message = (String)ctx.getArgument("message", String.class);
      class_2960 channelIdentifier = class_2960.method_60654(channel);
      ((FabricClientCommandSource)ctx.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &8[&5Channels&8] &cCommand not ready."));
      return 1;
   }

   private static int checkChannel(CommandContext<FabricClientCommandSource> ctx) {
      String channel = (String)ctx.getArgument("channel", String.class);
      Set<class_2960> openChannels = ClientPlayNetworking.getGlobalReceivers();
      if (openChannels.contains(class_2960.method_60654(channel))) {
         ((FabricClientCommandSource)ctx.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &8[&5Channels&8] &7Channel &d" + channel + " &7is &aopen&7."));
      } else {
         ((FabricClientCommandSource)ctx.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &8[&5Channels&8] &7Channel &d" + channel + " &cwasn't found&7."));
      }

      return 1;
   }
}
