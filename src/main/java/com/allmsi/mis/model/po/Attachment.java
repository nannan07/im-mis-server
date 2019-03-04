package com.allmsi.mis.model.po;

import java.util.Date;

public class Attachment {
    private String id;

    private String fileName;

    private String nFileName;

    private String fileType;

    private Long fileSize;

    private String fileMd5;

    private String filePath;

    private String filePathType;

    private int fileState;

    private Date cTime;

    private Date uTime;

    private int del;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getnFileName() {
        return nFileName;
    }

    public void setnFileName(String nFileName) {
        this.nFileName = nFileName == null ? null : nFileName.trim();
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5 == null ? null : fileMd5.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFilePathType() {
        return filePathType;
    }

    public void setFilePathType(String filePathType) {
        this.filePathType = filePathType == null ? null : filePathType.trim();
    }

    public void setFileState(Byte fileState) {
        this.fileState = fileState;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getuTime() {
        return uTime;
    }

    public void setuTime(Date uTime) {
        this.uTime = uTime;
    }

	public int getFileState() {
		return fileState;
	}

	public void setFileState(int fileState) {
		this.fileState = fileState;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
}