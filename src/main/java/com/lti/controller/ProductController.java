package com.lti.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ProductPicDto;
import com.lti.dto.UpdateProductDto;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.service.ProductService;
import com.lti.service.UserService;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

	@Autowired
	ProductService ps;
	
	@Autowired
	UserService us;

	@RequestMapping(value="/addProduct", method = RequestMethod.POST)
	public UpdateProductDto addProduct(@RequestBody Product product) {
		return ps.addProduct(product);
	
	}
	
	@PostMapping("/pic-upload")
  public String upload(ProductPicDto productPicDto) {
      String imageUploadLocation = "d:/uploads/";
      String fileName = productPicDto.getProductPic().getOriginalFilename();
      //creating location for file
      String targetFile = imageUploadLocation + fileName;
      try {
      	//to read bytes - InputStream() ; to write bytes - FileOutputStream
          FileCopyUtils.copy(productPicDto.getProductPic().getInputStream(), new FileOutputStream(targetFile));
      } catch (IOException e) {
          e.printStackTrace();
          return e.getMessage();
      }
      Product product = ps.findProduct(productPicDto.getProductId());
      product.setProductImage(fileName);
      UpdateProductDto updateProductdto= ps.updateProduct(product);
      if(updateProductdto!=null)
          return "Product Image uploaded";

      return "Upload failed";
  }
	
	
	@GetMapping(value="/getproduct")
	public Product searchProduct(@RequestParam int productId, HttpServletRequest request) {
		Product product =  ps.findProduct(productId);
		//reading the project's deployed folder location
		String projPath = request.getServletContext().getRealPath("/");
		System.out.println(projPath);
		String tempDownloadPath = projPath + "/downloads/";
		//creating a folder within the project where we will place the profile pic of the customer getting fetched
		File f = new File(tempDownloadPath);
		if(!f.exists())
			f.mkdir();
		String targetFile = tempDownloadPath + product.getProductImage();

		//the original location where the uploaded images are present
		String uploadedImagesPath = "d:/uploads/";
		String sourceFile = uploadedImagesPath + product.getProductImage();
		try {
			FileCopyUtils.copy(new File(sourceFile), new File(targetFile));
		} catch (IOException e) {
			e.printStackTrace();
			//maybe for this product there is no profile pic
		}
		
		return product;
	}
	
	@GetMapping(value="/viewAll")
	public List<Product> viewProducts(){
		return ps.viewProducts();
	}
	
	@PutMapping("/update")
	public UpdateProductDto updateProduct(@RequestBody Product product) {
		return ps.updateProduct(product);
	}
	
}