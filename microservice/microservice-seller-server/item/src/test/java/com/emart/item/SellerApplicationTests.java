package com.emart.item;

import java.util.List;
import java.util.Map;

import com.emart.category.entity.Category;
import com.emart.item.entity.Item;
import com.emart.subCategory.entity.SubCategory;

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
class SellerApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void postAddItems()  throws Exception {
		Item item = new Item();
		item.setItemId("item002");
		item.setItem_name("item_name1");
		item.setCategoryId("c1001");
		item.setSubcategoryId("sc0001");
		item.setSellerId("seller00001");
		item.setPrice(150);
		Item result = testRestTemplate.postForObject("/item/addItem",item,Item.class);
		Assert.hasLength(result.getItem_name(),item.getItem_name());
	}

	@Test
	void getGetItemByItemId()  throws Exception {
		String item_id = "item001";
		Item result = testRestTemplate.getForObject("/item/getItemByItemId/{item_id}",Item.class,item_id);
		Assert.hasLength(result.getItem_name(),"item_name1");
	}

	@Test
	void getSearchItems()  throws Exception {
		String item_name = "item_name1";
		List<Item> result = testRestTemplate.getForObject("/item/searchItems/{item_name}",List.class,item_name);
		JSONArray  json  =  JSONArray.fromObject(result.get(0)); 
		Assert.hasLength(json.getJSONObject(0).get("item_name").toString(),"item_name1");
	}
	
	@Test
	void getFillerItems()  throws Exception {
		String priceStart = "110";
		String priceEnd = "200";
		List<Item> result = testRestTemplate.getForObject("/item/fillerItems/{priceStart}/{priceEnd}",List.class,priceStart,priceEnd);
		JSONArray  json  =  JSONArray.fromObject(result.get(0)); 
		Assert.isTrue((Double)json.getJSONObject(0).get("price") > 110,"true");
	}

	@Test
	void getDeleteItems()  throws Exception {
		String item_id = "item002";
		Map<String, List<Map<String,Object>>> result = testRestTemplate.getForObject("/item/deleteItem/{item_id}",Map.class,item_id);
		Item result2 = testRestTemplate.getForObject("/item/getItemByItemId/{item_id}",Item.class,item_id);
		Assert.isNull(result2, "message");
	}


	@Test
	void postUpdateItemStock()  throws Exception {
		Item item = new Item();
		item.setId(6L);
		item.setItemId("item002");
		item.setItem_name("item_name1");
		item.setCategoryId("c1001");
		item.setSubcategoryId("sc0001");
		item.setSellerId("seller00001");
		item.setPrice(156);
		Map<String, List<Map<String,Object>>> result = testRestTemplate.postForObject("/item/updateItem",item,Map.class);
		Assert.notNull(result, "message");
	}

	
	@Test
	void getViewStock()  throws Exception {
		Map<String, List<Map<String,Object>>> result = testRestTemplate.getForObject("/item/listItems",Map.class);
		List<Map<String,Object>> list1 = result.get("key");
		Assert.hasLength(list1.get(0).get("item_name").toString(),"item_name1");
	}


}
