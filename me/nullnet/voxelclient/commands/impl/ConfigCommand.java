package me.nullnet.voxelclient.commands.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import me.nullnet.voxelclient.Main;
import me.nullnet.voxelclient.discord.RPC;
import me.nullnet.voxelclient.utils.ColorUtil;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class ConfigCommand {
   public void register() {
      ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
         dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("vconfig").executes(ConfigCommand::executeRoot)).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("hud.visible").executes(ConfigCommand::executeRoot)).then(ClientCommandManager.literal("false").executes(ConfigCommand::hudVisibleFalse))).then(ClientCommandManager.literal("true").executes(ConfigCommand::hudVisibleTrue)))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("hud.server.visible").executes(ConfigCommand::executeRoot)).then(ClientCommandManager.literal("false").executes(ConfigCommand::hudServerVisibleFalse))).then(ClientCommandManager.literal("true").executes(ConfigCommand::hudServerVisibleTrue)))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("hud.fps.visible").executes(ConfigCommand::executeRoot)).then(ClientCommandManager.literal("false").executes(ConfigCommand::hudFPSVisibleFalse))).then(ClientCommandManager.literal("true").executes(ConfigCommand::hudFPSVisibleTrue)))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("hud.players.visible").executes(ConfigCommand::executeRoot)).then(ClientCommandManager.literal("false").executes(ConfigCommand::hudPlayersVisibleFalse))).then(ClientCommandManager.literal("true").executes(ConfigCommand::hudPlayersVisibleTrue)))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("hud.engine.visible").executes(ConfigCommand::executeRoot)).then(ClientCommandManager.literal("false").executes(ConfigCommand::hudEngineVisibleFalse))).then(ClientCommandManager.literal("true").executes(ConfigCommand::hudEngineVisibleTrue)))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("rpc").executes(ConfigCommand::executeRoot)).then(ClientCommandManager.literal("false").executes(ConfigCommand::rpcFalse))).then(ClientCommandManager.literal("true").executes(ConfigCommand::rpcTrue)))).then(((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("devmode").executes(ConfigCommand::executeRoot)).then(ClientCommandManager.literal("false").executes(ConfigCommand::devmodeFalse))).then(ClientCommandManager.literal("true").executes(ConfigCommand::devmodeTrue))));
      });
   }

   private static int executeRoot(CommandContext<FabricClientCommandSource> context) {
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &cBad usage!"));
      return 1;
   }

   private static int hudVisibleFalse(CommandContext<FabricClientCommandSource> context) {
      Main.hudVisible = false;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.visible&7 to &cfalse&7."));
      return 1;
   }

   private static int hudVisibleTrue(CommandContext<FabricClientCommandSource> context) {
      Main.hudVisible = true;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.visible&7 to &atrue&7."));
      return 1;
   }

   private static int hudServerVisibleFalse(CommandContext<FabricClientCommandSource> context) {
      Main.hudServerVisible = false;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.server.visible&7 to &cfalse&7."));
      return 1;
   }

   private static int hudServerVisibleTrue(CommandContext<FabricClientCommandSource> context) {
      Main.hudServerVisible = true;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.server.visible&7 to &atrue&7."));
      return 1;
   }

   private static int hudFPSVisibleFalse(CommandContext<FabricClientCommandSource> context) {
      Main.hudFPSVisible = false;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.fps.visible&7 to &cfalse&7."));
      return 1;
   }

   private static int hudFPSVisibleTrue(CommandContext<FabricClientCommandSource> context) {
      Main.hudFPSVisible = true;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.fps.visible&7 to &atrue&7."));
      return 1;
   }

   private static int hudPlayersVisibleFalse(CommandContext<FabricClientCommandSource> context) {
      Main.hudPlayersVisible = false;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.players.visible&7 to &cfalse&7."));
      return 1;
   }

   private static int hudPlayersVisibleTrue(CommandContext<FabricClientCommandSource> context) {
      Main.hudPlayersVisible = true;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.players.visible&7 to &atrue&7."));
      return 1;
   }

   private static int hudEngineVisibleFalse(CommandContext<FabricClientCommandSource> context) {
      Main.hudEngineVisible = false;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.engine.visible&7 to &cfalse&7."));
      return 1;
   }

   private static int hudEngineVisibleTrue(CommandContext<FabricClientCommandSource> context) {
      Main.hudEngineVisible = true;
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &dhud.engine.visible&7 to &atrue&7."));
      return 1;
   }

   private static int rpcFalse(CommandContext<FabricClientCommandSource> context) {
      if (RPC.isInitialized) {
         RPC.shutdown();
         ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &7Successfully set &drpc&7 to &cfalse&7."));
      } else {
         ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &cRPC is already off!"));
      }

      return 1;
   }

   private static int rpcTrue(CommandContext<FabricClientCommandSource> context) {
      if (!RPC.isInitialized) {
         RPC.initialize();
         ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &7Successfully set &drpc&7 to &atrue&7."));
      } else {
         ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &cRPC is already initialized!"));
      }

      return 1;
   }

   private static int devmodeTrue(CommandContext<FabricClientCommandSource> context) {
      if (!Main.isDev) {
         ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &cYou are not a developer of the client."));
         return 1;
      } else {
         Main.devMode = true;
         ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &ddevmode&7 to &atrue&7."));
         return 1;
      }
   }

   private static int devmodeFalse(CommandContext<FabricClientCommandSource> context) {
      if (!Main.isDev) {
         ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &cYou are not a developer of the client."));
         return 1;
      } else {
         Main.devMode = false;
         ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] [&5Config&8] &7Successfully set &ddevmode&7 to &cfalse&7."));
         return 1;
      }
   }
}
