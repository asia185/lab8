package wizut.tpsi.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public String addForm(CalculatorForm calculatorForm) {
        return "add";
    }

    @GetMapping("/multiply")
    public String multiplyForm(CalculatorForm calculatorForm) {
        return "multiply";
    }

    @GetMapping("/calculate")
    public String calculateForm(CalculatorForm calculatorForm) {
        return "calculate";
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/add")
    public String addNumbers(Model model, CalculatorForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "add"; // powrót do formularza
        }
        int result = calculatorService.calculate(form.getX(), form.getY(), "+");
        
        form.setOperation("+");
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/multiply")
    public String multiplyNumbers(Model model, CalculatorForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "multiply"; // powrót do formularza
        }
        int result = calculatorService.calculate(form.getX(), form.getY(), "*");
        
        form.setOperation("*");
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/calculate")
    public String doCalculations(Model model, CalculatorForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "calculate"; // powrót do formularza
        }
        int result = calculatorService.calculate(form.getX(), form.getY(), form.getOperation());
        model.addAttribute("result", result);
        
        return "result";
    }
}
