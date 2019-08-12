package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.ProductsService;
import com.itdr.utils.GetPropertiesUtil;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;
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
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ProductsController",value = "/manage/product/*")
@MultipartConfig
public class ProductsController extends HttpServlet {

    private ProductsService ps = new ProductsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode rc = null;
        String path = PathUtil.getPath(request.getPathInfo());
        switch (path){
            case "list":
                rc = listDo(request);
                break;
            case "search":
                rc = searchDo(request);
                break;
            case "detail":
                rc = detailDo(request);
                break;
            case "set_sale_status":
                rc = set_sale_statusDo(request);
                break;
            case "save":
                rc = saveDo(request);
                break;
            case "searchByKeyWord":
                rc = searchByKeyWordDo(request);
                break;
            case "addProduct":
                rc = addProductDo(request,response);
                break;
            case "uploadTest":
                rc = uploadTestDo(request,response);
                break;
            case "uploadImgByAjax":
                rc = uploadImgByAjaxDo(request);
                break;
        }
        //5、返回响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rc));
    }

    private ResponseCode uploadImgByAjaxDo(HttpServletRequest request) {
        ResponseCode rc = null;
        try {
            Part part = request.getPart("addMainImage");
            rc = ps.uploadTmg(part);
            if (!rc.getStatus().equals("0")){
                rc = ResponseCode.fail(GetPropertiesUtil.getValue("FILE_UPLOAD_FAIL_CODE"),
                        GetPropertiesUtil.getValue("FILE_UPLOAD_FAIL_MSG"));
                return rc;
            }
            String mainImageUrl = (String) rc.getData();
            String name = request.getParameter("addName");
            String categoryId = request.getParameter("addCategoryId");
            String subtitle = request.getParameter("addSubtitle");
            String detail = request.getParameter("addDetail");
            String price = request.getParameter("addPrice");
            String status = request.getParameter("addStatus");
            rc = ps.addProduct(mainImageUrl,name,categoryId,subtitle,detail,price,status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rc;
    }

    private ResponseCode uploadTestDo(HttpServletRequest request, HttpServletResponse response) {
        ResponseCode rc = ResponseCode.fail("1","失败");
        try {

        //获取上传的文件
            Part part = request.getPart("upimg");
            System.out.println(part);
            System.out.println(part.toString());
        //获取请求的信息
            String name = part.getHeader("content-disposition");
            System.out.println(name);//测试使用

            String rnp = request.getParameter("testText");
            System.out.println(rnp);

//获取上传文件的目录
//            String root = request.getServletContext().getRealPath("/images");
            String root = "D:\\github\\javaweb-jy5\\rlg\\rlgdemo\\web\\img\\upload\\product";
    //            String root ="\\images\\products";
            System.out.println("测试上传文件的路径：" + root);

//获取文件的后缀
            String str = name.substring(name.lastIndexOf("."), name.length() - 1);
            System.out.println("测试获取文件的后缀：" + str);

//生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
            String filename = root + "\\" + UUID.randomUUID().toString() + str;
            System.out.println("测试产生新的文件名：" + filename);

//上传文件到指定目录，不想上传文件就不调用这个
            part.write(filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rc;
    }

    private ResponseCode addProductDo(HttpServletRequest request,HttpServletResponse response) {

        ResponseCode rc = null;

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        rc = ps.addProduct(items);
        return rc;
    }

    private ResponseCode searchByKeyWordDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String KeyWord = request.getParameter("KeyWord");
        String lookMore = request.getParameter("lookMore");
        rc = ps.searchByKeyWord(KeyWord,lookMore);
        return rc;
    }

    private ResponseCode saveDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String name = request.getParameter("name");
        String categoryId = request.getParameter("categoryId");
        String subtitle = request.getParameter("subtitle");
        String mainImage = request.getParameter("mainImage");
        String subImages = request.getParameter("subImages");
        String detail = request.getParameter("detail");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        rc = ps.save(
                categoryId,
                name,
                subtitle,
                mainImage,
                subImages,
                detail,
                price,
                stock,
                status,
                id
                );
        return rc;
    }

    //产品上下架
    private ResponseCode set_sale_statusDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String productId = request.getParameter("productId");
        String status = request.getParameter("status");
        rc = ps.set_sale_status(productId,status);
        return rc;
    }

    //详情
    private ResponseCode detailDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String productId = request.getParameter("productId");
        rc = ps.selectById(productId);
        return rc;
    }

    //产品搜索
    private ResponseCode searchDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String productName = request.getParameter("productName");
        String productId = request.getParameter("productId");
        rc = ps.search(productName,productId);
        return rc;

    }

    //产品list
    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rc = new ResponseCode();
        String pageNum = request.getParameter("pageNum");   //页码
        String pageSize = request.getParameter("pageSize"); //一页数据量
        rc = ps.selectAll(pageNum, pageSize);
        return rc;
    }
}
