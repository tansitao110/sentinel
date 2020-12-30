package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 谭思涛
 * @Description: nacos配置
 * @Date: 2020/11/17
 * @since JDK 1.8
 */
@Data
@ConfigurationProperties(prefix = "sentinel.nacos")
public class NacosPropertiesConfiguration {
    private String serverAddr;
    private String dataId;
    private String groupId = "DEFAULT_GROUP";
    private String namespace;
}
