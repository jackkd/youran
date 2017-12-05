package com.youran.generate.web.rest;

import com.youran.common.pojo.vo.PageVO;
import com.youran.common.pojo.vo.ReplyVO;
import com.youran.generate.constant.GenerateConst;
import com.youran.generate.pojo.dto.MetaProjectAddDTO;
import com.youran.generate.pojo.dto.MetaProjectQueryDTO;
import com.youran.generate.pojo.dto.MetaProjectUpdateDTO;
import com.youran.generate.pojo.po.MetaProjectPO;
import com.youran.generate.pojo.vo.MetaProjectListVO;
import com.youran.generate.pojo.vo.MetaProjectShowVO;
import com.youran.generate.service.MetaProjectService;
import com.youran.generate.web.api.MetaProjectAPI;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Title:元数据项目控制器
 * Description:
 * Author: cbb
 * Create Time:2017/5/24
 */
@RestController
@RequestMapping(GenerateConst.GENERATE_ROOT_PATH + "/meta_project")
public class MetaProjectController implements MetaProjectAPI {

    @Autowired
    private MetaProjectService metaProjectService;

    @Override
    @PostMapping(value = "/save")
    public ReplyVO<Integer> save(@Valid @RequestBody MetaProjectAddDTO metaProjectAddDTO) {
        MetaProjectPO metaProjectPO = metaProjectService.save(metaProjectAddDTO);
        ReplyVO<Integer> result = ReplyVO.success();
        result.setData(metaProjectPO.getProjectId());
        return result;
    }

    @Override
    @PutMapping(value = "/update")
    public ReplyVO<Void> update(@Valid @RequestBody MetaProjectUpdateDTO metaProjectUpdateDTO) {
        metaProjectService.update(metaProjectUpdateDTO);
        ReplyVO<Void> result = ReplyVO.success();
        return result;
    }

    @Override
    @PostMapping(value = "/list")
    public ReplyVO<PageVO<MetaProjectListVO>> list(@Valid @RequestBody MetaProjectQueryDTO metaProjectQueryDTO) {
        PageVO<MetaProjectListVO> page = metaProjectService.list(metaProjectQueryDTO);
        ReplyVO<PageVO<MetaProjectListVO>> result = ReplyVO.success();
        result.setData(page);
        return result;
    }

    @Override
    @GetMapping(value = "/{projectId}")
    public ReplyVO<MetaProjectShowVO> show(@PathVariable Integer projectId) {
        MetaProjectShowVO metaProjectShowVO = metaProjectService.show(projectId);
        ReplyVO<MetaProjectShowVO> result = ReplyVO.success();
        result.setData(metaProjectShowVO);
        return result;
    }

    @Override
    @DeleteMapping(value = "/{projectId}")
    public ReplyVO<Integer> delete(@PathVariable Integer projectId) {
        int count = metaProjectService.delete(projectId);
        ReplyVO<Integer> result = ReplyVO.success();
        result.setData(count);
        return result;
    }

    @Override
    @PostMapping(value = "deleteBatch")
    public ReplyVO<Integer> deleteBatch(@RequestBody Integer[] projectId) {
        if(ArrayUtils.isEmpty(projectId)){
            return ReplyVO.fail("参数为空");
        }
        int count = metaProjectService.delete(projectId);
        ReplyVO<Integer> result = ReplyVO.success();
        result.setData(count);
        return result;
    }
}