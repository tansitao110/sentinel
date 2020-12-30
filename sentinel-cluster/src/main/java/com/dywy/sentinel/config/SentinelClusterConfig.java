/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dywy.sentinel.config;

import com.alibaba.nacos.api.exception.NacosException;
import com.dywy.sentinel.sentinel.DemoClusterInitFunc;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: sentinel集群配置
 * @Date: 2020/11/19 11:31
 *
 * @author 谭思涛
 * @since JDK 1.8
 */
@Configuration
@EnableConfigurationProperties(SentinelClusterPropertiesConfiguration.class)
public class SentinelClusterConfig {


    /**
     * @Description: 加载配置将bean注入到spring容器
     * @Date: 2020/11/23
     *
     * @Param [sentinelClusterPropertiesConfiguration]
     * @return DemoClusterInitFunc
     * @author 谭思涛
     */
    @Bean
    public DemoClusterInitFunc demoClusterInitFuncService(SentinelClusterPropertiesConfiguration sentinelClusterPropertiesConfiguration) throws NacosException {
        DemoClusterInitFunc demoClusterInitFunc = new DemoClusterInitFunc();
        try {
//            // 这里我们要主动加载DemoClusterInitFunc.init()方法
//            // 也可以通过SPI的方式加载
            DemoClusterInitFunc.groupId = sentinelClusterPropertiesConfiguration.getGroupId();
            DemoClusterInitFunc.nacosNamespace = sentinelClusterPropertiesConfiguration.getNamespace();
            DemoClusterInitFunc.remoteAddress = sentinelClusterPropertiesConfiguration.getServerAddr();
            demoClusterInitFunc.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return demoClusterInitFunc;
    }
}
