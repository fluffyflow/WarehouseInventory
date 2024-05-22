package com.example.WarehouseInventory.inbound;

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
public class InboundController {

    @Autowired
    private InboundService service;

    @GetMapping("/inbound")
    public String showInboundList(Model model) {
        List<Inbound> listInbound = service.listAll();
        model.addAttribute("listInbound", listInbound);
        return "inbound";
    }

    @GetMapping("/inbound/new")
    public String showInboundNew(Model model) {
        model.addAttribute("inbound", new Inbound());
        model.addAttribute("pageTitle", "Add New Inbound");
        return "inbound_form";
    }

    @PostMapping("/inbound/save")
    public String saveInbound(Inbound inbound, RedirectAttributes ra) {
        service.save(inbound);
        ra.addFlashAttribute("message", "Successfully saved inbound");
        return "redirect:/inbound";
    }

    @GetMapping("/inbound/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes ra){
        try {
            Inbound inbound = service.get(id);
            model.addAttribute("inbound", inbound);
            model.addAttribute("pageTitle", "Edit User (ID: " +id+")");
            return "inbound_form";
        } catch (InboundNotFoundException e) {
            ra.addFlashAttribute("message","The user have been save succesfully");
            return "redirect:/inbound";
        }
    }

    @GetMapping("/inbound/delete/{id}")
    public String deleteUser(@PathVariable Integer id,RedirectAttributes ra){
        try {
            service.delete(id);
            ra.addFlashAttribute("message","The inbound ID " + id + " was successfully deleted");
        } catch (InboundNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/inbound";
    }
}
