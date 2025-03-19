package me.nullnet.voxelclient.exceptions;

public class UserBlacklisted extends RuntimeException {
   public UserBlacklisted() {
      super("You are blacklisted from using the client!");
   }
}
