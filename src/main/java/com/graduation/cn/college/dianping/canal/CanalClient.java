package com.graduation.cn.college.dianping.canal;

import com.alibaba.google.common.collect.Lists;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
public class CanalClient implements DisposableBean {

    private CanalConnector canalConnector;

    public CanalConnector getCanalConnector() {
        canalConnector = CanalConnectors.newClusterConnector(Lists.newArrayList(
                new InetSocketAddress(
                        "127.0.0.1",11111)),
                "example","canal","canal"
        );
        canalConnector.connect();
        canalConnector.subscribe();
        canalConnector.rollback();
        return canalConnector;
    }

    @Override
    public void destroy() throws Exception {
        if (canalConnector != null) {
            canalConnector.disconnect();
        }
    }
}
