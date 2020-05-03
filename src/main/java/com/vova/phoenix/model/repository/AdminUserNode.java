package com.vova.phoenix.model.repository;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "admin_user_node")
public class AdminUserNode implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * user_id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 状态
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

    /**
     * 节点id
     */
    @Column(name = "node_ids")
    private String nodeIds;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String USER_ID = "userId";

    public static final String DB_USER_ID = "user_id";

    public static final String STATUS = "status";

    public static final String DB_STATUS = "status";

    public static final String OPERATOR_ID = "operatorId";

    public static final String DB_OPERATOR_ID = "operator_id";

    public static final String CREATE_TIME = "createTime";

    public static final String DB_CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "updateTime";

    public static final String DB_UPDATE_TIME = "update_time";

    public static final String NODE_IDS = "nodeIds";

    public static final String DB_NODE_IDS = "node_ids";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", nodeIds=").append(nodeIds);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static AdminUserNode defaultInstance() {
        AdminUserNode instance = new AdminUserNode();
        instance.userId = new Integer("0");
        instance.status = new Byte("1");
        instance.operatorId = new Integer("0");
        return instance;
    }
}