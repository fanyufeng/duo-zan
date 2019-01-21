package com.duode.mapper;

import com.duode.model.File;
import com.duode.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/23
 */
public interface FileMapper {
    public List<File> findFileInfo(@Param("id") int id);
    public int addFile(File file);
    public int updateFile(@Param("file") File file);
    public List<File> findFile();
    public List<File> findFileByCategory(@Param("file") File file);
}
