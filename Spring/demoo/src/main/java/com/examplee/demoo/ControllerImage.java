package com.examplee.demoo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ControllerImage {

    @GetMapping("/")
    public String uploadImage(Model model){
        File directorio = new File("src/main/resources/static/images/1");
            model.addAttribute("archivos", directorio.list());
        return "test.jsp";
    }

    @PostMapping("/")
    public String uploadImage(@RequestParam("cosa") MultipartFile file){
            if (!file.isEmpty()) {
                String name = file.getOriginalFilename();
                Path directorioImg = Paths.get("src/main/resources/static/images");
                String ruta = directorioImg.toFile().getAbsolutePath() + "/1";
                File directorio = new File(ruta);
                if(directorio.exists() == false){ 
                    directorio.mkdirs(); 
                }
                try {
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(directorio.getAbsolutePath() +"/"+ name)));
                    stream.write(bytes);
                    stream.close(); 
                    return "redirect:/";
                    
                } catch (Exception e) {
                    return "You failed to upload  => " + e.getMessage();
                }
            } 
            else {
                return "You failed to upload because the file was empty.";
        }
    }
}
