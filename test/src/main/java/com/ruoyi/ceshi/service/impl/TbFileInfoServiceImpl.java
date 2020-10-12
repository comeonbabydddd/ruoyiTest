package com.ruoyi.ceshi.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ceshi.mapper.TbFileInfoMapper;
import com.ruoyi.ceshi.domain.TbFileInfo;
import com.ruoyi.ceshi.service.ITbFileInfoService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.framework.util.ShiroUtils;

/**
 * 文件Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-12
 */
@Service
public class TbFileInfoServiceImpl implements ITbFileInfoService 
{
    @Autowired
    private TbFileInfoMapper tbFileInfoMapper;

    /**
     * 查询文件
     * 
     * @param id 文件ID
     * @return 文件
     */
    @Override
    public TbFileInfo selectTbFileInfoById(Long id)
    {
        return tbFileInfoMapper.selectTbFileInfoById(id);
    }

    /**
     * 查询文件列表
     * 
     * @param tbFileInfo 文件
     * @return 文件
     */
    @Override
    public List<TbFileInfo> selectTbFileInfoList(TbFileInfo tbFileInfo)
    {
        return tbFileInfoMapper.selectTbFileInfoList(tbFileInfo);
    }

    /**
     * 新增文件
     * 
     * @param tbFileInfo 文件
     * @return 结果
     */
    @Override
    public int insertTbFileInfo(TbFileInfo tbFileInfo)
    {
        tbFileInfo.setDelFlag("0");
        tbFileInfo.setCreateBy(String.valueOf(ShiroUtils.getSysUser().getUserId()));
        tbFileInfo.setCreateTime(DateUtils.getNowDate());
        return tbFileInfoMapper.insertTbFileInfo(tbFileInfo);
    }

    /**
     * 修改文件
     * 
     * @param tbFileInfo 文件
     * @return 结果
     */
    @Override
    public int updateTbFileInfo(TbFileInfo tbFileInfo)
    {
        tbFileInfo.setCreateBy(String.valueOf(ShiroUtils.getSysUser().getUserId()));
        tbFileInfo.setUpdateTime(DateUtils.getNowDate());
        return tbFileInfoMapper.updateTbFileInfo(tbFileInfo);
    }

    /**
     * 删除文件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTbFileInfoByIds(String ids)
    {
        return tbFileInfoMapper.deleteTbFileInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文件信息
     * 
     * @param id 文件ID
     * @return 结果
     */
    @Override
    public int deleteTbFileInfoById(Long id)
    {
        return tbFileInfoMapper.deleteTbFileInfoById(id);
    }
}
