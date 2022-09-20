package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();

        response.setContentType("text/json; charset=utf-8");

        String jsonString = JSON.toJSONString(brands);
        System.out.println(jsonString);
        response.getWriter().write("" + jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.add(brand);

        response.getWriter().write("success");
    }

    /**
     * 根据Id删除数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        brandService.deleteById(brand.getId());

        response.getWriter().write("success");

    }
    /**
     * 批量删除数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        int[] ints = JSON.parseObject(params, int[].class);

        brandService.deleteByIds(ints);

        response.getWriter().write("success");
    }

    /**
     * 根据Id查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        int ints = JSON.parseObject(params, int.class);
        brandService.selectById(ints);

        response.getWriter().write("success");
    }

    /**
     * 修改数据
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();

        Brand brand = JSON.parseObject(params, Brand.class);

        boolean update = brandService.update(brand);

        response.getWriter().write("success");

    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收 当前页码 和煤业展示条数 url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 调用service查询
        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);

        response.setContentType("text/json; charset=utf-8");

        // 转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        response.getWriter().write(jsonString);
    }

    /**
     * 分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 接收 当前页码 和煤业展示条数 url?currentPage=1&pageSize=5
//        String _currentPage = request.getParameter("currentPage");
//        String _pageSize = request.getParameter("pageSize");
//
//        int currentPage = Integer.parseInt(_currentPage);
//        int pageSize = Integer.parseInt(_pageSize);
//        // 获取查询条件对象
//        BufferedReader reader = request.getReader();
//        String params = reader.readLine();
//
//        Brand brand = JSON.parseObject(params, Brand.class);
//
//        // 调用service查询
//        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
//        System.out.println(brandPageBean.getRows()+"111111111111111111");
//        response.setContentType("text/json; charset=utf-8");
//
//        // 转为JSON
//        String jsonString = JSON.toJSONString(brandPageBean);
//
//        response.getWriter().write(jsonString);

        //1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 Brand
        Brand brand = JSON.parseObject(params, Brand.class);


        //2. 调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}