package pe.prodriverperu.beprodriverperu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.prodriverperu.beprodriverperu.business.BusinessUsers;
import pe.prodriverperu.beprodriverperu.entities.Users;

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("/users")
public class RestUser {
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private BusinessUsers uService;

    @PostMapping("/save")
    public int saveUser(@RequestBody Users user){
        int rpta = 0;
        String bcryptPassword = bcrypt.encode(user.getPassword());
        user.setPassword(bcryptPassword);
        uService.insertar(user);
        return rpta;
    }

    @GetMapping("/list")
    public String listUser(Model model) {
        try {
            model.addAttribute("user", new Users());
            model.addAttribute("listaUsuarios", uService.listar());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "usersecurity/listUser";
    }
}
