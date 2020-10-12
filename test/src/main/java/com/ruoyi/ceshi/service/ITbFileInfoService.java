package com.ruoyi.ceshi.service;

import java.util.List;
import com.ruoyi.ceshi.domain.TbFileInfo;

/**
 * 文件Service接口
 * 
 * @author ruoyi
 * @date 2020-10-12
 */
public interface ITbFileInfoService 
{
    /**
     * 查询文件
     * 
     * @param id 文件ID
     * @return 文件
     */
    public TbFileInfo selectTbFileInfoById(Long id);

    /**
     * 查询文件列表
     * 
     * @param tbFileInfo 文件
     * @return 文件集合
     */
    public List<TbFileInfo> selectTbFileInfoList(TbFileInfo tbFileInfo);

    /**
     * 新增文件
     * 
     * @param tbFileInfo 文件
     * @return 结果
     */
    public int insertTbFileInfo(TbFileInfo tbFileInfo);

    /**
     * 修改文件
     * 
     * @param tbFileInfo 文件
     * @return 结果
     */
    public int updateTbFileInfo(TbFileInfo tbFileInfo);

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTbFileInfoByIds(String ids);

    /**
     * 删除文件信息
     * 
     * @param id 文件ID
     * @return 结果
     */
    public int deleteTbFileInfoById(Long id);
}
