package com.emart.user;

import java.util.Map;

import com.emart.user.entity.Buyer;
import com.emart.user.entity.Seller;
import com.emart.user.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
class UserApplicationTests {

	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void postLogin()  throws Exception {
		User user = new User();
		user.setEmail("aaa@a");
		user.setPassword("aaaaaa");
		Map<String,String> result = testRestTemplate.postForObject("/user/login",user,Map.class);
		Assert.hasLength(result.get("key"),"/home/buyer");
	}

	
	@Test
	void postBuyerSignup()  throws Exception {
		Buyer buyer = new Buyer();
		buyer.setEmail("email");
		buyer.setPassword("password");
		Buyer result = testRestTemplate.postForObject("/user/buyer/signup",buyer,Buyer.class);
		Assert.hasLength(result.getEmail(),buyer.getEmail());
	}

	@Test
	void postSellerSignup()  throws Exception {
		Seller seller = new Seller();
		seller.setEmail("selleremail");
		seller.setPassword("sellerpassword");
		Seller result = testRestTemplate.postForObject("/user/seller/signup",seller,Seller.class);
		Assert.hasLength(result.getEmail(),seller.getEmail());
	}
}
