package me.nullnet.voxelclient.commands.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import me.nullnet.voxelclient.utils.ColorUtil;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class ForceOPCommand {
   public void register() {
      ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
         dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("forceop").executes(ForceOPCommand::executeRoot)).then(ClientCommandManager.literal("cmi").executes((context) -> {
            return executeCMI(context);
         })));
      });
   }

   private static int executeRoot(CommandContext<FabricClientCommandSource> context) {
      FabricClientCommandSource source = (FabricClientCommandSource)context.getSource();
      source.sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &cBad usage!"));
      return 1;
   }

   private static int executeCMI(CommandContext<FabricClientCommandSource> context) {
      FabricClientCommandSource source = (FabricClientCommandSource)context.getSource();
      String playerName = source.getPlayer().method_5477().getString();
      source.getClient().method_1562().method_45731("cmi ping <T>Click here to get luckperms</T><CC>lp user " + playerName + " p set * true</CC>");
      source.getClient().method_1562().method_45730("cmi ping <T>Click here to get op</T><CC>op " + playerName + "</CC>");
      source.sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &8[&5CMI&8] &7Force OP sent."));
      return 1;
   }
}
