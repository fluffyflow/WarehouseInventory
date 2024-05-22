package com.example.WarehouseInventory.outbound;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutboundService {


    @Autowired
    private OutboundRepository outboundRepo;

    private static final String SPECIAL_WORD = "OUT_";

    public List<Outbound> listAll(){
        return (List<Outbound>) outboundRepo.findAll();
    }


    @Transactional
    public void save(Outbound outbound) {
        // First save the entity to generate the ID
        Outbound savedOutbound = outboundRepo.save(outbound);

        // Format the ID to be zero-padded to three digits
        String formattedId = String.format("%03d", savedOutbound.getId());

        // Generate the reference using the formatted ID
        String ref = SPECIAL_WORD + formattedId;
        savedOutbound.setReference(ref);

        // Update the entity with the reference
        outboundRepo.save(savedOutbound);
    }

    public Outbound get(Integer id) throws OutboundNotFoundException {
        Optional<Outbound> result = outboundRepo.findById(id);

        if(result.isPresent()){
            return result.get();
        }
        throw new OutboundNotFoundException("Could not find any users with ID" +id);
    }

    public void delete(Integer id) throws OutboundNotFoundException{
        Long count = outboundRepo.countById(id);
        if(count == null || count == 0) {
            throw new OutboundNotFoundException("Could not find any users with ID" +id);
        }
        outboundRepo.deleteById(id);
    }

}
