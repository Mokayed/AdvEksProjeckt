package persistence.admin;



public interface AdminFactory {
      public Admin newAdmin(String firstName, String lastName, String role, String longitude, String latitude);
}
