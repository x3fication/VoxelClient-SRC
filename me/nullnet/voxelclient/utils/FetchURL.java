package me.nullnet.voxelclient.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchURL {
   public static List<String> fetchURL(String url) {
      ArrayList lines = new ArrayList();

      try {
         URL link = new URL(url);
         BufferedReader reader = new BufferedReader(new InputStreamReader(link.openStream()));

         String line;
         while((line = reader.readLine()) != null) {
            lines.add(line);
         }

         reader.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      return lines;
   }
}
