package com.example.WarehouseInventory.outbound;

import com.example.WarehouseInventory.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OutboundRepository extends CrudRepository<Outbound, Integer> {

    public Long countById(Integer id);

    Optional<Outbound> findById(Integer id);

    void deleteById(Integer id);

    List<Outbound> findByReferenceContaining(String reference);

}
