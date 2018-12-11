package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wcl
 * Date:2018-10-22
 * Time:20:37
 */
public interface IFileService {

    String upload(MultipartFile file, String path);

}
