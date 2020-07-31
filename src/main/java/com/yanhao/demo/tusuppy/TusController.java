package com.yanhao.demo.tusuppy;

import me.desair.tus.server.TusFileUploadService;
import me.desair.tus.server.exception.TusException;
import me.desair.tus.server.upload.UploadInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @program: tus-uppy->TusController
 * @description:
 * @author: yanhao
 * @create: 2020-07-30 09:52
 **/

@Controller
@CrossOrigin(exposedHeaders = {"Location", "Upload-Offset"})
@RequestMapping("/api/upload")
public class TusController {

    @Value("${tus.server.data.directory}")
    protected String tusDataPath;


    private final Path uploadDirectory;

    private final Path tusUploadDirectory;

    @Autowired
    private TusFileUploadService tusFileUploadService;

    public TusController(AppProperties appProperties) {
        //TODO 待优化
        this.uploadDirectory = Paths.get(appProperties.getAppUploadDirectory());
        try {
            Files.createDirectories(this.uploadDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.tusUploadDirectory = Paths.get(appProperties.getTusUploadDirectory());
    }

    @RequestMapping(value = {"", "/**"}, method = {RequestMethod.POST, RequestMethod.PATCH, RequestMethod.HEAD,
            RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.GET})
    public void processUpload(final HttpServletRequest servletRequest, final HttpServletResponse servletResponse) throws IOException {
        tusFileUploadService.process(servletRequest, servletResponse);

        String uploadURI = servletRequest.getRequestURI();
        UploadInfo uploadInfo = null;
        try {
            uploadInfo = this.tusFileUploadService.getUploadInfo(uploadURI);
            //--- 打印日志---
            if(uploadInfo!=null){
                System.out.println("--- id="+uploadInfo.getId()+"---");
                System.out.println("--- fileName="+uploadInfo.getFileName()+"---");
                System.out.println("--- offset="+uploadInfo.getOffset()+"---");
                System.out.println("--- fileMimeType="+uploadInfo.getFileMimeType()+"---");
                System.out.println("--- length="+uploadInfo.getLength()+" ---");
                System.out.println("--- uploadConcatHeaderValue="+uploadInfo.getUploadConcatHeaderValue()+"---");
            }
            //

        } catch (TusException e) {
            e.printStackTrace();
        }
        //当最后一块数据上传完成时 uploadInfo.isUploadInProgress()返回false
        if (uploadInfo != null && !uploadInfo.isUploadInProgress()) {
            try (InputStream is = this.tusFileUploadService.getUploadedBytes(uploadURI)) {
                Path output = this.uploadDirectory.resolve(uploadInfo.getFileName());
                Files.copy(is, output, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException | TusException e) {
                e.printStackTrace();
            }
            try {
                this.tusFileUploadService.deleteUpload(uploadURI);
            } catch (IOException | TusException e) {
                e.printStackTrace();
            }
        }

    }

}
