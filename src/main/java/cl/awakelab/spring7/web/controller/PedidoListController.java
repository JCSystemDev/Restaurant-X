package cl.awakelab.spring7.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PedidoListController {
    @GetMapping
    public String getPedidoList(){
        return "pedidoList";
    }
}
