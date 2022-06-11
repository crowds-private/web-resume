package com.crowds.myresume.controller

import com.crowds.myresume.model.Article
import com.crowds.myresume.model.TerminalSection
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDateTime

@Controller
class PageController {

    var sections = mutableListOf<TerminalSection>()


    @RequestMapping("/")
    fun indexPage(mv: ModelAndView): ModelAndView {
        if (sections.isEmpty()) {
            var section = TerminalSection("# guest in ~/","about me", "A kotlin project exercise")
            sections.add(section)
        }
        mv.addObject("sections", sections)
        mv.setViewName("/index")
        return mv
    }

    @GetMapping("/terminal_input")
    fun terminalInput(mv: ModelAndView, @RequestParam newInput:String): ModelAndView {
        var section = TerminalSection("# guest in ~/" ,newInput, "${LocalDateTime.now()}")
        sections.add(section)
        mv.addObject("sections",sections)
        mv.setViewName("/index")
        return mv
    }

}