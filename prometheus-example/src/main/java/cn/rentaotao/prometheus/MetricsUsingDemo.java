package cn.rentaotao.prometheus;


import io.micrometer.core.instrument.Metrics;
/**
 * @author rtt
 * @date 2024/10/8 15:44
 */
public class MetricsUsingDemo {


    /**
     * 配置 {@link io.micrometer.core.instrument.distribution.DistributionStatisticConfig}
     */
    public void timer() {
        // 打点记录每次任务的执行时间，默认不能超过1分钟
        Metrics.timer("my-name", "my-tag1", "my-tag2").record(() -> {
            // do something
        });
    }

    /**
     * 用来执行时间比较长的任务
     */
    public void longTaskTimer() {
        Metrics.more().longTaskTimer("my-name-long", "my-tags1", "my-tags2").record(() -> {
            // do something
        });
    }

    /**
     * 计数
     */
    public void counter() {
        Metrics.counter("name", "tag1", "tag2").increment();
    }
}
