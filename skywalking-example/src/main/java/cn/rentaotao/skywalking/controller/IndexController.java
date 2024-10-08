package cn.rentaotao.skywalking.controller;

import cn.rentaotao.skywalking.service.IndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rtt
 * @date 2024/9/27 16:42
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping
    public String get() {
        return indexService.get();
    }
}
