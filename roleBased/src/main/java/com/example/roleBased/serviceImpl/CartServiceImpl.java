package com.example.roleBased.serviceImpl;

import com.example.roleBased.config.JwtRequestFilter;
import com.example.roleBased.dao.CartDao;
import com.example.roleBased.dao.ProductDao;
import com.example.roleBased.dao.UserDao;
import com.example.roleBased.entity.CartDetails;
import com.example.roleBased.entity.Product;
import com.example.roleBased.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl {

    @Autowired
    private CartDao cartdao;

    @Autowired
    private ProductDao productdao;

    @Autowired
    private UserDao userdao;

    public CartDetails addToCart(Integer productId){

        Product product =productdao.findById(productId).get();
        String username = JwtRequestFilter.CURRENT_USER;
        User user = null;

        if(username != null) {
            user = userdao.findById(username).get();
        }

        if(product != null && user != null)
        {
            CartDetails cart = new CartDetails(product,user);
            return cartdao.save(cart);
        }
        return null;
    }
}
