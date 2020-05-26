package com.emart.cart;

import java.util.List;
import java.util.Map;

import com.emart.cart.entity.Cart;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import net.sf.json.JSONArray;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
public class CartApplicationTests {
    
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void postSaveCart()  throws Exception {
        Cart cart = new Cart();
        cart.setCartId("cart0001");
        cart.setBuyerId("buyId0001");
        cart.setNum_items(10);
        cart.setCategoryId("c1001");
        cart.setSubcategoryId("sc0001");
        cart.setItemId("seller00001");
		Cart result = testRestTemplate.postForObject("/cart/addcart",cart,Cart.class);
		Assert.hasLength(result.getCartId(),cart.getCartId());
	}

	@Test
	void getlistCarts()  throws Exception {
		Map<String, List<Cart>> result = testRestTemplate.getForObject("/cart/listcarts",Map.class);
        List<Cart> list1 = result.get("key");
        for(int j = 0; j < list1.size(); j++){
            JSONArray  json  =  JSONArray.fromObject(list1.get(j)); 
            if(json.getJSONObject(0).get("id").equals(2)){
                Assert.hasLength(json.getJSONObject(0).get("cartId").toString(),"cart0002");
            }
        }
    }
    
	@Test
	void getDeleteCartItems()  throws Exception {
        String id = "4,5";
		Map<String, List<Cart>> result = testRestTemplate.getForObject("/cart/deletecart/{id}",Map.class,id);
        List<Cart> list1 = result.get("key");
        String flg = "0";
        for(int j = 0; j < list1.size(); j++){
            JSONArray  json  =  JSONArray.fromObject(list1.get(j)); 
            if(json.getJSONObject(0).get("id").equals(4) || json.getJSONObject(0).get("id").equals(5)){
                flg = "1";
            }
        }
        Assert.hasLength(flg,"0");
	}
}