package com.zjut.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * 在开发的时候设置中间件的开关和加入group组，控制其生产和消费(开发的时候可以在idea中添加)
 * idea的environment variables添加dev_params={"dubbo_group":"groupTLF","kafka_topic_switch":"off", "kafka_consumer_groupid":"TLFTest111", "rocketmq_consumer_groupid":"TLFTest222", "rocketmq_topic_switch":"off"}
 */
public class DevParamUtil {
    private static final String json = System.getenv("dev_params");
    private static final JSONObject jsonObject;
    private static final String DUBBO_GROUP = "dubbo_group";
    private static final String KAFKA_TOPIC_SWITCH = "kafka_topic_switch";
    private static final String ROCKETMQ_TOPIC_SWITCH = "rocketmq_topic_switch";
    private static final String KAFKA_CONSUMER_GROUPID = "kafka_consumer_groupid";
    private static final String ROCKETMQ_CONSUMER_GROUPID = "rocketmq_consumer_groupid";

    public DevParamUtil() {
    }

    public static boolean isLocalTest() {
        return StringUtils.isNotEmpty(json);
    }

    public static String getDubboGroupName() {
        String groupName = jsonObject.getString("dubbo_group");
        return StringUtils.isNotEmpty(groupName) ? groupName : null;
    }

    public static boolean isCloseTopic() {
        String isCloseTopic = jsonObject.getString("kafka_topic_switch");
        return StringUtils.isNotEmpty(isCloseTopic) && isCloseTopic.equals("off");
    }

    public static boolean isCloseRocketMqTopic() {
        String isCloseTopic = jsonObject.getString("rocketmq_topic_switch");
        return StringUtils.isNotEmpty(isCloseTopic) && isCloseTopic.equals("off");
    }

    public static String getKafkaConsumerGroupId() {
        return jsonObject.getString("kafka_consumer_groupid");
    }

    public static String getRocketmqConsumerGroupid() {
        return jsonObject.getString("rocketmq_consumer_groupid");
    }

    static {
        if (isLocalTest()) {
            jsonObject = (JSONObject) JSON.parseObject(json, JSONObject.class);
        } else {
            jsonObject = new JSONObject();
        }

    }
}
