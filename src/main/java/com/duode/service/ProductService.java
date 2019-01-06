package com.duode.service;

import com.duode.mapper.ProductMapper;

import com.duode.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class ProductService {

    @Autowired
    public ProductMapper productMapper;

    public List<Product>  getProduct(int product_id){
        List<Product>  productReponse = productMapper.findProductInfo(product_id);

        if(productReponse.size()==0) {
            return null;
        } else {

            return productReponse;
        }

    }

    public Product  addProduct(Product product){
        int  productReponse = productMapper.addProduct(product);
        return product;
    }


    public int updateProduct(Product product){
        int code = productMapper.updateProduct(product);
        return code;
    }

    public List<Product> getproductList(){
        List<Product> productList= productMapper.findProduct();
        if (((List) productList).size() !=0) {
            return productList;
        } else {
            return null;

        }
    }
}
