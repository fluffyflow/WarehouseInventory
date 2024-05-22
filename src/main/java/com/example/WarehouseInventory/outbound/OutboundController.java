package com.example.WarehouseInventory.outbound;

import com.example.WarehouseInventory.user.User;
import com.example.WarehouseInventory.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OutboundController {

    @Autowired
    private OutboundService service;

    @GetMapping("/outbound")
    public String outboundList (Model model) {
        List<Outbound> listOutbound = service.listAll();
        model.addAttribute("listOutbound",listOutbound);
        return "outbound";
    }

    @GetMapping("/outbound/new")
    public String showNewForm(Model model){
        model.addAttribute("outbound", new Outbound());
        model.addAttribute("pageTitle", "Add Outbound");
        return "outbound_form";
    }

    @PostMapping("/outbound/save")
    public String saveOutbound(Outbound outbound, RedirectAttributes ra){
        service.save(outbound);
        ra.addFlashAttribute("message","The outbound is successfully saved");
        return "redirect:/outbound";
    }

    @GetMapping("/outbound/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes ra){
        try {
            Outbound outbound = service.get(id);
            model.addAttribute("outbound", outbound);
            model.addAttribute("pageTitle", "Edit Outbound (ID: " +id+")");
            return "outbound_form";
        } catch (OutboundNotFoundException e) {
            ra.addFlashAttribute("message","The outbound have been save succesfully");
            return "redirect:/outbound";
        }
    }

    @GetMapping("/outbound/delete/{id}")
    public String deleteUser(@PathVariable Integer id,RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message","The outbound ID " + id + " was successfully deleted");
        } catch (OutboundNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/outbound";
    }

}
