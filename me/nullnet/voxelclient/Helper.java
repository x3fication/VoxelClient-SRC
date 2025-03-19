package me.nullnet.voxelclient;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import net.minecraft.class_124;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_310;
import net.minecraft.class_5250;
import net.minecraft.class_634;
import net.minecraft.class_2558.class_2559;

public class Helper {
   public static Color getChroma(int delay, float saturation, float brightness) {
      double chroma = Math.ceil((double)(System.currentTimeMillis() + (long)delay) / 20.0D);
      chroma %= 360.0D;
      return Color.getHSBColor((float)(chroma / 360.0D), saturation, brightness);
   }

   public static String appendPrefix(String text) {
      return "&8[&5&lVoxel&8] &r" + text;
   }

   public static boolean isNumber(String s) {
      try {
         Double.parseDouble(s);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      }
   }

   public static void sendPacket(class_2596<?> packet) {
      ((class_634)Objects.requireNonNull(class_310.method_1551().method_1562())).method_52787(packet);
   }

   public static class_2561 parseColoredText(String message) {
      return parseColoredText(message, (String)null);
   }

   public static class_2561 parseColoredText(String message, String copyMessage) {
      class_5250 text = class_2561.method_43470("");
      String[] parts = message.split("(?=&)");
      List<class_124> currentFormats = new ArrayList();
      String[] var5 = parts;
      int var6 = parts.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String part = var5[var7];
         if (!part.isEmpty()) {
            if (part.startsWith("&")) {
               currentFormats.add(getColorFromCode(part.substring(0, 2)));
               String remaining = part.substring(2);
               if (!remaining.isEmpty()) {
                  class_5250 formattedText = class_2561.method_43470(remaining);

                  class_124 format;
                  for(Iterator var15 = currentFormats.iterator(); var15.hasNext(); formattedText = formattedText.method_27692(format)) {
                     format = (class_124)var15.next();
                  }

                  text.method_10852(formattedText);
               }
            } else {
               class_5250 unformattedText = class_2561.method_43470(part);

               class_124 format;
               for(Iterator var10 = currentFormats.iterator(); var10.hasNext(); unformattedText = unformattedText.method_27692(format)) {
                  format = (class_124)var10.next();
               }

               text.method_10852(unformattedText);
            }
         }
      }

      if (copyMessage != null && !copyMessage.isEmpty()) {
         text.method_10862(text.method_10866().method_10958(new class_2558(class_2559.field_21462, copyMessage)));
      }

