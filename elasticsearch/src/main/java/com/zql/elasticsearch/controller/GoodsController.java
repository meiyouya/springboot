package com.zql.elasticsearch.controller;

import com.zql.elasticsearch.entity.GoodsInfo;
import com.zql.elasticsearch.repository.GoodsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/es")
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 新增一个文档
     * @return
     */
    @GetMapping("/save")
    public String save() {
        GoodsInfo goodsInfo = new GoodsInfo(UUID.randomUUID().toString(), "测试商品", "这是用来测试的商品");
        log.info(goodsInfo.toString());
        goodsRepository.save(goodsInfo);
        return "success";
    }

    /**
     * 删除一个文档
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public String delete(String id) {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setId(id);
        goodsRepository.delete(goodsInfo);
        return "success";
    }

    /**
     * 根据id获取文档
     * @param id
     * @return
     */
    @GetMapping("/get")
    public GoodsInfo getOne(String id) {
        Optional<GoodsInfo> goodsInfoOptional = goodsRepository.findById(id);
        log.info(goodsInfoOptional.get().toString());
        return goodsInfoOptional.isPresent()?goodsInfoOptional.get():null;
    }
}
