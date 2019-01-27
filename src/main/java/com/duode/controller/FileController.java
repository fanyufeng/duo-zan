package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.File;
import com.duode.response.ResponseDataModel;
import com.duode.service.CardService;
import com.duode.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    public FileService fileService;

    @Autowired
    public CardService cardService;





    @RequestMapping(value="/getFileDetail",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getFile(@RequestBody File file) {
        ResponseDataModel response = new ResponseDataModel();
        List<File> code = fileService.getFile(file.getId());
        if (code!=null){
            response.setData(code);
            response.setStatusCode(ApiStatusCode.SUCCESS.value());

        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addFile(@RequestBody File file) {
        ResponseDataModel response = new ResponseDataModel();
        File code = fileService.addFile(file);
        if (code!=null){
            response.setData(code);
            response.setStatusCode(ApiStatusCode.SUCCESS.value());

        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel updateFileStatus(@RequestBody File file){
        ResponseDataModel response = new ResponseDataModel();
        int code = fileService.updateFileStatus(file);
        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }


    @RequestMapping(value="/getFileList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getFileList(@RequestBody File file){
        ResponseDataModel response = new ResponseDataModel();
        List<File> fileList = fileService.getfileList();
        if (fileList !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(fileList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }

    @RequestMapping(value="/changeFrequency", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addFrequency(@RequestBody File file){
        ResponseDataModel response = new ResponseDataModel();
        List<File> fileList = fileService.getFile(file.getId());
        if (fileList !=null) {
            File rt = fileList.get(0);
            rt.setFrequency(rt.getFrequency() - 1);
            if ((rt.getFrequency()-1)==0) {
                rt.setStatus(0);
            }
            fileService.updateFile(rt);
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(fileList);
        } else {
            response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
        }
        return response;
    }
}
