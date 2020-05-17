package com.vova.phoenix.model.po.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "admin_node")
public class AdminNode implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 父节点id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点code
     */
    private String code;

    /**
     * 1-显示,0-不显示
     */
    private Byte status;

    /**
     * 操作人
     */
    @Column(name = "operator_id")
    private Integer operatorId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最近更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String PARENT_ID = "parentId";

    public static final String DB_PARENT_ID = "parent_id";

    public static final String NAME = "name";

    public static final String DB_NAME = "name";

    public static final String CODE = "code";

    public static final String DB_CODE = "code";

    public static final String STATUS = "status";

    public static final String DB_STATUS = "status";

    public static final String OPERATOR_ID = "operatorId";

    public static final String DB_OPERATOR_ID = "operator_id";

    public static final String CREATE_TIME = "createTime";

    public static final String DB_CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "updateTime";

    public static final String DB_UPDATE_TIME = "update_time";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", status=").append(status);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static AdminNode defaultInstance() {
        AdminNode instance = new AdminNode();
        instance.parentId = new Integer("0");
        instance.name = new String("");
        instance.code = new String("");
        instance.status = new Byte("1");
        instance.operatorId = new Integer("0");
        return instance;
    }
}