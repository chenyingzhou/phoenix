package com.vova.phoenix.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class BinlogConsumer implements Consumer {

    protected final DataSource dataSource;

    protected final JdbcTemplate jdbcTemplate;

    protected BinlogConsumer(@Autowired DataSource dataSource, @Autowired JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @KafkaListener(topics = "maxwell", groupId = "")
    public void processAppInstallRecord(String content) {
        System.out.println(content);
        this.save(content, new String[]{"id"});
    }

    public void save(String binlogJson, String[] condition) {
        var fieldStr = "";
        var type = "";
        var sqlWhere = "";
        var table = "";

        String sql;
        switch (type) {
            case "update":
                if (!"".equals(sqlWhere)) {
                    sql = "update `" + table + "` set " + fieldStr + sqlWhere;
                    jdbcTemplate.update(sql);
                }
                break;
            case "insert":
                sql = "insert ignore into `" + table + "` set " + fieldStr;
                jdbcTemplate.update(sql);
                break;
            case "delete":
                if (!"".equals(sqlWhere)) {
                    sql = "delete from `" + table + "` " + sqlWhere;
                    jdbcTemplate.update(sql);
                }
                break;
            default:
        }
    }
}
