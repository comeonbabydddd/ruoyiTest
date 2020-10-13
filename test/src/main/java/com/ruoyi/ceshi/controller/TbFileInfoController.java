package com.ruoyi.ceshi.controller;

import java.io.IOException;
import java.util.List;

import com.ruoyi.common.fastdfs.FastDFSClientWrapper;
import com.ruoyi.common.fastdfs.FileInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.ceshi.domain.TbFileInfo;
import com.ruoyi.ceshi.service.ITbFileInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件Controller
 * 
 * @author ruoyi
 * @date 2020-10-12
 */
@Controller
@RequestMapping("/ceshi/fileInfo")
public class TbFileInfoController extends BaseController
{
    private String prefix = "ceshi/fileInfo";

    @Autowired
    private ITbFileInfoService tbFileInfoService;
    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;
    @RequiresPermissions("ceshi:fileInfo:view")
    @GetMapping()
    public String fileInfo()
    {
        return prefix + "/fileInfo";
    }

    /**
     * 查询文件列表
     */
    @RequiresPermissions("ceshi:fileInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbFileInfo tbFileInfo)
    {
        startPage();
        List<TbFileInfo> list = tbFileInfoService.selectTbFileInfoList(tbFileInfo);
        return getDataTable(list);
    }

    /**
     * 导出文件列表
     */
    @RequiresPermissions("ceshi:fileInfo:export")
    @Log(title = "文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TbFileInfo tbFileInfo)
    {
        List<TbFileInfo> list = tbFileInfoService.selectTbFileInfoList(tbFileInfo);
        ExcelUtil<TbFileInfo> util = new ExcelUtil<TbFileInfo>(TbFileInfo.class);
        return util.exportExcel(list, "fileInfo");
    }
    /**
     * 新增上传文件弹出层
     */
    @GetMapping("/addFileTable")
    public String addFileTable()
    {
        return prefix + "/addFileTable";
    }
    /**
     * 新增保存文件
     */
    @RequiresPermissions("ceshi:fileInfo:addFileTableSave")
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping("/addFileTableSave")
    @ResponseBody
    public AjaxResult addFileTableSave(@RequestParam("file") MultipartFile multipartFile) throws Exception {

        try {
            String uploadFile = fastDFSClientWrapper.uploadFile(multipartFile);
            String name = multipartFile.getName();
            TbFileInfo fileInfo = new TbFileInfo();
            fileInfo.setFileUrl(uploadFile);
            fileInfo.setFileName(name);
            return AjaxResult.success(tbFileInfoService.insertTbFileInfo(fileInfo));
        } catch (IOException e) {
            e.printStackTrace();
             throw new Exception(e);
        }
    }
    /**
     * 新增文件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    /**
     * 新增保存文件
     */
    @RequiresPermissions("ceshi:fileInfo:add")
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TbFileInfo tbFileInfo)
    {
        return toAjax(tbFileInfoService.insertTbFileInfo(tbFileInfo));
    }

    /**
     * 修改文件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TbFileInfo tbFileInfo = tbFileInfoService.selectTbFileInfoById(id);
        mmap.put("tbFileInfo", tbFileInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件
     */
    @RequiresPermissions("ceshi:fileInfo:edit")
    @Log(title = "文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TbFileInfo tbFileInfo)
    {
        return toAjax(tbFileInfoService.updateTbFileInfo(tbFileInfo));
    }

    /**
     * 删除文件
     */
    @RequiresPermissions("ceshi:fileInfo:remove")
    @Log(title = "文件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tbFileInfoService.deleteTbFileInfoByIds(ids));
    }
}
