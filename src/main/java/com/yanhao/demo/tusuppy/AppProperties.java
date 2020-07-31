package com.yanhao.demo.tusuppy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: tus-uppy->AppProperties
 * @description:
 * @author: yanhao
 * @create: 2020-07-30 10:10
 **/

@ConfigurationProperties(prefix = "app")
@Component
public class AppProperties {

    private String tusUploadDirectory;

    private String appUploadDirectory;

    public String getTusUploadDirectory() {
        return this.tusUploadDirectory;
    }

    public void setTusUploadDirectory(String tusUploadDirectory) {
        this.tusUploadDirectory = tusUploadDirectory;
    }

    public String getAppUploadDirectory() {
        return this.appUploadDirectory;
    }

    public void setAppUploadDirectory(String appUploadDirectory) {
        this.appUploadDirectory = appUploadDirectory;
    }
}
