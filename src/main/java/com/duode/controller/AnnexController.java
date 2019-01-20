package com.duode.controller;

import com.duode.constant.ApiStatusCode;
import com.duode.model.AnnexLibrary;
import com.duode.model.Product;
import com.duode.request.CategoryRequest;
import com.duode.response.ResponseDataModel;
import com.duode.service.AnnexLibraryService;
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

    @RequestMapping(value="/addBannner",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getBanner(@RequestBody CategoryRequest categoryRequest) {
        ResponseDataModel response = new ResponseDataModel();

        List<AnnexLibrary> annexLibraryList = new ArrayList<>();

        AnnexLibrary annexLibrary2= new AnnexLibrary();
        annexLibrary2.setCategory(1);
        List<AnnexLibrary> annexLibraryList1=annexLibraryService.findAnnexLibraryCategory(annexLibrary2);
        if (annexLibraryList1!=null) {
            for (AnnexLibrary et: annexLibraryList1) {
                et.setChoose_status(0);
                annexLibraryService.updateAnnexLibrary(et);
            }
        }

        if (categoryRequest.getCategoryList() != null) {
            if (categoryRequest.getCategoryList().size()==3) {
                for (Integer elem : categoryRequest.getCategoryList()) {
                    AnnexLibrary annexLibrary = new AnnexLibrary();
                    annexLibrary.setId(elem);
                    AnnexLibrary annexLibrary1=annexLibraryService.findAnnexLibraryDetail(annexLibrary);
                    annexLibrary.setChoose_status(1);
                    annexLibraryList.add(annexLibrary1);
                }

                response.setData(annexLibraryList);
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            } else {
                response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
            }
        }
        return response;
    }
    @RequestMapping(value="/getAnnexCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getBannner(@RequestBody AnnexLibrary annexLibrary) {
        ResponseDataModel response = new ResponseDataModel();



        List<AnnexLibrary> annexLibraryList = annexLibraryService.findAnnexLibraryCategory(annexLibrary);

        if (annexLibraryList != null) {
            response.setData(annexLibraryList);
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
        } else {
            response.setStatusCode(ApiStatusCode.EMPLOYEE_OPENID_ERROR.value());
        }
        return response;
    }

    @RequestMapping(value="/addLaunch",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addLaunch(@RequestBody CategoryRequest categoryRequest) {
        ResponseDataModel response = new ResponseDataModel();

        List<AnnexLibrary> annexLibraryList = new ArrayList<>();

        if (categoryRequest.getCategoryList() != null) {
            if (categoryRequest.getCategoryList().size()==1) {
                for (Integer elem : categoryRequest.getCategoryList()) {
                    AnnexLibrary annexLibrary = new AnnexLibrary();
                    annexLibrary.setId(elem);
                    AnnexLibrary annexLibrary1=annexLibraryService.findAnnexLibraryDetail(annexLibrary);
                    annexLibrary.setChoose_status(1);
                    annexLibraryList.add(annexLibrary1);
                }

                response.setData(annexLibraryList);
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            } else {
                response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
            }
        }
        return response;
    }

    @RequestMapping(value="/addIndex",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel addIndex(@RequestBody CategoryRequest categoryRequest) {
        ResponseDataModel response = new ResponseDataModel();

        List<AnnexLibrary> annexLibraryList = new ArrayList<>();

        if (categoryRequest.getCategoryList() != null) {
            if (categoryRequest.getCategoryList().size()==1) {
                for (Integer elem : categoryRequest.getCategoryList()) {
                    AnnexLibrary annexLibrary = new AnnexLibrary();
                    annexLibrary.setId(elem);
                    AnnexLibrary annexLibrary1=annexLibraryService.findAnnexLibraryDetail(annexLibrary);
                    annexLibrary.setChoose_status(1);
                    annexLibraryList.add(annexLibrary1);
                }

                response.setData(annexLibraryList);
                response.setStatusCode(ApiStatusCode.SUCCESS.value());
            } else {
                response.setStatusCode(ApiStatusCode.ADD_CARD_FAILURE.value());
            }
        }
        return response;
    }

    @RequestMapping(value="/getAllCategory",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDataModel getAllCategory(@RequestBody CategoryRequest categoryRequest) {
        ResponseDataModel response = new ResponseDataModel();

        AnnexLibrary annexLibrary = new AnnexLibrary();
        annexLibrary.setCategory(categoryRequest.getCategory());
        List<AnnexLibrary> annexLibraryList = annexLibraryService.findAnnexLibraryCategory(annexLibrary);

        if (annexLibraryList != null) {
            response.setStatusCode(ApiStatusCode.SUCCESS.value());
            response.setData(annexLibraryList);
        } else {
            response.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
        }
        return response;
    }




}
