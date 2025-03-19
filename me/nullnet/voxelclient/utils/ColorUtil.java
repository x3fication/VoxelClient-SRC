package me.nullnet.voxelclient.utils;

import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_2583;

public class ColorUtil {
   public static class_2561 translate(String input) {
      StringBuilder builder = new StringBuilder();

      for(int i = 0; i < input.length(); ++i) {
         char currentChar = input.charAt(i);
         if (currentChar == '&' && i + 1 < input.length()) {
            char colorChar = input.charAt(i + 1);
            class_124 color = getColorFromCode(colorChar);
            if (color != null) {
               builder.append(color);
               ++i;
            }
         } else {
            builder.append(currentChar);
         }
      }

      return class_2561.method_43470(builder.toString()).method_10862(class_2583.field_24360);
   }

   private static class_124 getColorFromCode(char colorChar) {
      switch(colorChar) {
      case '0':
         return class_124.field_1074;
      case '1':
         return class_124.field_1058;
      case '2':
         return class_124.field_1077;
      case '3':
         return class_124.field_1062;
      case '4':
         return class_124.field_1079;
      case '5':
         return class_124.field_1064;
      case '6':
         return class_124.field_1065;
      case '7':
         return class_124.field_1080;
      case '8':
         return class_124.field_1063;
      case '9':
         return class_124.field_1078;
      case ':':
      case ';':
      case '<':
      case '=':
      case '>':
      case '?':
      case '@':
      case 'A':
      case 'B':
      case 'C':
      case 'D':
      case 'E':
      case 'F':
      case 'G':
      case 'H':
      case 'I':
      case 'J':
      case 'K':
      case 'L':
      case 'M':
      case 'N':
      case 'O':
      case 'P':
      case 'Q':
      case 'R':
      case 'S':
      case 'T':
      case 'U':
      case 'V':
      case 'W':
      case 'X':
      case 'Y':
      case 'Z':
      case '[':
      case '\\':
      case ']':
      case '^':
      case '_':
      case '`':
      case 'g':
      case 'h':
      case 'i':
      case 'j':
      case 'o':
      case 'p':
      case 'q':
      default:
         return null;
      case 'a':
         return class_124.field_1060;
      case 'b':
         return class_124.field_1075;
      case 'c':
         return class_124.field_1061;
      case 'd':
         return class_124.field_1076;
      case 'e':
         return class_124.field_1054;
      case 'f':
         return class_124.field_1068;
      case 'k':
         return class_124.field_1051;
      case 'l':
         return class_124.field_1067;
      case 'm':
         return class_124.field_1056;
      case 'n':
         return class_124.field_1073;
      case 'r':
         return class_124.field_1070;
      }
   }
}
