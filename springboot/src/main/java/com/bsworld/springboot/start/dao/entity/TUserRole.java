package com.bsworld.springboot.start.dao.entity;

public class TUserRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_role.id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_role.user_id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_role.role_id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    private Integer roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_role.id
     *
     * @return the value of t_user_role.id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_role.id
     *
     * @param id the value for t_user_role.id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_role.user_id
     *
     * @return the value of t_user_role.user_id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_role.user_id
     *
     * @param userId the value for t_user_role.user_id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_role.role_id
     *
     * @return the value of t_user_role.role_id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_role.role_id
     *
     * @param roleId the value for t_user_role.role_id
     *
     * @mbggenerated Mon Jul 30 17:55:40 CST 2018
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}