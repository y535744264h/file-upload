package com.yanhao.demo.tusuppy;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: tus-uppy->DropzoneController
 * @description:
 * @author: yanhao
 * @create: 2020-07-31 14:20
 **/
@Controller
@CrossOrigin
@RequestMapping("/dropzone")
public class DropzoneController {


    @CrossOrigin(origins = "*")
    @RequestMapping("/fileUpload")
    public ResponseEntity<String> fileUpload(HttpServletRequest request, MultipartFile file,DropzoneData dropzoneData) throws IOException {

        if(dropzoneData!=null){
            System.out.println(dropzoneData.toString());
        }

        String mimeType = file.getContentType();
        String filename = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        String last=filename.substring(filename.lastIndexOf("."));
        String uploads = request.getSession().getServletContext().getRealPath("uploads");
//        FileOutputStream out = new FileOutputStream(new File(uploads + File.separator + file.getName()+System.currentTimeMillis()+ last));
//        FileCopyUtils.copy(bytes, out);

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}
