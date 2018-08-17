package br.com.juniorstreichan.apivendas.resource

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@CrossOrigin
@Controller
class MainResource {

    @GetMapping
    fun home(): ModelAndView {
        println("### ENTROUU ###")
        val model = ModelAndView("redirect:home/index")
        model.addObject("")
        return model
    }

}