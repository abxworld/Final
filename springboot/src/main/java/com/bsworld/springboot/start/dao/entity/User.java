package com.bsworld.springboot.start.dao.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.USER_NAME
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.PASS_WORD
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    private String passWord;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.USER_NAME
     *
     * @return the value of user.USER_NAME
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.USER_NAME
     *
     * @param userName the value for user.USER_NAME
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.PASS_WORD
     *
     * @return the value of user.PASS_WORD
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.PASS_WORD
     *
     * @param passWord the value for user.PASS_WORD
     *
     * @mbggenerated Tue Jul 24 18:38:14 CST 2018
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}