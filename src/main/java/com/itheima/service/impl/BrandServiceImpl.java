package com.itheima.service.impl;

import com.alibaba.fastjson.JSON;
import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.sqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory factory = sqlSessionFactoryUtils.getSqlSessionFactory();

    // 查询所有
    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();

        sqlSession.close();
        return brands;
    }

    // 添加数据
    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit();
        sqlSession.close();
    }

    // 根据id查询数据
    @Override
    public Brand selectById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.SelectById(id);

        sqlSession.close();

        return brand;
    }


    // 根据Id查询修改数据
    @Override
    public boolean update(Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand1 = selectById(brand.getId());

        if(brand1 != null){
            mapper.update(brand);
            sqlSession.commit();
        }

        sqlSession.close();

        return brand1 == null;
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteByIds(ids);

        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * 根据Id删除
     * @param id
     */
    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 分页擦好像
     * @param currenPage  当前页码
     * @param pageSize    每页展示条数
     * @return
     */
    @Override
    public PageBean<Brand> selectByPage(int currenPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 计算开始索引
        int begin = (currenPage-1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        List<Brand> rows = mapper.selectByPage(begin, size);

        // 查询总记录数
        int TotalCount = mapper.selectTotalCount();

        // 创建PageBean对象传递数据
        PageBean<Brand> Page = new PageBean<>();
        Page.setRows(rows);
        Page.setTotalCount(TotalCount);

        // 释放资源
        sqlSession.close();
        return Page;
    }

    /**
     * 分页条件查询
     * @param currenPage
     * @param pageSize
     * @param brand
     * @return
     */
    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
//        SqlSession sqlSession = factory.openSession();
//        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//
//        // 计算开始索引
//        int begin = (currenPage-1) * pageSize;
//        // 计算查询条目数
//        int size = pageSize;
//
//        // 处理brand数据
//        String brandName = brand.getBrandName();
//        if(brandName !=null && brandName.length() > 0){
//            brand.setBrandName("%"+brand+"%");
//        }
//        String companyName = brand.getCompanyName();
//        if(companyName !=null && companyName.length() > 0){
//            brand.setBrandName("%"+companyName+"%");
//        }
//
//        // 查询
//        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);
//
//        // 查询总记录数
//        int TotalCount = mapper.selectTotalCountByCondition(brand);
//
//        // 创建PageBean对象传递数据
//        PageBean<Brand> Page = new PageBean<>();
//        Page.setRows(rows);
//        Page.setTotalCount(TotalCount);
//
//        // 释放资源
//        sqlSession.close();
//        return Page;

        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);


        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;

        // 处理brand条件，模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%" + companyName + "%");
        }


        //5. 查询当前页数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);

        //6. 查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);

        //7. 封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);


        //8. 释放资源
        sqlSession.close();

        return pageBean;
    }

}
