package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductsDao;
import com.itdr.pojo.Product;
import com.itdr.utils.GetPropertiesUtil;

import java.util.List;

/**
 * @ClassName: ProductsService
 * @author: heyuu
 * @create: 2019-08-03 09:17:52
 * @version: JDK 1.8
 * @description:
 */
public class ProductsService {
    private ProductsDao pd = new ProductsDao();

    public ResponseCode selectAll(String pageNum, String pageSize) {
        //创建一个统一返回对象
        ResponseCode<Object> rc = new ResponseCode<>();
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
            rc.setStatus(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"));
            rc.setMsg(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        //3、查数据
        List<Product> pli = pd.selectAll(page,size);
        //4、查询失败/出错
        if (pli == null){
            rc.setStatus(GetPropertiesUtil.getValue("SELECT_ERROR_CODE"));
            rc.setMsg(GetPropertiesUtil.getValue("SELECT_ERROR_MSG"));
            return rc;
        }
        //5、查询结果集没有数据
        if (pli.size() == 0){
            rc.setStatus(GetPropertiesUtil.getValue("SELECT_NULL_CODE"));
            rc.setMsg(GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        //6、查询结果集有数据
        rc.setStatus(GetPropertiesUtil.getValue("SELECT_SUCCESSFUL_CODE"));
        rc.setData(pli);
        return rc;
    }
}
