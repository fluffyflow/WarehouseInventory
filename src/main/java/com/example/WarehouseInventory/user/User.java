package com.example.WarehouseInventory.user;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 15, nullable = false, unique = true)
    private Integer id;

    @Column(length = 50,nullable = false,name = "user_name")
    private String name;

    @Column(length = 50)
    private String department;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(length = 15,nullable = false)
    private String password;

    private boolean enabled;



//    private String getLastestIdFromDatabase() {
//        // Logic to get the latest formatted ID from the database
//        // Assuming you have a method in your repository to find the maximum formatted ID
//        UserRepository repo = null;
//
//        return repo.findLatestFormattedId();
//    }
//
//    private String generateNewId(String latestId) {
//        if (latestId != null && latestId.matches("^U\\d+$")) {
//            int numericPart = Integer.parseInt(latestId.substring(1));
//            numericPart++;
//            return String.format("U%03d", numericPart);
//        } else {
//            return "U001";
//        }
//    }

//Ori
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//    public void generateId(String latestId) {
//        if (latestId != null) {
//            int numericPart = Integer.parseInt(latestId);
//            numericPart++;
//            String newId = String.format("%03d", numericPart);
//            this.id = newId;
//        } else {
//            // If latestId is null or does not match the expected format, set a default ID
//            this.id = "001";
//        }
//    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
