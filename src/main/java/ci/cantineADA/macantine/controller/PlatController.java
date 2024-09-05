package ci.cantineADA.macantine.controller;


import ci.cantineADA.macantine.models.Menu;
import ci.cantineADA.macantine.models.Plat;
import ci.cantineADA.macantine.services.MenuService;
import ci.cantineADA.macantine.services.PlatService;
import ci.cantineADA.macantine.services.dto.MenuDTO;
import ci.cantineADA.macantine.services.dto.PlatDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/plats")
@RequiredArgsConstructor
public class PlatController {


    private static final Logger log = (Logger) LoggerFactory.getLogger(PlatController.class);
    private final PlatService platService;

    @GetMapping
    public String showPlatsList(org.springframework.ui.Model model) {
        List<PlatDTO> plats = platService.findAll();
        model.addAttribute("plats", plats);
        return "plats/plats";
    }


    @PostMapping
    public String savePlats(PlatDTO platDTO) {
        log.info("Saving plats: " + platDTO);
        platService.save(platDTO);
        return "redirect:/plats";
    }


    @GetMapping("/add")
    public String showAddPlatsForms(org.springframework.ui.Model model) {
        log.info("Showing add plats page");
        model.addAttribute("plats", new Plat());
        model.addAttribute("plats", platService.findAll());
        model.addAttribute("action", "add");
        return "menus/plats";
    }

    @GetMapping("/{id}")
    public String showUpdatePlatsForms(Model model, @PathVariable Long id) {
        log.info("Showing update menus page");
        Optional<PlatDTO> plats = platService.findOne(id);
        if (plats.isPresent()) {
            model.addAttribute("plats", plats.get());
            return "plats/plats";
        } else {

            return "redirect:/plats";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        log.info("Deleting plats with id: " + id);
        platService.delete(id);
        redirectAttributes.addFlashAttribute("message", "plats deleted successfully!");
        return "redirect:/plats";
    }
}




