package pe.prodriverperu.beprodriverperu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.prodriverperu.beprodriverperu.business.BusinessUsers;
import pe.prodriverperu.beprodriverperu.entities.Users;

@Controller
//@Secured({"ROLE_ADMIN"})
@RequestMapping("/users")
public class RestUser {
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private BusinessUsers uService;

    @PostMapping("/save")
    public ResponseEntity<Integer> saveUser(@RequestBody Users user){
        if (uService.buscarUser(user.getUsername())==0){
            String bcryptPassword = bcrypt.encode(user.getPassword());
            user.setPassword(bcryptPassword);
            uService.insert(user);
            return new ResponseEntity<Integer>(1,HttpStatus.OK);
        }
        return new ResponseEntity<Integer>(0,HttpStatus.NOT_FOUND);
    }
/*
    @PreAuthorize("permitAll()")
    @PostMapping("/save/{user_id}/{rol_id}")
    public ResponseEntity<Integer> saveUseRol(@PathVariable("user_id") Integer user_id,
                                              @PathVariable("rol_id") Integer rol_id){
        //return new ResponseEntity<Integer>(uService.insertUserRol(user_id, rol_id),HttpStatus.OK);
        return new ResponseEntity<Integer>(uService.insertUserRol2(user_id, rol_id), HttpStatus.OK);
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
    }*/
}
