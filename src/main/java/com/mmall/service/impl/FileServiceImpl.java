package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by wcl
 * Date:2018-10-22
 * Time:20:37
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger= LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file,String path){

        String fileName=file.getOriginalFilename();//获取文件名字
        //扩展名
        //abc.jpg
        String fileExtensionName=fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName= UUID.randomUUID().toString()+"."+fileName;
        logger.info("开始上传文件，上传文件的文件夹名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);
        File fileDir = new File(path);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);

        try{
            file.transferTo(targetFile);
            //文件上传成功

            FTPUtil.uploadFile(Lists.newArrayList(targetFile));

            targetFile.delete();
        }catch (IOException e){
            logger.error("上传文件异常",e);
            return null;
        }

        return targetFile.getName();
    }

}
