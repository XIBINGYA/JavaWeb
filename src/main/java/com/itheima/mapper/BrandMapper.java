package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有数据
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 添加数据
     * @param brand
     */
    @Insert("insert into tb_brand values (null, #{brandName}, #{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id=#{id}")
    @ResultMap("brandResultMap")
    Brand SelectById(int id);

    /**
     * 修改数据
     * @param brand
     */
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id = #{id}")
    @ResultMap("brandResultMap")
    void update(Brand brand);

    /**
     * 批量删除数据
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 根据id删除数据
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);

    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin}, #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总纪录数
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();
    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */

    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size,@Param("brand") Brand brand);


    /**
     * 查询总纪录数根据条件查询
     * @return
     */
    int selectTotalCountByCondition(Brand brand);
}
