package com.duode.service;

import com.duode.mapper.FileMapper;
import com.duode.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fanyufeng in 18/12/25
 */
@Service
public class FileService {

    @Autowired
    public FileMapper fileMapper;

    public List<File>  getFile(int file_id){
        List<File>  fileReponse = fileMapper.findFileInfo(file_id);

        if(fileReponse.size()==0) {
            return null;
        } else {
            return fileReponse;
        }

    }

    public File  addFile(File file){
        int  fileReponse = fileMapper.addFile(file);
        return file;
    }


    public int updateFile(File file){
        int code = fileMapper.updateFile(file);
        return code;
    }

    public int updateFileStatus(File file){
        int code = fileMapper.updateFileStatus(file);
        return code;
    }

    public int updateFileDetail(File file){
        int code = fileMapper.updateFileDetail(file);
        return code;
    }
    public int updateFileCategory(File file){
        int code = fileMapper.updateFileCategory(file);
        return code;
    }

    public List<File> getfileList(){
        List<File> fileList= fileMapper.findFile();
        if (((List) fileList).size() !=0) {
            return fileList;
        } else {
            return null;

        }
    }

    public List<File> getfileByCategory(File file){
        List<File> fileList= fileMapper.findFileByCategory(file);
        if (((List) fileList).size() !=0) {
            return fileList;
        } else {
            return null;

        }
    }
    public List<File> getfileByCategoryAll(File file){
        List<File> fileList= fileMapper.findFileByCategoryAll(file);
        if (((List) fileList).size() !=0) {
            return fileList;
        } else {
            return null;

        }
    }
}
