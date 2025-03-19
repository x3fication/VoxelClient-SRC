package me.nullnet.voxelclient;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import me.nullnet.voxelclient.commands.CommandManager;
import me.nullnet.voxelclient.discord.RPC;
import me.nullnet.voxelclient.exceptions.UserBlacklisted;
import me.nullnet.voxelclient.utils.FetchURL;
import net.fabricmc.api.ModInitializer;
import net.minecraft.class_310;

public class Main implements ModInitializer {
   public static final String MOD_ID = "voxelclient";
   public static final String MOD_VERSION = "1.4.1";
   public static List<String> devs = FetchURL.fetchURL("https://raw.githubusercontent.com/nullnet0/configs/refs/heads/main/vc-devs.txt");
   public static List<String> betaTesters = FetchURL.fetchURL("https://raw.githubusercontent.com/nullnet0/configs/refs/heads/main/vc-beta.txt");
   public static boolean isDev = false;
   public static boolean isTester = false;
   public static boolean hudVisible = true;
   public static boolean hudEngineVisible = true;
   public static boolean hudPlayersVisible = true;
   public static boolean hudFPSVisible = true;
   public static boolean hudServerVisible = true;
   public static boolean devMode = true;
   public static boolean privateMode = false;
   public static String originalUsername = null;
   public static String originalUuid = null;
   public static final long startTime = Instant.now().getEpochSecond();
   public static boolean isPrivate = true;

   public void onInitialize() {
      originalUsername = class_310.method_1551().method_1548().method_1676();
      originalUuid = class_310.method_1551().method_1548().method_44717().toString();
      if (originalUuid == null) {
         originalUuid = UUID.nameUUIDFromBytes(("OfflinePlayer:" + originalUsername).getBytes(StandardCharsets.UTF_8)).toString();
      }

      List<String> blacklistedUsers = FetchURL.fetchURL("https://raw.githubusercontent.com/nullnet0/configs/refs/heads/main/vc-bl.txt");
      blacklistedUsers.forEach((uuid) -> {
         if (originalUuid.equals(uuid)) {
            throw new UserBlacklisted();
         }
      });
      if (devs.contains(originalUuid)) {
         isDev = true;
      }

      if (betaTesters.contains(originalUuid)) {
         isTester = true;
      }

      String isPrivateReturn = (String)FetchURL.fetchURL("https://raw.githubusercontent.com/nullnet0/configs/refs/heads/main/vc-status.txt").get(0);
      if (isPrivateReturn.equals("true")) {
         isPrivate = true;
      } else if (isPrivateReturn.equals("false")) {
         isPrivate = false;
      }

      if (isPrivate && !isDev && !isTester) {
      }

      CommandManager.registerCommands();
      System.out.println("[VoxelClient] Loaded Commands");
      RPC.initialize();
      System.out.println("[VoxelClient] VoxelRPC initialized.");
   }
}
