package com.bsworld.springboot.start.dao.mapper;

import com.bsworld.springboot.start.dao.entity.TRole;
import com.bsworld.springboot.start.dao.entity.TRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int countByExample(TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int deleteByExample(TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int insert(TRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int insertSelective(TRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    List<TRole> selectByExample(TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    TRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int updateByExampleSelective(@Param("record") TRole record, @Param("example") TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int updateByExample(@Param("record") TRole record, @Param("example") TRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int updateByPrimaryKeySelective(TRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_role
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    int updateByPrimaryKey(TRole record);
}