package com.phoenix.message.sync.consumer;

import com.phoenix.message.sync.Consumer;
import com.phoenix.message.sync.model.Message;
//import com.phoenix.message.common.model.po.entity.TaskConfig;
//import com.phoenix.message.common.service.TaskService;
import com.phoenix.message.common.util.JacksonUtil;
import com.phoenix.message.common.util.MapUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
@Slf4j
public class TaskConfigConsumer implements Consumer {

//    @Resource
//    protected TaskService taskService;

    @KafkaListener(topics = {"${maxwell.topics.task_config}"}, groupId = "${maxwell.group-id}")
    public void processMessage(String content) {
        try {
//            var maxwellMessage = JacksonUtil.toObject(content, Message.class);
//            assert maxwellMessage != null;
//            boolean insert = maxwellMessage.getType().equals("insert");
//            Map<String, Object> lowerCamelMap = MapUtil.toLowerCamelKeys(maxwellMessage.getData());
//            TaskConfig taskConfig = JacksonUtil.transObject(lowerCamelMap, TaskConfig.class);
//            if (insert) {
//                taskService.insertTaskConfig(taskConfig);
//            } else {
//                taskService.updateTaskConfig(taskConfig);
//            }
        } catch (Throwable $e) {
            log.error("something wrong with binlog: " + content);
        }
    }

}
