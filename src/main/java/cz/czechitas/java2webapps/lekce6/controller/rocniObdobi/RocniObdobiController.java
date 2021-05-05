package cz.czechitas.java2webapps.lekce6.controller.rocniObdobi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Filip Jirsák
 */
@Controller
@RequestMapping("/rocni-obdobi")
public class RocniObdobiController {
 @GetMapping("")
 public ModelAndView get() {
  return new ModelAndView("rocni-obdobi").addObject("form", new RocniObdobiForm());
 }

 @PostMapping("")
 public String post(@ModelAttribute("form") RocniObdobiForm form) {
  return "rocni-obdobi";
 }
}
