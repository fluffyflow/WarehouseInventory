package com.example.WarehouseInventory.inbound;

import com.example.WarehouseInventory.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface InboundRepository  extends JpaRepository<Inbound, Integer> {

    public Long countById(Integer id);

    Optional<Inbound> findById(Integer id);

    void deleteById(Integer id);

    List<Inbound> findByReferenceContaining(String reference);
}
