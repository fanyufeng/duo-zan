package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.AnnexLibrary;
import com.duode.model.File;
import com.duode.model.Product;
import com.duode.request.CategoryRequest;
import com.duode.response.ResponseDataModel;
import com.duode.service.AnnexLibraryService;
import com.duode.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanyufeng in 19/1/20
 */
@RestController
@RequestMapping("/annex")
public class AnnexController {

    @Autowired
    public AnnexLibraryService annexLibraryService;


    @Autowired
    public FileService fileService;

    @RequestMapping(value="/addFile",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addBannner(@RequestBody File file) {
        ResponseDataModel response = new ResponseDataModel();
        if (file != null) {
            File filex =fileService.addFile(file);
            if (filex != null) {
                response.setData(filex);
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            } else {
                response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
            }
        }

        return response;
    }

    @RequestMapping(value="/getAll",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getAllCategory(@RequestBody CategoryRequest categoryRequest) {
        ResponseDataModel response = new ResponseDataModel();

        List<File> annexLibraryList = fileService.getfileList();

        if (annexLibraryList != null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(annexLibraryList);
        } else {
            response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
        }
        return response;
    }

    @RequestMapping(value="/changeCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel changeCategory(@RequestBody File file) {
        ResponseDataModel response = new ResponseDataModel();

        int code = fileService.updateFile(file);

        if (code ==1) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
        }
        return response;
    }


    @RequestMapping(value="/getCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getCategory(@RequestBody File file) {
        ResponseDataModel response = new ResponseDataModel();

        List<File> code = fileService.getfileByCategory(file);

        if (code !=null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(code);
        } else {
            response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
        }
        return response;
    }



}
