package com.zql.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lawliet
 * @since 2019-04-20
 */
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "plan_id", type = IdType.AUTO)
    private Integer planId;

    /**
     * 任务内容
     */
    private String planContent;

    /**
     * 正在使用的资料
     */
    private String infoInUse;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }
    public String getInfoInUse() {
        return infoInUse;
    }

    public void setInfoInUse(String infoInUse) {
        this.infoInUse = infoInUse;
    }

    @Override
    public String toString() {
        return "Task{" +
        "planId=" + planId +
        ", planContent=" + planContent +
        ", infoInUse=" + infoInUse +
        "}";
    }
}
