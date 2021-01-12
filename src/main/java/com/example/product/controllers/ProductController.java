package com.example.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.models.Product;
import com.example.product.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController   // recebe as requisições HTTP
@RequestMapping(value = "/apiProdutos")
@Api(value = "API REST Produtos")
@CrossOrigin(origins="*")
public class ProductController {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma Lista de Produtos")
	public List<Product> listProducts(){
		return productRepository.findAll();
		
	}
	
	// METHOD GET
	//listando por id do produto
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um produto unico")
	public Product listProductUnic(@PathVariable(value = "id") long id) {
		

		
		
		return productRepository.findById(id);
		
	}
	
	
	
	

	// METHOD POST
	
	@PostMapping("/produto")
	//request Body ,dados vão pelo corpo da requisição
	
	@ApiOperation(value = "Salva um produto")
	public void  salvar(@RequestBody  Product product) {
		
		
		productRepository.save(product);
		
	
		
	}
	// METHOD DELETE
	
		@DeleteMapping("/produto")
		//request Body ,dados vão pelo corpo da requisição
		
		
		@ApiOperation(value = "Deleta um Produto")
		public void  deletar(@RequestBody  Product product) {
			
			
			productRepository.delete(product);
			
		
			
		}
		
		// METHOD ATUALIZAR
		
			@PutMapping("/produto")
			//request Body ,dados vão pelo corpo da requisição
			
			
			@ApiOperation(value = "Atualiza um Produto")
			public void  atualizar(@RequestBody  Product product) {
				
				
				productRepository.save(product);
				
			
				
			}
			
			
	
	

	
	
	
	
	
}
