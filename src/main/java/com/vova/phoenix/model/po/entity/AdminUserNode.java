package com.vova.phoenix.model.po.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "admin_user_node")
public class AdminUserNode implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "id")
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
    @Column(name = "status")
    private Integer status;

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
    @Column(name = "node_id_list")
    private java.util.List<Integer> nodeIdList;

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

    public static final String NODE_ID_LIST = "nodeIdList";

    public static final String DB_NODE_ID_LIST = "node_id_list";

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
        sb.append(", nodeIdList=").append(nodeIdList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}