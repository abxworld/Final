package com.bsworld.springboot.start.dao.entity;

public class TRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.id
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.rolename
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    private String rolename;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.id
     *
     * @return the value of t_role.id
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.id
     *
     * @param id the value for t_role.id
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.rolename
     *
     * @return the value of t_role.rolename
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.rolename
     *
     * @param rolename the value for t_role.rolename
     *
     * @mbggenerated Mon Jul 30 17:55:26 CST 2018
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}