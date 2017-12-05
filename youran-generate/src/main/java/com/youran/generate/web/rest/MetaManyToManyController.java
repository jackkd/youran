package com.youran.generate.web.rest;

import com.youran.common.pojo.vo.ReplyVO;
import com.youran.generate.constant.GenerateConst;
import com.youran.generate.pojo.dto.MetaManyToManyAddDTO;
import com.youran.generate.pojo.dto.MetaManyToManyQueryDTO;
import com.youran.generate.pojo.dto.MetaManyToManyUpdateDTO;
import com.youran.generate.pojo.po.MetaManyToManyPO;
import com.youran.generate.pojo.vo.MetaManyToManyListVO;
import com.youran.generate.pojo.vo.MetaManyToManyShowVO;
import com.youran.generate.service.MetaManyToManyService;
import com.youran.generate.web.api.MetaManyToManyAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Title:多对多关联控制器
 * Description:
 * Author: cbb
 * Create Time:2017/5/12 13:42
 */
@RestController
@RequestMapping(GenerateConst.GENERATE_ROOT_PATH + "/meta_mtm")
public class MetaManyToManyController implements MetaManyToManyAPI {

    @Autowired
    private MetaManyToManyService metaManyToManyService;

    @Override
    @PostMapping(value = "/save")
    public ReplyVO<Integer> save(@Valid @RequestBody MetaManyToManyAddDTO metaManyToManyAddDTO) {
        MetaManyToManyPO metaManyToManyPO = metaManyToManyService.save(metaManyToManyAddDTO);
        ReplyVO<Integer> result = ReplyVO.success();
        result.setData(metaManyToManyPO.getMtmId());
        return result;
    }

    @Override
    @PutMapping(value = "/update")
    public ReplyVO<Void> update(@Valid @RequestBody MetaManyToManyUpdateDTO metaManyToManyUpdateDTO) {
        metaManyToManyService.update(metaManyToManyUpdateDTO);
        ReplyVO<Void> result = ReplyVO.success();
        return result;
    }

    @Override
    @PostMapping(value = "/list")
    public ReplyVO<List<MetaManyToManyListVO>> list(@Valid @RequestBody MetaManyToManyQueryDTO metaManyToManyQueryDTO) {
        List<MetaManyToManyListVO> list = metaManyToManyService.list(metaManyToManyQueryDTO);
        ReplyVO<List<MetaManyToManyListVO>> result = ReplyVO.success();
        result.setData(list);
        return result;
    }

    @Override
    @GetMapping(value = "/{mtmId}")
    public ReplyVO<MetaManyToManyShowVO> show(@PathVariable Integer mtmId) {
        MetaManyToManyShowVO metaManyToManyShowVO = metaManyToManyService.show(mtmId);
        ReplyVO<MetaManyToManyShowVO> result = ReplyVO.success();
        result.setData(metaManyToManyShowVO);
        return result;
    }

    @Override
    @DeleteMapping(value = "/{mtmId}")
    public ReplyVO<Integer> delete(@PathVariable Integer mtmId) {
        int count = metaManyToManyService.delete(mtmId);
        ReplyVO<Integer> result = ReplyVO.success();
        result.setData(count);
        return result;
    }

    @Override
    @PostMapping(value = "deleteBatch")
    public ReplyVO<Integer> deleteBatch(@RequestBody Integer[] mtmId) {
        if(ArrayUtils.isEmpty(mtmId)){
            return ReplyVO.fail("参数为空");
        }
        int count = metaManyToManyService.delete(mtmId);
        ReplyVO<Integer> result = ReplyVO.success();
        result.setData(count);
        return result;
    }
}