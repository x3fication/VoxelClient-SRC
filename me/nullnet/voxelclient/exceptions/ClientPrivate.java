package me.nullnet.voxelclient.exceptions;

public class ClientPrivate extends RuntimeException {
   public ClientPrivate() {
      super("You do not have permission to access this client.");
   }
}
