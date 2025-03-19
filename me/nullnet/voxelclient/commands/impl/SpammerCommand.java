package me.nullnet.voxelclient.commands.impl;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import me.nullnet.voxelclient.utils.ColorUtil;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class SpammerCommand {
   public void register() {
      ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
         dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("vspammer").executes(SpammerCommand::executeRoot)).then(((RequiredArgumentBuilder)ClientCommandManager.argument("times", IntegerArgumentType.integer()).executes(SpammerCommand::executeRoot)).then(ClientCommandManager.argument("cmd", StringArgumentType.greedyString()).executes(SpammerCommand::execute))));
      });
   }

   private static int executeRoot(CommandContext<FabricClientCommandSource> context) {
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &cBad usage!"));
      return 1;
   }

   private static int execute(CommandContext<FabricClientCommandSource> context) {
      int amount = IntegerArgumentType.getInteger(context, "times");
      String cmd = StringArgumentType.getString(context, "cmd");

      for(int i = 0; i < amount; ++i) {
         ((FabricClientCommandSource)context.getSource()).getClient().method_1562().method_45730(cmd);
      }

      return 1;
   }
}
