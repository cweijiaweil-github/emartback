package com.emart.order;

import java.util.List;
import java.util.Map;

import com.emart.order.entity.Item;
import com.emart.purchaseHistory.entity.PurchaseHistory;

import org.apache.tomcat.util.http.fileupload.MultipartStream.ItemInputStream;
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
class OrderApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void getSearchItems() throws Exception {
		String item_name = "item_name2";
		Map<String, List<Item>> result = testRestTemplate.getForObject("/order/search/{item_name}", Map.class,
				item_name);
		List<Item> itemlist = result.get("key");
		for (int i = 0; i < itemlist.size(); i++) {
			JSONArray json = JSONArray.fromObject(itemlist.get(i));
			if (json.getJSONObject(0).get("itemId").equals("item002")) {
				Assert.hasLength(json.getJSONObject(i).get("item_name").toString(), "item_name2");
			}
		}
	}

	@Test
	void getFillerItems() throws Exception {
		Double priceStart = 100d;
		Double priceEnd = 150d;
		Map<String, List<Item>> result = testRestTemplate.getForObject("/order/fillerItems/{priceStart}/{priceEnd}",
				Map.class, priceStart, priceEnd);
		List<Item> itemlist = result.get("key");
		for (int i = 0; i < itemlist.size(); i++) {
			JSONArray json = JSONArray.fromObject(itemlist.get(i));
			if (json.getJSONObject(0).get("price").equals("item004")) {
				Assert.hasLength(json.getJSONObject(i).get("item_name").toString(), "item_name4");
			}
		}
	}
}
