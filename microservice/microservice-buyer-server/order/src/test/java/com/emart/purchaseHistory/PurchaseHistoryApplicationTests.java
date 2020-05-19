package com.emart.purchaseHistory;

import java.util.List;
import java.util.Map;

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
public class PurchaseHistoryApplicationTests {
    
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void postCheckout()  throws Exception {
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setSellerId("seller00001");
        purchaseHistory.setBuyerId("wei1");
        purchaseHistory.setNum_items(10);
        purchaseHistory.setCategoryId("c1001");
        purchaseHistory.setSubcategoryId("sc0001");
        purchaseHistory.setItemId("seller00001");
        purchaseHistory.setTransactIionId("his0001");
		PurchaseHistory result = testRestTemplate.postForObject("/history/checkout",purchaseHistory,PurchaseHistory.class);
		Assert.hasLength(result.getTransactIionId(),purchaseHistory.getTransactIionId());
    }
    
	@Test
	void getHistoryList()  throws Exception {
        String buyer_id = "wei1";
        Map<String,List<Map<String,Object>>> result = testRestTemplate.getForObject("/history/historyList/{buyer_id}",Map.class,buyer_id);
        List<Map<String,Object>> list1 = result.get("key");
        for(int j = 0; j < list1.size(); j++){
            Map<String,Object> map1 = list1.get(j); 
            if(map1.get("item_id").equals("item002")){
                Assert.hasLength(map1.get("item_name").toString(),"item_name2");
            }
        }
    }
}