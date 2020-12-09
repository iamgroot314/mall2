package com.sk.mall2.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class ImageUtil {

    public static String imagePath(MultipartFile file, String shopName) {
        if (file.isEmpty()) {
            return "false";
        }
        int size = (int) file.getSize();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String path1= request.getSession().getServletContext().getRealPath("/");
        String path=path1+"image";
        System.out.println(path);
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("linux")) {
            path = "/usr/upload";
        }
        String fileName = shopName;
        System.out.println(fileName);
        File dest = new File(path + "/" + fileName);
        System.out.println("保存的绝对路径为:" + dest);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            //根据系统的不同，保存到不同的路径
            file.transferTo(dest);
            return fileName;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return "false";
        }


    }
}
