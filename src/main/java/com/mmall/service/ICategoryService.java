package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;


import java.util.List;

/**
 * Created by wcl
 * Date:2018-10-15
 * Time:19:51
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId,String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
