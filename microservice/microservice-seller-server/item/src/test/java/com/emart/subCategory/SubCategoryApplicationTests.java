package com.emart.subCategory;

import java.util.List;
import java.util.Map;

import com.emart.category.entity.Category;
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
class SubCategoryApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	void postSaveSubCategory()  throws Exception {
		SubCategory subCategory = new SubCategory();
		subCategory.setSubCategoryId("sc0001");
		subCategory.setSubCategory_name("subCategory_name");
		subCategory.setCategoryId("c1001");
		subCategory.setSellerId("s0001");
		SubCategory result = testRestTemplate.postForObject("/subCategory/save",subCategory,SubCategory.class);
		Assert.hasLength(result.getSubCategoryId(),subCategory.getSubCategoryId());
	}
	
	@Test
	void getFindSubCategoryList()  throws Exception {
		String sub_category_id = "sc0001";
		Map<String, List<SubCategory>> result = testRestTemplate.getForObject("/subCategory/subcategorylist/{sub_category_id}",Map.class,sub_category_id);
		List<SubCategory> list1 = result.get("key");
		JSONArray  json  =  JSONArray.fromObject(list1.get(0)); 
		Assert.hasLength(json.getJSONObject(0).get("subCategoryId").toString(),"sc0001");
	}
}
