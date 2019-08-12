package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Product;
import com.itdr.utils.JsonUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UploadController",value = "/manage/product/upload")
@MultipartConfig
public class UploadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode rc = null;
        Product product = new Product();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = null;
        try {
             items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()){
            FileItem next = (FileItem)iter.next();
            if (next.isFormField()){
                String value = next.getString("UTF-8");
                if (next.getFieldName().equals("addName")){
                    product.setName(value);
                } else if (next.getFieldName().equals("addCategoryId")) {
                    product.setCategoryId(Integer.parseInt(value));
                }else if (next.getFieldName().equals("addSubtitle")) {
                    product.setSubtitle(value);
                }else if (next.getFieldName().equals("addDetail")) {
                    product.setDetail(value);
                }else if (next.getFieldName().equals("addPrice")) {
                    BigDecimal price=new BigDecimal(value);
                    product.setPrice(price);
                }else if (next.getFieldName().equals("addStatus")) {
                    product.setStatus(Integer.parseInt(value));
                }
            }else {
                String fileName = next.getName();
                String str = fileName.substring(fileName.lastIndexOf("."), fileName.length() - 1);

                System.out.println(fileName);
                System.out.println("测试获取文件的后缀：" + str);

            }
        }
        System.out.println(JsonUtils.obj2String(product));
    }
}
