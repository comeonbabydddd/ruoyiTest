package com.ruoyi.ceshi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文件对象 tb_file_info
 * 
 * @author ruoyi
 * @date 2020-10-12
 */
public class TbFileInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String fileUrl;

    /** 删除标识 */
    private String delFlag;

    /** 测试字段 */
    @Excel(name = "测试字段")
    private Long test01;

    /** 测试字段 */
    @Excel(name = "测试字段")
    private Long test02;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setTest01(Long test01) 
    {
        this.test01 = test01;
    }

    public Long getTest01() 
    {
        return test01;
    }
    public void setTest02(Long test02) 
    {
        this.test02 = test02;
    }

    public Long getTest02() 
    {
        return test02;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("fileUrl", getFileUrl())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("test01", getTest01())
            .append("test02", getTest02())
            .toString();
    }
}
