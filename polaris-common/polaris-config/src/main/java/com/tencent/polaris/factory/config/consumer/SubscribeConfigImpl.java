/*
 * Tencent is pleased to support the open source community by making Polaris available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.polaris.factory.config.consumer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.polaris.api.config.consumer.SubscribeConfig;
import com.tencent.polaris.factory.config.plugin.PluginConfigImpl;


/**
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 */
public class SubscribeConfigImpl  extends PluginConfigImpl implements SubscribeConfig {

    @JsonProperty
    private int threadPoolSize = 1;

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    @Override
    public void verify() {
        if (threadPoolSize < 1) {
            throw new IllegalArgumentException("threadPoolSize cannot less then 1");
        }
    }

    @Override
    public void setDefault(Object defaultObject) {
        if (null != defaultObject) {
            SubscribeConfigImpl subscribeConfig = (SubscribeConfigImpl) defaultObject;
            if (threadPoolSize < 1) {
                setThreadPoolSize(subscribeConfig.getThreadPoolSize());
            }
            setDefaultPluginConfig(subscribeConfig);
        }
    }

    @Override
    public int getThreadPoolSize() {
        return threadPoolSize;
    }
}
