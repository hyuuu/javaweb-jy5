package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductsDao;
import com.itdr.pojo.Product;
import com.itdr.utils.GetPropertiesUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: ProductsService
 * @author: heyuu
 * @create: 2019-08-03 09:17:52
 * @version: JDK 1.8
 * @description:
 */
@SuppressWarnings({"unchecked"})
public class ProductsService {
    private ProductsDao pd = new ProductsDao();

    public ResponseCode selectAll(String pageNum, String pageSize) {
        //创建一个统一返回对象
        ResponseCode<Object> rc = null;
        //1、页码和一页数据量非空判断，若空则初始化
        if (pageNum==null || pageNum.equals("")){pageNum = "1";}
        if (pageSize==null || pageSize.equals("")){pageSize = "10";}
        //2、字符串转数值
        Integer page = null;
        Integer size = null;
        try {
            page = Integer.parseInt(pageNum);
            size = Integer.parseInt(pageSize);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        //3、查数据
        List<Product> pli = pd.selectAll(page,size);
        //4、查询失败/出错
        if (pli == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_ERROR_CODE"), GetPropertiesUtil.getValue("SELECT_ERROR_MSG"));
            return rc;
        }
        //5、查询结果集没有数据
        if (pli.size() == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"), GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        //6、查询结果集有数据
        rc = ResponseCode.success(pli);
        return rc;
    }

    public ResponseCode selectLikeName(String productName) {
        ResponseCode rc = null;
        List<Product> p = pd.selectLikeName(productName);
        if (p == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_ERROR_CODE"),GetPropertiesUtil.getValue("SELECT_ERROR_MSG"));
            return rc;
        }
        if (p.size() == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"),GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        rc = ResponseCode.success(p);
        return rc;
    }

    public ResponseCode selectById(String productId) {
        ResponseCode rc = null;
        Integer id = null;
        try {
            id = Integer.parseInt(productId);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        Product p = pd.selectById(id);
        if (p == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"),GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        rc = ResponseCode.success(p);
        return rc;
    }

    public ResponseCode search(String productName, String productId) {
        ResponseCode rc = null;
        if (productName != null && !productName.equals("")){
            rc = selectLikeName(productName);
            return rc;
        }
        if (productId != null && !productId.equals("")){
            rc = selectById(productId);
            return rc;
        }
        rc = selectAll("1","10");
        return rc;
    }

    public ResponseCode set_sale_status(String productId, String status) {
        ResponseCode rc = null;
        Integer id = null;
        Integer stat = null;
        try {
            id = Integer.parseInt(productId);
            stat = Integer.parseInt(status);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        Product p = pd.selectById(id);
        if (p == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"),GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        Integer row = pd.updateStatusById(id,stat);
        if (row == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("UPDATE_ERROR_CODE"),GetPropertiesUtil.getValue("UPDATE_ERROR_MSG"));
            return rc;
        }
        rc = ResponseCode.success(GetPropertiesUtil.getValue("UPDATE_SUCCESSFUL_CODE"),GetPropertiesUtil.getValue("UPDATE_SUCCESSFUL_DATA"));
        return rc;
    }

    public ResponseCode save(String categoryId, String name, String subtitle, String mainImage, String subImages, String detail, String price, String stock, String status, String id) {
        ResponseCode rc = null;
        Integer c_id = null;
        BigDecimal p_price = null;
        Integer p_status = null;
        Integer p_id = null;
        try {
            c_id = Integer.parseInt(categoryId);
            p_price = new BigDecimal(price);
            p_status = Integer.parseInt(status);
            p_id = Integer.parseInt(id);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        if (name == null || name.equals("") ||
                subtitle == null || subtitle.equals("") ||
                mainImage == null || mainImage.equals("") ||
                subImages == null || subImages.equals("") ||
                detail == null || detail.equals("") ||
                stock == null || stock.equals("")){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_CODE"),GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_MSG"));
        }
        Product p = pd.selectById(p_id);
        Integer row = null;
        if (p == null){
            row = pd.insertAll(c_id,name,subtitle,mainImage,subImages,detail,p_price,stock,p_status);
            if (row != 0){
                rc = ResponseCode.success(GetPropertiesUtil.getValue("INSERT_SUCCESSFUL_DATA"));
                return rc;
            }
        }else {
            row = pd.updateAll(c_id,name,subtitle,mainImage,subImages,detail,p_price,stock,p_status,p_id);
            if (row != 0){
                rc = ResponseCode.success(GetPropertiesUtil.getValue("UPDATE_SUCCESSFUL_DATA"));
                return rc;
            }
        }
        rc = ResponseCode.fail(GetPropertiesUtil.getValue("UPDATE_ERROR_CODE"),GetPropertiesUtil.getValue("UPDATE_ERROR_MSG"));
        return rc;
    }
}
