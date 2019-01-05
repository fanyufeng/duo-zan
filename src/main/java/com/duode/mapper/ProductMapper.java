package com.duode.mapper;

import com.duode.model.Factory;
import com.duode.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface ProductMapper {
    public List<Product> findProductInfo(@Param("id") int id);
    public int addProduct(Product product);
    public int updateProduct(@Param("product") Product product);
    public List<Product> findProduct();

}
