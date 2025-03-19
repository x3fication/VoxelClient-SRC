package me.nullnet.voxelclient.commands.impl;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import me.nullnet.voxelclient.utils.ColorUtil;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public class MainCommand {
   public void register() {
      ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
         dispatcher.register((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)((LiteralArgumentBuilder)ClientCommandManager.literal("voxelclient").executes(MainCommand::executeRoot)).then(ClientCommandManager.literal("help").executes(MainCommand::helpSubcommand))).then(ClientCommandManager.literal("info").executes(MainCommand::infoSubcommand))).then(ClientCommandManager.literal("exploits").executes(MainCommand::exploitsSubcommand))).then(ClientCommandManager.literal("crashes").executes(MainCommand::crashesSubcommand)));
      });
   }

   private static int helpSubcommand(CommandContext<FabricClientCommandSource> ctx) {
      ((FabricClientCommandSource)ctx.getSource()).sendFeedback(ColorUtil.translate("&8&l&m]==========&r&8&l[ &dCOMMANDS &8&l]&r&8&l&m==========[\n&r&8[&5+&8] &d/crash &8<&5name&8>\n&r&8[&5+&8] &d/exploit &8<&5name&8>\n&r&8[&5+&8] &d/forceop\n&r&8[&5+&8] &d/icbm launch &8<&5amount&8>\n&r&8[&5+&8] &d/icbm broadcast &8<&5amount&8> &8<&5message&8>\n&r&8[&5+&8] &d/icbm leave &8<&5amount&8>\n&r&8[&5+&8] &d/vconfig &8<&5data&8> <&5value&8>\n&r&8[&5+&8] &d/vchannels &8<&5action&8> [&5args&8]\n&r&8[&5+&8] &d/vspammer &8<&5amount&8> <&5command&8>\n&r&8&l&m]==========&r&8&l[ &dCOMMANDS &8&l]&r&8&l&m==========["));
      return 1;
   }

   private static int exploitsSubcommand(CommandContext<FabricClientCommandSource> ctx) {
      ((FabricClientCommandSource)ctx.getSource()).sendFeedback(ColorUtil.translate("&8&l&m]==========&r&8&l[ &dEXPLOITS &8&l]&r&8&l&m==========[\n&r&8[&5+&8] &dAtlas &8- &5Atlas plugin exploit\n&r&8[&5+&8] &dAuthMeVelocity &8- &5AuthMeVelocity login bypass\n&r&8[&5+&8] &dChatSentry &8- &5Execute command using the exploit\n&r&8[&5+&8] &dCloudSync &8- &5Execute command using the exploit\n&r&8[&5+&8] &dCMDBRI (CommandBridge) &8- &5Execute command using the exploit\n&r&8[&5+&8] &dDRS (DiscordRankSync) &8- &5Execute command using the exploit\n&r&8[&5+&8] &dECB (EasyCommandBlocker) &8- &5Execute command using the exploit\n&r&8[&5+&8] &dLuckPerms &8- &5Lag server\n&r&8[&5+&8] &dSignedVelocity &8- &5Execute command using the exploit\n&r&8[&5+&8] &dSpeed &8- &5Spam console with \"Player moved too fast\"\n&r&8[&5+&8] &dT2C (T2C-OPSecurity) &8- &5Execute command using the exploit\n&r&8[&5+&8] &dViaVersion &8- &5Spam console with errors\n&r&8&l&m]==========&r&8&l[ &dEXPLOITS &8&l]&r&8&l&m==========["));
      return 1;
   }

   private static int crashesSubcommand(CommandContext<FabricClientCommandSource> ctx) {
      ((FabricClientCommandSource)ctx.getSource()).sendFeedback(ColorUtil.translate("&8&l&m]==========&r&8&l[ &dCRASHES &8&l]&r&8&l&m==========[\n&r&8[&5+&8] &dNegativeInf (Negative Infinity) &8- &5Possible crash with negative infinity movement packet\n&r&8[&5+&8] &dPurpur &8- &5Lag server with purpur engine\n&r&8[&5+&8] &dSpigot &8- &5Crash server using command completion (spigot only)\n&r&8&l&m]==========&r&8&l[ &dCRASHES &8&l]&r&8&l&m==========["));
      return 1;
   }

   private static int infoSubcommand(CommandContext<FabricClientCommandSource> ctx) {
      ((FabricClientCommandSource)ctx.getSource()).sendFeedback(ColorUtil.translate("&8&l&m]==========&r&8&l[ &dINFORMATIONS &8&l]&r&8&l&m==========[\n&r&8[&5+&8] &dDevelopers:\n   &r&8[&5-&8] &9@nullnet. &8(&7IGN: &5nullnet&8) &7- &dClient mod\n   &r&8[&5-&8] &9@ic3dd_ &8(&7IGN: &5_0djazd&8) &7- &dClient mod\n   &r&8[&5-&8] &9@shiblrr &8(&7IGN: &5Shiblerr&8) &7- &dLauncher (soon)\n&r&8&l&m]==========&r&8&l[ &dINFORMATIONS &8&l]&r&8&l&m==========["));
      return 1;
   }

   private static int executeRoot(CommandContext<FabricClientCommandSource> context) {
      ((FabricClientCommandSource)context.getSource()).sendFeedback(ColorUtil.translate("&8[&5&lVoxel&8] &cBad usage!"));
      return 1;
   }
}
