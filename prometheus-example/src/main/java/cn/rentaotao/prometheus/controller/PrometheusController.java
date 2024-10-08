package cn.rentaotao.prometheus.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rtt
 * @date 2024/10/8 10:55
 */
@RestController
@RequestMapping("/index")
public class PrometheusController {

    private final MeterRegistry meterRegistry;

    public PrometheusController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @RequestMapping
    public String get(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        /*
            counter     计数器
            gauge       仪表盘
            histogram   直方图
            summary     摘要
         */
        // 统计 tags: k, v, k, v
        meterRegistry.counter("PrometheusController", "from", remoteAddr, "method", "get").increment();
        return "ok";
    }
}
