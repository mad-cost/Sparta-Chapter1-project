package com.sparta.msa_exam.product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;
  public void createProducts(ProductRequestDto requestDto) {
    productRepository.save(new Product(requestDto));
  }

  public List<ProductResponseDto> findAll() {
    List<Product> products = productRepository.findAll();
    List<ProductResponseDto> responseDtos = new ArrayList<>();

    for (Product product : products){
      responseDtos.add(new ProductResponseDto(product));
    }
    return responseDtos;
  }

  public Long findById(Long productId) {
    Product product = productRepository.findById(productId).orElse(null);
    if (product != null) {
      return product.getProduct_id();
    } else {
      return null;
    }
  }


}
