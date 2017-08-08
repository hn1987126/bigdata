package cn.jhsoft.study.iostream;

import java.io.File;

/**
 * Created by chen on 2017/8/8.
 */
public class FileFilter implements java.io.FileFilter {

    private String extName;

    public FileFilter(String extName) {
        this.extName = extName;
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(extName);
    }
}
