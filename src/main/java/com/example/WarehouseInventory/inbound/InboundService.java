package com.example.WarehouseInventory.inbound;

import com.example.WarehouseInventory.outbound.Outbound;
import com.example.WarehouseInventory.outbound.OutboundNotFoundException;
import com.example.WarehouseInventory.outbound.OutboundRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InboundService {

    @Autowired
    private InboundRepository inboundRepo;

    private static final String SPECIAL_WORD = "IN_";

    public List<Inbound> listAll() {
        return (List<Inbound>) inboundRepo.findAll();
    }


    @Transactional
    public void save(Inbound inbound) {
        // First save the entity to generate the ID
        Inbound savedInbound = inboundRepo.save(inbound);

        // Format the ID to be zero-padded to three digits
        String formattedId = String.format("%03d", savedInbound.getId());

        // Generate the reference using the formatted ID
        String ref = SPECIAL_WORD + formattedId;
        savedInbound.setReference(ref);

        // Update the entity with the reference
        inboundRepo.save(savedInbound);
    }

    public Inbound get(Integer id) throws InboundNotFoundException {
        Optional<Inbound> result = inboundRepo.findById(id);

        if (result.isPresent()) {
            return result.get();
        }
        throw new InboundNotFoundException("Could not find any inbound with ID" + id);
    }

    public void delete(Integer id) throws InboundNotFoundException {
        Long count = inboundRepo.countById(id);
        if (count == null || count == 0) {
            throw new InboundNotFoundException("Could not find any users with ID" + id);
        }
        inboundRepo.deleteById(id);
    }

}