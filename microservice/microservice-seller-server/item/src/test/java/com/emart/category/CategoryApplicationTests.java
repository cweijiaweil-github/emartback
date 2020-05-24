package com.emart.category;

import java.util.List;
import java.util.Map;

import com.emart.category.entity.Category;
import com.emart.subCategory.entity.SubCategory;
import com.emart.transactions.entity.Transactions;

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
class CategoryApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void postSaveCategory()  throws Exception {
		Category category = new Category();
		category.setCategory_name("category_name");
		category.setCategoryId("c1001");
		category.setSellerId("s0001");
		Category result = testRestTemplate.postForObject("/category/save",category,Category.class);
		Assert.hasLength(result.getCategoryId(),category.getCategoryId());
	}

	@Test
	void getFindAllCategory()  throws Exception {
		String sellerId = "cweijiaweil@163.com";
		Map<String, List<Category>> result = testRestTemplate.getForObject("/category/findcategorys",Map.class,sellerId);
		System.out.println("xxxxxxxxxxxxx"+result);
		List<Category> list1 = result.get("key");
		JSONArray  json  =  JSONArray.fromObject(list1.get(0)); 
		Assert.hasLength(json.getJSONObject(0).get("sellerId").toString(),"s0001");
	}
}
