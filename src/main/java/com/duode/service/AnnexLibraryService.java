package com.duode.service;

import com.duode.mapper.AnnexLibraryMapper;
import com.duode.mapper.ProductMapper;
import com.duode.model.AnnexLibrary;
import com.duode.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class AnnexLibraryService {

    @Autowired
    public AnnexLibraryMapper annexLibraryMapper;

    public int  addAnnexLibrary(AnnexLibrary annexLibrary){
        int  annexLibraryReponse = annexLibraryMapper.addAnnexLibrary(annexLibrary);
        return annexLibraryReponse;
    }


    public int updateAnnexLibrary(AnnexLibrary annexLibrary){
        int code = annexLibraryMapper.updateAnnexLibrary(annexLibrary);
        return code;
    }

    public List<AnnexLibrary> getAnnexLibraryMapperList(){
        List<AnnexLibrary> annexLibraryList= annexLibraryMapper.findAnnexLibrary();
        if (annexLibraryList.size() !=0) {
            return annexLibraryList;
        } else {
            return null;

        }
    }

    public List<AnnexLibrary>  findAnnexLibraryCategory (AnnexLibrary annexLibrary) {
        List<AnnexLibrary>  annexLibraryList = annexLibraryMapper.findAnnexLibraryCategory(annexLibrary);
        if (annexLibraryList.size() !=0) {
            return annexLibraryList;
        } else {
            return null;
        }
    }

    public AnnexLibrary findAnnexLibraryDetail(AnnexLibrary annexLibrary) {
        List<AnnexLibrary> annexLibraryList = annexLibraryMapper.findAnnexLibraryDetail(annexLibrary);
        if ( annexLibraryList.size() !=0) {
            AnnexLibrary annexLibrary1= annexLibraryList.get(0);
            return annexLibrary1;
        } else {
            return null;
        }
    }
}
