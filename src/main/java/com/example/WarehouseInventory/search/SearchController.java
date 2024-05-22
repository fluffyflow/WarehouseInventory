package com.example.WarehouseInventory.search;

import com.example.WarehouseInventory.inbound.Inbound;
import com.example.WarehouseInventory.inbound.InboundRepository;
import com.example.WarehouseInventory.outbound.Outbound;
import com.example.WarehouseInventory.outbound.OutboundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private InboundRepository inboundRepo;

    @Autowired
    private OutboundRepository outboundRepo;

@GetMapping("/search")
public String mainSearch(){
    return "search";
}

    @GetMapping("/query")
    public String searchResult(@RequestParam(name="query", required = false) String query, Model model) {
        // Initialize lists to hold search results
        List<Inbound> inbounds = new ArrayList<>();
        List<Outbound> outbounds = new ArrayList<>();

        // Search for inbounds and outbounds only if query parameter is provided
        if (query != null && !query.isEmpty()) {
            inbounds = inboundRepo.findByReferenceContaining(query);
            outbounds = outboundRepo.findByReferenceContaining(query);
        }

        // Add attributes to the model
        model.addAttribute("query", query);
        model.addAttribute("inbounds", inbounds);
        model.addAttribute("outbounds", outbounds);

        // Return the search results view
        return "searchResult";
    }
}
