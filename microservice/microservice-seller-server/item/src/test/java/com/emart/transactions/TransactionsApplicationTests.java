package com.emart.transactions;

import java.util.List;
import java.util.Map;

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
class TransactionsApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void postSaveTransactions()  throws Exception {
		Transactions transactions = new Transactions();
		transactions.setItemId("i0001");
		transactions.setSubCategoryId("sc0001");
		transactions.setCategoryId("c1001");
		transactions.setNum_items(1000);
		transactions.setSellerId("seller00001");
		Transactions result = testRestTemplate.postForObject("/transactions/save",transactions,Transactions.class);
		Assert.hasLength(result.getSubCategoryId(),transactions.getSubCategoryId());
	}

	@Test
	void getFindAllTransactions()  throws Exception {
		String seller_id = "seller00001";
		Map<String,List<Transactions>> result = testRestTemplate.getForObject("/transactions/list/{seller_id}",Map.class,seller_id);
		List<Transactions> list1 = result.get("key");
		JSONArray  json  =  JSONArray.fromObject(list1.get(0)); 
		Assert.hasLength(json.getJSONObject(0).get("sellerId").toString(),"seller00001");
	}

}
