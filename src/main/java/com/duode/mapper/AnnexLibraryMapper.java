package com.duode.mapper;

import com.duode.model.AnnexLibrary;
import com.duode.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface AnnexLibraryMapper {

    public List<AnnexLibrary> findAnnexLibraryDetail(@Param("annexLibrary") AnnexLibrary annexLibrary);
    public int addAnnexLibrary(@Param("annexLibrary") AnnexLibrary annexLibrary);
    public int updateAnnexLibrary(@Param("annexLibrary") AnnexLibrary annexLibrary);
    public List<AnnexLibrary> findAnnexLibrary();
    public List<AnnexLibrary> findAnnexLibraryCategory(@Param("annexLibrary") AnnexLibrary annexLibrary);

}
