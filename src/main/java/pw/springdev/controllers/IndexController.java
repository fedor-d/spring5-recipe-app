package pw.springdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by FedorD on 2020-03-25
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/","/index"})
    public String getIndexPage() {

        return "index";
    }

}