      return text;
   }

   private static class_124 getColorFromCode(String code) {
      byte var2 = -1;
      switch(code.hashCode()) {
      case 1226:
         if (code.equals("&0")) {
            var2 = 0;
         }
         break;
      case 1227:
         if (code.equals("&1")) {
            var2 = 1;
         }
         break;
      case 1228:
         if (code.equals("&2")) {
            var2 = 2;
         }
         break;
      case 1229:
         if (code.equals("&3")) {
            var2 = 3;
         }
         break;
      case 1230:
         if (code.equals("&4")) {
            var2 = 4;
         }
         break;
      case 1231:
         if (code.equals("&5")) {
            var2 = 5;
         }
         break;
      case 1232:
         if (code.equals("&6")) {
            var2 = 6;
         }
         break;
      case 1233:
         if (code.equals("&7")) {
            var2 = 7;
         }
         break;
      case 1234:
         if (code.equals("&8")) {
            var2 = 8;
         }
         break;
      case 1235:
         if (code.equals("&9")) {
            var2 = 9;
         }
      case 1236:
      case 1237:
      case 1238:
      case 1239:
      case 1240:
      case 1241:
      case 1242:
      case 1243:
      case 1244:
      case 1245:
      case 1246:
      case 1247:
      case 1248:
      case 1249:
      case 1250:
      case 1251:
      case 1252:
      case 1253:
      case 1254:
      case 1255:
      case 1256:
      case 1257:
      case 1258:
      case 1259:
      case 1260:
      case 1261:
      case 1262:
      case 1263:
      case 1264:
      case 1265:
      case 1266:
      case 1267:
      case 1268:
      case 1269:
      case 1270:
      case 1271:
      case 1272:
      case 1273:
      case 1274:
      case 1281:
      case 1282:
      case 1283:
      case 1284:
      default:
         break;
      case 1275:
         if (code.equals("&a")) {
            var2 = 10;
         }
         break;
      case 1276:
         if (code.equals("&b")) {
            var2 = 11;
         }
         break;
      case 1277:
         if (code.equals("&c")) {
            var2 = 12;
         }
         break;
      case 1278:
         if (code.equals("&d")) {
            var2 = 13;
         }
         break;
      case 1279:
         if (code.equals("&e")) {
            var2 = 14;
         }
         break;
      case 1280:
         if (code.equals("&f")) {
            var2 = 15;
         }
         break;
      case 1285:
         if (code.equals("&k")) {
            var2 = 16;
         }
         break;
      case 1286:
         if (code.equals("&l")) {
            var2 = 17;
         }
         break;
      case 1287:
         if (code.equals("&m")) {
            var2 = 18;
         }
         break;
      case 1288:
         if (code.equals("&n")) {
            var2 = 19;
         }
         break;
      case 1289:
         if (code.equals("&o")) {
            var2 = 20;
         }
      }

      class_124 var10000;
      switch(var2) {
      case 0:
         var10000 = class_124.field_1074;
         break;
      case 1:
         var10000 = class_124.field_1058;
         break;
      case 2:
         var10000 = class_124.field_1077;
         break;
      case 3:
         var10000 = class_124.field_1062;
         break;
      case 4:
         var10000 = class_124.field_1079;
         break;
      case 5:
         var10000 = class_124.field_1064;
         break;
      case 6:
         var10000 = class_124.field_1065;
         break;
      case 7:
         var10000 = class_124.field_1080;
         break;
      case 8:
         var10000 = class_124.field_1063;
         break;
      case 9:
         var10000 = class_124.field_1078;
         break;
      case 10:
         var10000 = class_124.field_1060;
         break;
      case 11:
         var10000 = class_124.field_1075;
         break;
      case 12:
         var10000 = class_124.field_1061;
         break;
      case 13:
         var10000 = class_124.field_1076;
         break;
      case 14:
         var10000 = class_124.field_1054;
         break;
      case 15:
         var10000 = class_124.field_1068;
         break;
      case 16:
         var10000 = class_124.field_1051;
         break;
      case 17:
         var10000 = class_124.field_1067;
         break;
      case 18:
         var10000 = class_124.field_1055;
         break;
      case 19:
         var10000 = class_124.field_1073;
         break;
      case 20:
         var10000 = class_124.field_1056;
         break;
      default:
         var10000 = class_124.field_1070;
      }

      return var10000;
   }

   public static String capitalizeFirstLetter(String str) {
      if (str != null && !str.isEmpty()) {
         String var10000 = str.substring(0, 1).toUpperCase();
         return var10000 + str.substring(1);
      } else {
         return str;
      }
   }

   public static String generateRandomString(int length, String characters, Random random) {
      StringBuilder result = new StringBuilder(length);

      for(int i = 0; i < length; ++i) {
         result.append(characters.charAt(random.nextInt(characters.length())));
      }

      return result.toString();
   }

   public static String getLatestReleaseTag() throws IOException {
      String apiUrl = "https://api.github.com/repos/nullnet0/VoxelClient/releases/latest";
      HttpURLConnection connection = (HttpURLConnection)(new URL(apiUrl)).openConnection();
      connection.setRequestProperty("Accept", "application/vnd.github.v3+json");
      connection.setRequestMethod("GET");
      if (connection.getResponseCode() != 200) {
         return null;
      } else {
         BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
         StringBuilder response = new StringBuilder();

         String line;
         while((line = reader.readLine()) != null) {
            response.append(line);
         }

         reader.close();
         JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
         return jsonResponse.get("tag_name").getAsString();
      }
   }

   public static JsonObject generateJsonObject(int levels) {
      JsonObject jsonObject = new JsonObject();
      if (levels > 0) {
         jsonObject.add("a", generateJsonObject(levels - 1));
      }

      return jsonObject;
   }

   public static void sendMessage(String message) {
      class_310.method_1551().method_1562().method_45729(message);
   }

   public static void sendCommand(String command) {
      class_310.method_1551().method_1562().method_45730(command);
   }

   public static class ByteArrayOutput {
      private final ByteArrayDataOutput out = ByteStreams.newDataOutput();

      public ByteArrayOutput() {
      }

      public ByteArrayOutput(byte[] bytes) {
         this.out.write(bytes);
      }

      public ByteArrayDataOutput getBuf() {
         return this.out;
      }

      public byte[] toByteArray() {
         return this.out.toByteArray();
      }
   }
}
