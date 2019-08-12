package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.pojo.Order;
import com.itdr.utils.GetPropertiesUtil;

import java.util.List;

/**
 * Class: OrderService
 * create: 2019-08-06 19:26:43
 *
 * @version: JDK 1.8
 * @author: heyuu
 * <p>
 * description:
 */
public class OrderService {

    private OrderDao od = new OrderDao();

    public ResponseCode detail(String orderNo) {
        ResponseCode rc = null;
        if (orderNo == null || orderNo.equals("")){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_CODE"),GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_MSG"));
            return rc;
        }
        Order o = od.selectByOrderNo(orderNo);
        if(o == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"),GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        rc = ResponseCode.success(o);
        return rc;
    }

    public ResponseCode list(String pageNum,String pageSize) {
        ResponseCode rc = null;
        if (pageNum==null || pageNum.equals("")){pageNum = "0";}
        if (pageSize==null || pageSize.equals("")){pageSize = "10";}
        Integer page = null;
        Integer size = null;
        try {
            page = Integer.parseInt(pageNum);
            size = Integer.parseInt(pageSize);
        }catch (Exception e){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("PARAMETER_ILLICIT_CODE"), GetPropertiesUtil.getValue("PARAMETER_ILLICIT_MSG"));
            return rc;
        }
        List<Order> li = od.selectAll(page,size);
        if(li == null){
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

    public ResponseCode sendGoods(String orderNo) {
        ResponseCode rc = null;
        if (orderNo == null || orderNo.equals("")){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_CODE"),GetPropertiesUtil.getValue("INSERT_NULLPARAMETER_MSG"));
            return rc;
        }
        Order o = od.selectByOrderNo(orderNo);
        if(o == null){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("SELECT_NULL_CODE"),GetPropertiesUtil.getValue("SELECT_NULL_MSG"));
            return rc;
        }
        Integer row = od.updateByOrderNo(orderNo);
        if(row == 0){
            rc = ResponseCode.fail(GetPropertiesUtil.getValue("UPDATE_ERROR_CODE"),GetPropertiesUtil.getValue("UPDATE_ERROR_MSG"));
            return rc;
        }
        rc = ResponseCode.success(GetPropertiesUtil.getValue("UPDATE_SUCCESSFUL_DATA"));
        return rc;
    }
}
