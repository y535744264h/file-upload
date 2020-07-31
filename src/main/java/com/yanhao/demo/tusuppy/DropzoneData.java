package com.yanhao.demo.tusuppy;

/**
 * @program: tus-uppy->DropzoneData
 * @description:
 * @author: yanhao
 * @create: 2020-07-31 16:57
 **/
public class DropzoneData {

    /** 是否分片上传 **/
    private boolean dzThunk;

    /** 文件UUID **/
    private String dzUuid;

    /** 第几个片段 **/
    private String dzChunkIndex;

    /** 文件总大小 **/
    private String dzTotalFileSize;

    /** 当前片段的size **/
    private String dzCurrentChunkSize;

    /** 总共分几段上传 **/
    private String dzTotalChunkCount;

    /** 偏移 **/
    private String dzChunkByteOffset;

    /** 本段大小 **/
    private String dzChunkSize;

    /** 文件名称 **/
    private String dzFilename;

    /** 加密字符串**/
    private String dzChunkEnCode;



    public boolean isDzThunk() {
        return dzThunk;
    }

    public void setDzThunk(boolean dzThunk) {
        this.dzThunk = dzThunk;
    }

    public String getDzUuid() {
        return dzUuid;
    }

    public void setDzUuid(String dzUuid) {
        this.dzUuid = dzUuid;
    }

    public String getDzChunkIndex() {
        return dzChunkIndex;
    }

    public void setDzChunkIndex(String dzChunkIndex) {
        this.dzChunkIndex = dzChunkIndex;
    }

    public String getDzTotalFileSize() {
        return dzTotalFileSize;
    }

    public void setDzTotalFileSize(String dzTotalFileSize) {
        this.dzTotalFileSize = dzTotalFileSize;
    }

    public String getDzCurrentChunkSize() {
        return dzCurrentChunkSize;
    }

    public void setDzCurrentChunkSize(String dzCurrentChunkSize) {
        this.dzCurrentChunkSize = dzCurrentChunkSize;
    }

    public String getDzTotalChunkCount() {
        return dzTotalChunkCount;
    }

    public void setDzTotalChunkCount(String dzTotalChunkCount) {
        this.dzTotalChunkCount = dzTotalChunkCount;
    }

    public String getDzChunkByteOffset() {
        return dzChunkByteOffset;
    }

    public void setDzChunkByteOffset(String dzChunkByteOffset) {
        this.dzChunkByteOffset = dzChunkByteOffset;
    }

    public String getDzChunkSize() {
        return dzChunkSize;
    }

    public void setDzChunkSize(String dzChunkSize) {
        this.dzChunkSize = dzChunkSize;
    }

    public String getDzFilename() {
        return dzFilename;
    }

    public void setDzFilename(String dzFilename) {
        this.dzFilename = dzFilename;
    }

    public DropzoneData() {
    }

    public String getDzChunkEnCode() {
        return dzChunkEnCode;
    }

    public void setDzChunkEnCode(String dzChunkEnCode) {
        this.dzChunkEnCode = dzChunkEnCode;
    }

    public DropzoneData(boolean dzThunk, String dzUuid, String dzChunkIndex, String dzTotalFileSize, String dzCurrentChunkSize, String dzTotalChunkCount, String dzChunkByteOffset, String dzChunkSize, String dzFilename, String dzChunkEnCode) {
        this.dzThunk = dzThunk;
        this.dzUuid = dzUuid;
        this.dzChunkIndex = dzChunkIndex;
        this.dzTotalFileSize = dzTotalFileSize;
        this.dzCurrentChunkSize = dzCurrentChunkSize;
        this.dzTotalChunkCount = dzTotalChunkCount;
        this.dzChunkByteOffset = dzChunkByteOffset;
        this.dzChunkSize = dzChunkSize;
        this.dzFilename = dzFilename;
        this.dzChunkEnCode = dzChunkEnCode;
    }

    @Override
    public String toString() {
        return "DropzoneData{" +
                "dzThunk=" + dzThunk +
                ", dzUuid='" + dzUuid + '\'' +
                ", dzChunkIndex='" + dzChunkIndex + '\'' +
                ", dzTotalFileSize='" + dzTotalFileSize + '\'' +
                ", dzCurrentChunkSize='" + dzCurrentChunkSize + '\'' +
                ", dzTotalChunkCount='" + dzTotalChunkCount + '\'' +
                ", dzChunkByteOffset='" + dzChunkByteOffset + '\'' +
                ", dzChunkSize='" + dzChunkSize + '\'' +
                ", dzFilename='" + dzFilename + '\'' +
                ", dzChunkEnCode='" + dzChunkEnCode + '\'' +
                '}';
    }
}
