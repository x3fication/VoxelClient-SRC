package me.nullnet.voxelclient.discord;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import me.nullnet.voxelclient.Main;
import net.minecraft.class_310;

public class RPC {
   public static boolean isInitialized = false;

   public static void initialize() {
      System.out.println("Starting Discord IPC");
      if (!DiscordIPC.start(1305575005005807636L, () -> {
         System.out.println("Logged in account: " + DiscordIPC.getUser().username);
      })) {
         System.out.println("Failed to start Discord IPC");
      } else {
         setPresence();
         isInitialized = true;
         (new Timer()).scheduleAtFixedRate(new TimerTask() {
            public void run() {
               RPC.setPresence();
            }
         }, 0L, 5000L);
      }
   }

   private static void setPresence() {
      if (class_310.method_1551().method_1558() != null) {
         int maxPlayers = class_310.method_1551().method_1558() != null ? (class_310.method_1551().method_1558().field_41861 != null ? class_310.method_1551().method_1558().field_41861.comp_1279() : 1) : 1;
         int onlinePlayers = class_310.method_1551().method_1558() != null ? (class_310.method_1551().method_1558().field_41861 != null ? class_310.method_1551().method_1558().field_41861.comp_1280() : 1) : 1;
         RichPresence presence = new RichPresence();
         presence.setStart(Main.startTime);
         presence.setDetails("Version: 1.4.1");
         presence.setLargeImage("logo", "VoxelClient");
         presence.setState("In a server");
         presence.setPartySize(onlinePlayers, maxPlayers);
         if (DiscordIPC.getUser() != null && DiscordIPC.getUser().id != null) {
            if (Objects.equals(DiscordIPC.getUser().id, "1181840393927663697") || Objects.equals(DiscordIPC.getUser().id, "568416069669093406")) {
               presence.setSmallImage("dev_icon", "Developer");
            }

            if (Objects.equals(DiscordIPC.getUser().id, "771846347862179870")) {
               presence.setSmallImage("uwu_icon", "Best boyfriend in the world :3");
            }
         }

         DiscordIPC.setActivity(presence);
      } else {
         RichPresence presence = new RichPresence();
         presence.setStart(Main.startTime);
         presence.setDetails("Version: 1.4.1");
         presence.setLargeImage("logo", "VoxelClient");
         presence.setState("Somewhere else");
         if (DiscordIPC.getUser() != null && DiscordIPC.getUser().id != null) {
            if (Objects.equals(DiscordIPC.getUser().id, "1181840393927663697") || Objects.equals(DiscordIPC.getUser().id, "568416069669093406")) {
               presence.setSmallImage("dev_icon", "Developer");
            }

            if (Objects.equals(DiscordIPC.getUser().id, "771846347862179870")) {
               presence.setSmallImage("uwu_icon", "Best girlfriend in the world :3");
            }
         }

         DiscordIPC.setActivity(presence);
      }

   }

   public static void shutdown() {
      System.out.println("Stopping Discord IPC");
      DiscordIPC.stop();
      isInitialized = false;
   }
}
