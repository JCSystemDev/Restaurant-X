package cl.awakelab.spring7.web.controller;

import cl.awakelab.spring7.model.persistence.entity.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @GetMapping
    public  String getInicio(){
        return"pedido";
    }

    @GetMapping("/{id}")
    public String mostrarPedido(@PathVariable("id") int id, Model model) {
        return "pedido";
    }

}
