/**
 * Copyright (c) 2020 QingLang, Inc. <baisui@qlangtech.com>
 *
 * This program is free software: you can use, redistribute, and/or modify
 * it under the terms of the GNU Affero General Public License, version 3
 * or later ("AGPL"), as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.qlangtech.tis.realtime.utils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.gilt.logback.flume.FlumeLogstashV1Appender;
import com.qlangtech.tis.manage.common.Config;
import com.qlangtech.tis.realtime.transfer.BasicRMListener;
import org.apache.commons.lang.StringUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 百岁（baisui@qlangtech.com）
 * @date 2016年4月15日
 */
public class TisFlumeLogstashV1Appender extends FlumeLogstashV1Appender {

    public static final String ENVIRONMENT_INCR_EXEC_GROUP = "incr_exec_group";

    public TisFlumeLogstashV1Appender() {
        super();
        // this.execGroupName = System.getProperty(TisIncrLauncher.ENVIRONMENT_INCR_EXEC_GROUP);
        // if (StringUtils.isEmpty(execGroupName)) {
        // throw new IllegalArgumentException("param:" + execGroupName + " can not be null");
        // }
        // super.setFlumeAgents(TSearcherConfigFetcher.get().getLogFlumeAddress());
        super.setFlumeAgents(Config.getAssembleHost() + ":" + Config.LogFlumeAddressPORT);
    }

    public void setFlumeAgents(String flumeAgents) {
    }

    @Override
    protected void append(ILoggingEvent eventObject) {
        if (Config.isTestMock()) {
            return;
        }
        super.append(eventObject);
    }

    @Override
    protected Map<String, String> extractHeaders(ILoggingEvent eventObject) {
        Map<String, String> result = super.extractHeaders(eventObject);
        final Map<String, String> mdc = eventObject.getMDCPropertyMap();
        String collection = StringUtils.defaultIfEmpty(mdc.get(BasicRMListener.KEY_COLLECTION), "unknown");
        result.put(BasicRMListener.KEY_COLLECTION, collection);
        return result;
    }

    @Override
    protected HashMap<String, String> createHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put(ENVIRONMENT_INCR_EXEC_GROUP, "tis-incr");
        return headers;
    }
}
