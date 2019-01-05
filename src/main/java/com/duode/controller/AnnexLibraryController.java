package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.AnnexLibrary;
import com.duode.model.Product;
import com.duode.response.ResponseDataModel;
import com.duode.response.UploadResponse;
import com.duode.service.AnnexLibraryService;
import com.duode.service.ProductService;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/annexLibrary")
public class AnnexLibraryController {
    private Logger logger = Logger.getLogger(AnnexLibraryController.class);
    @Autowired
    public AnnexLibraryService annexLibraryService;

    private Image img;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addAnnexLibrary(@RequestBody AnnexLibrary annexLibrary) {
        ResponseDataModel response = new ResponseDataModel();
        int code = annexLibraryService.addAnnexLibrary(annexLibrary);
        if (code==1){
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateAnnexLibrary(@RequestBody AnnexLibrary annexLibrary){
        ResponseDataModel response = new ResponseDataModel();
        int code = annexLibraryService.updateAnnexLibrary(annexLibrary);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getAnnexLibraryList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getAnnexLibraryList(@RequestBody AnnexLibrary annexLibrary){
        ResponseDataModel response = new ResponseDataModel();
        List<AnnexLibrary> annexLibraryList = annexLibraryService.getAnnexLibraryMapperList();
        if (annexLibraryList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(annexLibraryList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    /**
     *  文件上传
     * @return
     */
    @RequestMapping(value="/fileSave",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel fileUpload(HttpServletRequest request) throws Exception{
        ResponseDataModel resDataModel = new ResponseDataModel();
        try{
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
            if(multipartResolver.isMultipart(request)){
                AnnexLibrary annexLibrary=new AnnexLibrary();
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
                //取得request中的所有文件名
                Iterator<String> iter = multiRequest.getFileNames();
                while(iter.hasNext()){
                    //记录上传过程起始时的时间，用来计算上传时间
                    int pre = (int) System.currentTimeMillis();
                    //取得上传文件
                    MultipartFile file = multiRequest.getFile(iter.next());
                    if(file != null){
                        //取得当前上传文件的文件名称
                        String myFileName = file.getOriginalFilename();
                        //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                        if(myFileName.trim()!=""){
                            System.out.println(myFileName);
                            //重命名上传后的文件名
                            String fileName = file.getOriginalFilename();
                            UUID uuid = UUID.randomUUID();
                            String fileEnd = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
                            String changefileName=uuid.toString()+"."+fileEnd;
                            //定义上传路径
                            String path = "/duode/dituo/images/" + changefileName;
                            String xpath="/images/" + changefileName;

                            annexLibrary.setFile_path(path);
                            annexLibrary.setFile_name(changefileName);

                            annexLibraryService.addAnnexLibrary(annexLibrary);

                            File localFile = new File(path);

                            file.transferTo(localFile);
                            UploadResponse uploadResponse=new UploadResponse();
                            uploadResponse.setFileName(xpath);
                            uploadResponse.setFilePath(path);
                            uploadResponse.setStatus(1);
                            resDataModel.setData(uploadResponse);
                            
                        }

                    }
                    //记录上传该文件后的时间
                    int finaltime = (int) System.currentTimeMillis();
                    System.out.println("fanyufeng"+(finaltime - pre));

                }
            }
            resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());

        }catch(Exception e){
            logger.error("文件上传失败,原因{}");
        }
        System.out.println(resDataModel.toString());
        return resDataModel;
    }

}
