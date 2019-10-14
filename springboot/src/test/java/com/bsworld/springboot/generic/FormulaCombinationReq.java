package com.bsworld.springboot.generic;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-07-23 17:08
 * description:
 */
public class FormulaCombinationReq {
    private Long uid;

    private Long novelId;

    private Integer type;

    private Integer isShow;

    private Integer status;

    private String backPic;

    private Long createTime;

    private Long updateTime;

    private String variableIds;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getNovelId() {
        return novelId;
    }

    public void setNovelId(Long novelId) {
        this.novelId = novelId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBackPic() {
        return backPic;
    }

    public void setBackPic(String backPic) {
        this.backPic = backPic;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getVariableIds() {
        return variableIds;
    }

    public void setVariableIds(String variableIds) {
        this.variableIds = variableIds;
    }
}
