package com.example.WarehouseInventory.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
//   @Query(value = "SELECT MAX(u.id) FROM User u")
//   String findLatestId();

//    default void generateAndSetId(User user) {
//        String latestId = findLatestId();
//        if (latestId == null) {
//            user.setId("U001"); // If no IDs exist yet, start with "U001"
//        } else {
//            user.generateId(latestId);
//        }
//    }
//
//    @Query("SELECT MAX(u.id) FROM User u")
//    String findLatestFormattedId();

    public Long countById(Integer id);

    Optional<User> findById(Integer id);

    void deleteById(Integer id);
}
