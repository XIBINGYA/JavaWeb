package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {
    // 查询所有
    List<Brand> selectAll();

    // 添加数据
    void add(Brand brand);

    // 根据id修改查询
    Brand selectById(int id);

    // 根据id修改查询
    boolean update(Brand brand);

    // 批量删除
    void deleteByIds(int[] ids);


    // 根据id删除
    void deleteById(int id);

    /**
     * 分页查询
     * @param currenPage  当前页码
     * @param pageSize    每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currenPage, int pageSize);

    /**
     * 分页条件查询
     * @param currenPage
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currenPage, int pageSize, Brand brand);

}
