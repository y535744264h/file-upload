package com.yanhao.demo.tusuppy;

import me.desair.tus.server.TusFileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TusUppyApplication {


    @Value("${tus.server.data.directory}")
    protected String tusDataPath;

    @Value("#{servletContext.contextPath}")
    private String servletContextPath;

    public static void main(String[] args) {
        SpringApplication.run(TusUppyApplication.class, args);
    }

//    @Bean
//    public TusFileUploadService tusFileUploadService(AppProperties appProperties) {
//        return new TusFileUploadService().withStoragePath(appProperties.getTusUploadDirectory())
//                .withUploadURI("/upload");
//    }

    @Bean
    public TusFileUploadService tusFileUploadService() {
        return new TusFileUploadService()
                .withStoragePath(tusDataPath)
                .withDownloadFeature()
                .withUploadURI(servletContextPath + "/api/upload")
                .withThreadLocalCache(true);
    }
}
