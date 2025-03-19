package me.nullnet.voxelclient.client.screens;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_339;
import net.minecraft.class_4185;
import net.minecraft.class_433;
import net.minecraft.class_437;
import net.minecraft.class_5244;
import net.minecraft.class_641;
import net.minecraft.class_642;
import net.minecraft.class_7842;
import net.minecraft.class_7843;
import net.minecraft.class_7845;
import net.minecraft.class_4185.class_4241;
import net.minecraft.class_4185.class_7840;
import net.minecraft.class_7845.class_7939;

public class GameMenuExtrasScreen extends class_437 {
   private static final class_2561 GAME_TEXT = class_2561.method_43471("menu.game");
   private static final class_2561 COPY_IP_TEXT = class_2561.method_30163("Copy IP");
   private static final class_2561 LEAVE_AND_DELETE_TEXT = class_2561.method_30163("Disconnect & Delete");
   public final class_433 parent;

   public GameMenuExtrasScreen(class_433 parent) {
      super(GAME_TEXT);
      this.parent = parent;
   }

   protected void method_25426() {
      class_7845 gW = new class_7845();
      gW.method_46458().method_46466(4, 4, 4, 0);
      class_7939 adder = gW.method_47610(2);
      this.addWideButton(adder, class_5244.field_24339, (button) -> {
         this.field_22787.method_1507(this.parent);
      }, gW, true);
      this.addWideButton(adder, COPY_IP_TEXT, (button) -> {
         this.field_22787.field_1774.method_1455(this.field_22787.method_1558().field_3761);
      }, gW, false);
      this.addWideButton(adder, LEAVE_AND_DELETE_TEXT, (button) -> {
         String currentServerAddress = this.field_22787.method_1558().field_3761;
         class_641 serverList = new class_641(this.field_22787);
         serverList.method_2981();

         try {
            Field serversField = class_641.class.getDeclaredField("servers");
            serversField.setAccessible(true);
            List<class_642> servers = (List)serversField.get(serverList);
            servers.removeIf((server) -> {
               return server.field_3761.equals(currentServerAddress);
            });
            serverList.method_2987();
         } catch (Exception var6) {
            var6.printStackTrace();
         }

         this.field_22787.method_18099();
      }, gW, false);
      gW.method_48222();
      class_7843.method_46443(gW, 0, 0, this.field_22789, this.field_22790, 0.5F, 0.25F);
      gW.method_48206((x$0) -> {
         class_339 var10000 = (class_339)this.method_37063(x$0);
      });
      int var10005 = this.field_22789;
      Objects.requireNonNull(this.field_22793);
      this.method_37063(new class_7842(0, 40, var10005, 9, this.field_22785, this.field_22793));
   }

   private void addButton(class_7939 adder, class_2561 message, class_4241 onPress) {
      adder.method_47612((new class_7840(message, onPress)).method_46432(98).method_46431());
   }

   private void addWideButton(class_7939 adder, class_2561 message, class_4241 onPress, class_7845 gridWidget, boolean marginTop) {
      class_4185 widget = (new class_7840(message, onPress)).method_46432(204).method_46431();
      if (marginTop) {
         adder.method_47614(widget, 2, gridWidget.method_46457().method_46471(50));
      } else {
         adder.method_47613(widget, 2);
      }

   }

   public void method_25419() {
      this.field_22787.method_1507(this.parent);
   }

   public boolean method_25404(int keyCode, int scanCode, int modifiers) {
      return class_437.method_25438(keyCode) && copyServerIP() ? true : super.method_25404(keyCode, scanCode, modifiers);
   }

   public static boolean copyServerIP() {
      class_642 serverEntry = class_310.method_1551().method_1558();
      if (serverEntry != null) {
         class_310.method_1551().field_1774.method_1455(serverEntry.field_3761);
         return true;
      } else {
         return false;
      }
   }
}
