package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.CategoryDao;
import com.itdr.pojo.Category;
import com.itdr.utils.GetPropertiesUtil;

import java.util.List;

/**
 * Class: CategoryService
 * create: 2019-08-05 20:09:25
 *
 * @version: JDK 1.8
 * @author: heyuu
 * description:
 */
public class CategoryService {

    private CategoryDao cd = new CategoryDao();

    public ResponseCode get_category(String categoryId) {
        ResponseCode rc = null;
        Integer parentId = null;
        try {
            parentId = Integer.parseInt(categoryId);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        List<Category> li = cd.selectByParentId(parentId);
        if (li == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_ERROR_CODE"),GetPropertiesUtil.getValue("SELECT_ERROR_MSG"));
            return rc;
        }
        if (li.size() == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"),GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        rc = ResponseCode.success(li);
        return rc;
    }

    public ResponseCode add_category(String categoryName) {
        ResponseCode rc = null;
        if (categoryName == null || categoryName.equals("")){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_CODE"),GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_MSG"));
            return rc;
        }
        Integer row = cd.insertWithName(categoryName);
        if (row == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("INSERT_ERROR_CODE"),GetPropertiesUtil.getValue("INSERT_ERROR_MSG"));
            return rc;
        }
        rc = ResponseCode.success(GetPropertiesUtil.getValue("INSERT_SUCCESSFUL_DATA"));
        return rc;
    }

    public ResponseCode set_category_name(String categoryId, String categoryName) {
        ResponseCode rc = null;
        Integer id = null;
        try {
            id = Integer.parseInt(categoryId);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        if (categoryName == null || categoryName.equals("")){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_CODE"),GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_MSG"));
            return rc;
        }
        Category c = cd.selectById(id);
        if(c == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"),GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        Integer row = cd.updateCategoryNameById(id,categoryName);
        if (row == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("UPDATE_ERROR_CODE"),GetPropertiesUtil.getValue("UPDATE_ERROR_MSG"));
            return rc;
        }
        rc = ResponseCode.success(GetPropertiesUtil.getValue("UPDATE_SUCCESSFUL_DATA"));
        return rc;
    }

    public ResponseCode get_deep_category(String categoryId) {
        ResponseCode rc = null;
        Integer id = null;
        try {
            id = Integer.parseInt(categoryId);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        /*
         *获取当前分类id及递归子节点categoryId
         */
        List<Category> li = cd.selectDeepCategoryById(id);

        return null;
    }
}
