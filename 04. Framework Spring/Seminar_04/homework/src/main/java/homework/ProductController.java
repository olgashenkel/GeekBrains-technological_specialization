package homework;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/products")
    public String getProducts(Model model){
        model.addAttribute("products", productRepository.getProducts());
        productRepository.getProducts();
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model){
        productRepository.addProduct(p);
        model.addAttribute("products", productRepository.getProducts());
        return "products";
    }
}