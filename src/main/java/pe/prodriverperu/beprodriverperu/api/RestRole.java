package pe.prodriverperu.beprodriverperu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.prodriverperu.beprodriverperu.business.BusinessRole;
import pe.prodriverperu.beprodriverperu.business.BusinessUsers;
import pe.prodriverperu.beprodriverperu.entities.Role;

import java.util.List;

@Controller
@SessionAttributes
@RequestMapping("/roles")
public class RestRole {
    @Autowired
    private BusinessUsers uService;
    @Autowired
    private BusinessRole rService;

    /*
    @GetMapping("/new")
    public String newRole(Model model) {
        model.addAttribute("role", new Role());
        model.addAttribute("listaUsuarios", uService.listar());
        return "role/role";
    }

    @PostMapping("/save")
    public String saveRole(@Validated Role role, BindingResult result, Model model, SessionStatus status) throws Exception {
        if (result.hasErrors()) {
            return "role/role";
        } else {
            rService.insert(role);
            model.addAttribute("mensaje", "Se guardó correctamente");
            status.setComplete();
        }
        model.addAttribute("listaRoles", rService.list());

        return "role/role";

    }
     */

    @PostMapping("/save")
    public ResponseEntity<Integer> newRole(@RequestBody Role role) {
        Integer rpta;
        rpta = rService.insertRol(role);
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Role> listRole(Model model) {
        return rService.list();
    }
}
