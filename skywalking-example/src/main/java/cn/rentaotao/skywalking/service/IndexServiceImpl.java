package cn.rentaotao.skywalking.service;

import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.stereotype.Service;

/**
 * @author rtt
 * @date 2024/9/27 16:43
 */
@Service
public class IndexServiceImpl implements IndexService{

    @Override
    @Trace(operationName = "indexOperation")
    public String get() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // no-op
        }
        return "ok";
    }
}
