package com.bsworld.fd;
/*
*author: xieziyang
*date: 2018/7/5
*time: 9:45
*description:
*/

public class FastDFSFile {
    private byte[] content;// 文件内容
    private String name;// 文件名
    private String ext;// 后缀
    private String fileId;// 文件id(唯一id)

    public FastDFSFile(byte[] content, String ext,String fileId) {
        this.content = content;
        this.ext = ext;
        this.fileId = fileId;
    }

    public FastDFSFile(byte[] content, String name, String ext,String fileId) {
        this.content = content;
        this.name = name;
        this.ext = ext;
        this.fileId = fileId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

}