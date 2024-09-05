package ci.cantineADA.macantine.controller;

import ci.cantineADA.macantine.models.Menu;
import ci.cantineADA.macantine.services.MenuService;
import ci.cantineADA.macantine.services.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/menus")
@RequiredArgsConstructor
public class MenuController {

    private static final Logger log = LoggerFactory.getLogger(MenuController.class);
    private final MenuService menuService;

    @GetMapping
    public String showMenusList(org.springframework.ui.Model model) {
        List<MenuDTO> menus = menuService.findAll();
        model.addAttribute("menus", menus);
        return "menus/menus";
    }


    @PostMapping
    public String saveMenu(MenuDTO menuDTO) {
        log.info("Saving menu: " + menuDTO);
        menuService.save(menuDTO);
        return "redirect:/menus";
    }


    @GetMapping("/add")
    public String showAddMenuForms(org.springframework.ui.Model model) {
        log.info("Showing add menu page");
        model.addAttribute("menus", new Menu());
        model.addAttribute("menus", menuService.findAll());
        model.addAttribute("action", "add");
        return "menus/forms";
    }

    @GetMapping("/{id}")
    public String showUpdateMenuForms(Model model, @PathVariable Long id) {
        log.info("Showing update menus page");
        Optional<MenuDTO> menus = menuService.findOne(id);
        if (menus.isPresent()) {
            model.addAttribute("student", menus.get());
            return "menus/menus";
        } else {

            return "redirect:/menus";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        log.info("Deleting menus with id: " + id);
        menuService.delete(id);
        redirectAttributes.addFlashAttribute("message", "menus deleted successfully!");
        return "redirect:/students";
    }
}
