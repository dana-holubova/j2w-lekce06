package cz.czechitas.java2webapps.lekce6.controller.alkohol;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Random;
import java.util.UUID;

/**
 *
 */
@Controller
@RequestMapping("/alkohol")
public class AlkoholController {
//    nemá to být v konstruktoru?
    private final Random random = new Random();

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/alkohol/formular");
//    vkládám prázdný formulář, pokud bych jej tam nevložila, tak by se do view formular.html nevkládaly prvky
//    ve formuláři můžu mít přednastavené nějaké hodnoty
        modelAndView.addObject("form", new AlkoholForm());
        return modelAndView;
    }

    @PostMapping("")
// Aby mi fungovaly validace uvedené v bean AlkoholForm.java, tak musí být před parametrem metody který uvádí bean,
// anotace @Valid
// Prohlížeč odešle data, Spring je namapuje do proměnné AlkoholForm form. Proměnná typu BindingResult v sobě obsahuje
// výsledek. Výsledek obsahuje i informace o chybách.
// Metoda musí vracet Object, protože může teoreticky vracet String nebo ModelAndView. Object je předchůzce všech typů
// v Javě. Spring už ví, co má dělat.
// Když se validuje prvek AlkoholForm, tak si někam musí poznamenat chyby, na které narazil a musí je správně přiřadit
// ke jménům. Dělá se to pomocí anotace @ModelAttribute(). Tato anotace říká, že prvek AlkoholForm form se má vložit do
// modelu a v tomto modelu se bude jmenovat form.
// Tím, že dám do parametru metody form anotaci @ModelAttribute i @Valid, tak se mi to spáruje s validací. Teprve poté
// se můžu ve view formular.html ptát na chyby.
    public Object form(@ModelAttribute("form") @Valid AlkoholForm form, BindingResult bindingResult) {

//        anotace @ModelAttribute("form") mi udělá to, co je v následujících dvou řádcích
//        ModelAndView modelAndView = new ModelAndView("/alkohol/formular");
//        modelAndView.addObject("form", form);

//        V metodě můžu jako parametry mít víc beanů, např. AlkoholForm form a UzivatelForm uzivatel. I proto je
//        potřeba uvádět anotaci @ModelAttribute("form").
//        public Object form(@ModelAttribute("form") @Valid AlkoholForm form, UzivatelForm uzivatel, BindingResult bindingResult) {

//    metoda hasErrors mi říká, jestli tam nějaké chyby jsou (boolean)
//    V metodě už mám víc možných výstupů, podle toho jestli tam jsou chyby nebo jestli je splněna podmínka věku
//    když tam jsou chyby, tak se vrať zpátky na formulář
        if (bindingResult.hasErrors()) {
//            vrací String
            return "/alkohol/formular";
        }

        // Když mi nestačí validační atributy, tak můžu validovat ručně
// když je věk nízký, tak vrať stránku o nízkém věku
        if (form.getVek() < 18) {
//            vrací String
//            return "/alkohol/nizky-vek";
// Do objektu bindingResult můžu vložit svůj vlastní výsledek validace pomocí metody rejectValue. Parametr
// ErrorCode slouží pro případ, kdy mám formulář vícejazyčný. Překlady jsou v samostatných souborech. Parametr
// defaultMessage se použije, když hláška není v samostatném souboru.
      bindingResult.rejectValue("vek", "", "To by nešlo. Nejsi náhodou starší?");
      return "/alkohol/formular";
        }

//    když tam nejsou chyby, tak zobraz stránku, že bylo objednáno s vygenerovaným kódem objednávky
//        Vrací ModelAndView
        return new ModelAndView("/alkohol/objednano")
                .addObject("kod", Math.abs(random.nextInt()))
                .addObject("email", form.getEmail());
    }
}
