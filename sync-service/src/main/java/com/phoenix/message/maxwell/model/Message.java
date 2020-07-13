
package com.phoenix.message.maxwell.model;

import lombok.Data;

import java.util.Map;

@Data
public class Message {

    private String database;
    private String table;
    private String type;
    private Integer ts;
    private Integer xid;
    private Boolean commit;
    private Map<String, Object> data;
    private Map<String, Object> old;

}
