package com.kathy.examen.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kathy.examen.models.Pack;
import com.kathy.examen.models.User;
import com.kathy.examen.services.PackageService;
import com.kathy.examen.services.UserService;

@Controller
public class PackageController {
    private final PackageService packageService;
    private final UserService userService;

    public PackageController(UserService userService, PackageService packageService){
        this.userService = userService;
        this.packageService = packageService;
    }

    // @GetMapping("/packages")
    // public String clienteTable (HttpSession session, Model model){
    //     if(session.getAttribute("idU") == null){
    //         return "redirect:/";
    //     }
    //     else{
    //         User user = userService.findThingById((Long) session.getAttribute("idU"));
    //         List<User> usuarioLista = userService.allThings();
    //         List<Package> packLista = packageService.allThings();
    //         model.addAttribute("User", user);
    //         model.addAttribute("packLista", packLista);
    //         model.addAttribute("uasuarioLista", usuarioLista);
    //         return "package.jsp";
    //     }
    // }

    @GetMapping("/packages")
    public String pack(@ModelAttribute("pack") Pack pack, HttpSession session, Model model){
        User user = userService.findUserById((Long) session.getAttribute("idUser"));
        if(user.getRol() !=1 || user.getId() == null){
            return "redirect:/";
        }
        else{
            List<User> users = userService.lista();
            List<Pack> packages = packageService.lista();
            model.addAttribute("users", users);
            model.addAttribute("packages", packages);
            return "package.jsp";
        }
    }
    
    @PostMapping("/packages")
    public String createPackage (@Valid @ModelAttribute ("pack") Pack packages, BindingResult result, HttpSession session, Model model){
        if(result.hasErrors()) {
			List<User> users = userService.lista();
			List<Pack> packagesdos = packageService.lista();
			model.addAttribute("users", users);
			model.addAttribute("packages", packagesdos);
			return "package.jsp";
        }
        else{
            User user = userService.findUserById((Long) session.getAttribute("idUser"));
            packages.setUser(user);
            packages.setAvailable(true);
            packageService.crear(packages);
            return "redirect:/packages";
        }    
    }
    
    // @GetMapping("/users/{idU}")
    // public String users (@ModelAttribute ("user") User user, HttpSession session, Model model){
    //     User user2 = userService.findUserById((Long) session.getAttribute("idUser"));
    //     List<Pack> packages = packageService.lista();
    //     if(user2.getRol() == 1 || user2.getId() == null){
    //         return "redirect:/";
    //     }
    //     else{
    //         model.addAttribute("packages", packages);
    //         model.addAttribute("user", user2);
    //         return "suscripcion.jsp";
    //     }
    // }

    @GetMapping("/packages/{idS}/edit")
    public String edit (@PathVariable ("idS") Long idS, HttpSession session, Model model){
        User user = userService.findUserById((Long) session.getAttribute("idUser"));
        if(user.getId() == null || user.getRol() != 1){
            return "redirect:/";
        }
        else{
            Pack packagedos = packageService.findUserById(idS);
            model.addAttribute("pack", packagedos);
            model.addAttribute("idS", idS);
            return "edit.jsp";
        }
    }

    @PutMapping("/packages/{idS}/edit")
    public String editPack (@Valid @ModelAttribute("pack") Pack packages, BindingResult result, @PathVariable("idS") Long idS, Model model,RedirectAttributes redirectAttributes){
        Pack packagetres = packageService.findUserById(idS);
        if(result.hasErrors()){
            model.addAttribute("packagetres", packagetres);
            redirectAttributes.addFlashAttribute("error");
            return "redirect:/packages/" + idS + "/edit";
        }
        else{
            packagetres.setCost(packages.getCost());
            packageService.update(packagetres);
            return "redirect:/packages";
        }
    }

    @GetMapping("/packages/{idS}/valido")
    public String valido (@PathVariable ("idS") Long idS, HttpSession session){
        Pack packages = packageService.findUserById(idS);
        User user = userService.findUserById((Long) session.getAttribute("idUser"));
        if(user.getId() == packages.getUser().getId()){
            if(packages.isAvailable()){
                packages.setAvailable(false);
                packageService.update(packages);
                return "redirect:/packages";
            }
            else{
                packages.setAvailable(true);
                packageService.update(packages);
                return "redirect:/packages";
            }
        }
        else{
            return "redirect:/";
        }
    }
    
    @GetMapping("/packages/{idS}/delete")
    public String deletePack (@PathVariable("idS") Long idS, HttpSession session){
        User user = userService.findUserById((Long) session.getAttribute("idUser"));
        if(user.getRol() !=1 || user.getId() == null){
            return "redirect:/";
        }
        else{
            Pack packages = packageService.findUserById(idS);
            if (packages.getUsers().size() > 0){
                return "redirect:/packages";
            }
            else{
                packageService.delete(packages);
                return "redirect:/packages";
            }
        }
    }
    // @PostMapping("/users/{idU}")
    // public String CambiarPack (@ModelAttribute ("packages") Pack packages, HttpSession session){
    //     User user = userService.findUserById((Long) session.getAttribute("idUser"));
    //     user.setPack(packages);
    //     userService.update(user);
    //     return "redirect:/users/" + user.getId();
    // }

    @GetMapping("/users/{idU}/cambiar")
    public String cambiarPackuno(@PathVariable ("idU") Long idU, @RequestParam ("pack") Long pack, HttpSession session, Model model){
        User user = userService.findUserById((Long) session.getAttribute("idUser"));
        List<Pack> paquetes = packageService.lista();
        model.addAttribute("paquetes", paquetes);
        model.addAttribute("user", user);
        user.setPack(packageService.findUserById(pack));
        userService.crear(user);
        return "redirect:/users/" + idU;
    }

    @GetMapping("/users/{idU}")
    public String cambiarPackage (@PathVariable ("idU") Long idU, HttpSession session, Model model){
        User user = userService.findUserById((Long) session.getAttribute("idUser"));
        List<Pack> paquetes = packageService.lista();
        paquetes.remove(user.getPack());
        model.addAttribute("paquetes", paquetes);
        model.addAttribute("user", user);
        return "suscripcion.jsp";
    }
}
