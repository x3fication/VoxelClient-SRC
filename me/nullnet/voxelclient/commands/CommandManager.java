package me.nullnet.voxelclient.commands;

import me.nullnet.voxelclient.commands.impl.ChannelsCommand;
import me.nullnet.voxelclient.commands.impl.ConfigCommand;
import me.nullnet.voxelclient.commands.impl.CrashCommand;
import me.nullnet.voxelclient.commands.impl.ExploitCommand;
import me.nullnet.voxelclient.commands.impl.ForceOPCommand;
import me.nullnet.voxelclient.commands.impl.MainCommand;
import me.nullnet.voxelclient.commands.impl.SpammerCommand;

public class CommandManager {
   public static void registerCommands() {
      CrashCommand crashCommand = new CrashCommand();
      crashCommand.register();
      ForceOPCommand forceOPCommand = new ForceOPCommand();
      forceOPCommand.register();
      ExploitCommand exploitCommand = new ExploitCommand();
      exploitCommand.register();
      MainCommand mainCommand = new MainCommand();
      mainCommand.register();
      ConfigCommand configCommand = new ConfigCommand();
      configCommand.register();
      ChannelsCommand channelsCommand = new ChannelsCommand();
      channelsCommand.register();
      SpammerCommand spammerCommand = new SpammerCommand();
      spammerCommand.register();
   }
}
