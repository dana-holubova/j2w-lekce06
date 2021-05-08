package cz.czechitas.java2webapps.lekce6.controller.cokolada;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Random;

/**
 *
 */
@Controller
@RequestMapping("/cokolada")
public class CokoladaController {

  private final Random random = new Random();

  @GetMapping("")
//  public Object index() {
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView("/cokolada/formular");
    modelAndView.addObject("form", new CokoladaForm());
//    return "/cokolada/formular";
    return modelAndView;
  }

  @PostMapping("")
  public Object form(@ModelAttribute("form") @Valid CokoladaForm form, BindingResult bindingResult) {
//    když tam budou chyby, tak se vrať na formulář
    if (bindingResult.hasErrors()) {
      return "/cokolada/formular";
    }
    //    když tam nejsou chyby, tak zobraz stránku, že bylo objednáno s vygenerovaným kódem objednávky

    return new ModelAndView("/cokolada/objednano")
            .addObject("kod", Math.abs(random.nextInt()))
            .addObject("email", form.getEmail());
  }
}
