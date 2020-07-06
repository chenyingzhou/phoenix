package com.phoenix.message.kafka;

import com.phoenix.message.model.vo.maxwell.Message;
import com.phoenix.message.model.po.entity.TaskConfig;
import com.phoenix.message.service.TaskService;
import com.phoenix.message.util.JacksonUtil;
import com.phoenix.message.util.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Component
@Slf4j
public class BinlogConsumer implements Consumer {

    protected final DataSource dataSource;

    protected final JdbcTemplate jdbcTemplate;

    @Resource
    protected TaskService taskService;

    protected BinlogConsumer(@Autowired DataSource dataSource, @Autowired JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @KafkaListener(topics = {"${maxwell.topics.task_config}"}, groupId = "${maxwell.group-id}")
    public void processBinlog(String content) {
        try {
            var maxwellMessage = JacksonUtil.toObject(content, Message.class);
            assert maxwellMessage != null;
            var table = maxwellMessage.getTable();
            var insert = maxwellMessage.getType().equals("insert");
            var lowerCamelMap = MapUtil.toLowerCamelKeys(maxwellMessage.getData());
            switch (table) {
                case "task_config":
                    var taskConfig = JacksonUtil.transObject(lowerCamelMap, TaskConfig.class);
                    if (insert) {
                        taskService.insertTaskConfig(taskConfig);
                    } else {
                        taskService.updateTaskConfig(taskConfig);
                    }
                    System.out.println("hello");
                default:
            }
        } catch (Throwable $e) {
            log.error("something wrong with binlog: " + content);
        }
    }

}
