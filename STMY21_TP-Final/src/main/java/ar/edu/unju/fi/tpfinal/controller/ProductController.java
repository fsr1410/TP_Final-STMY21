package ar.edu.unju.fi.tpfinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	private IProductLineService productLineService;
	
	
	@GetMapping("/product/nuevo")
	public String getProductPage(Model model) {		
		model.addAttribute("product",productService.getProduct());
		
		List<ProductLine> productLines = productLineService.getProductLines();
		model.addAttribute("productLines", productLines);
		
		return ("nuevo-product");
	}	
	
	@PostMapping("/product/guardar")
	public ModelAndView agregarProduct(@Valid @ModelAttribute("product") Product product, BindingResult resulValidacion) {
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-product");
			modelView.addObject("product",product);
			//productService.agregarProduct(producto);
			System.out.println("ERROR");
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/product/listado"); //lista de employee
			productService.agregarProduct(product);
			modelView.addObject("products", productService.getProducts());
			System.out.println("SIRVE");
			return modelView;
		}
	}
	
	@GetMapping("/product/listado")
	public ModelAndView getProductPage() {
		ModelAndView modelView = new ModelAndView("listado-product");
		modelView.addObject("products", productService.getProducts());
		
		return modelView;
	}
	
	@GetMapping("/product/editar/{id}")
	public ModelAndView getProductEditPage(@PathVariable(value="id")Long productCode ) {
		ModelAndView modelView = new ModelAndView("nuevo-product");
		Product product =  productService.getProductPorCodigo(productCode);
		
		List<ProductLine> productLines = productLineService.getProductLines();
		modelView.addObject("productLines", productLines);
		
		modelView.addObject("product",product);
		return modelView;
	}
	
	@GetMapping("/product/eliminar/{id}")
	public ModelAndView getProductDeletePage(@PathVariable(value="id")Long productCode ) {
		ModelAndView modelView = new ModelAndView("redirect:/product/listado");
		productService.eliminarProduct(productCode);
		return modelView;
	}
}