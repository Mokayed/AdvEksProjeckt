package persistence.impl;

import java.util.Date;
import persistence.admin.Admin;
import persistence.admin.AdminFactory;

public class AdminFactoryImpl implements AdminFactory {

    private static AdminFactory instance;

    private AdminFactoryImpl() {
    }

    @Override
    public Admin newAdmin(String firstName, String lastName, String role, String longitude, String latitude) {
        return new AdminImpl(firstName, lastName, role, longitude, latitude);
    }

    public static AdminFactory getInstance() {
        if (instance == null) {
            instance = new AdminFactoryImpl();
        }
        return instance;
    }

    private static class AdminImpl implements Admin {

        private final String firstName;
        private final String lastName;
        private final String role;
        private final String longitude;
        private final String latitude;

        public AdminImpl(String firstName, String lastName, String role, String longitude, String latitude) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = role;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getRole() {
            return role;
        }

        public String getLongitude() {
            return longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        @Override
        public String toString() {
            return "AdminImpl{" + "firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", longitude=" + longitude + ", latitude=" + latitude + '}';
        }

    }
}
