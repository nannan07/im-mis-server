package com.allmsi.mis.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.allmsi.mis.dao.AttachmentMapper;
import com.allmsi.mis.dao.AttachmentObjMapper;
import com.allmsi.mis.model.po.Attachment;
import com.allmsi.mis.model.po.AttachmentObj;
import com.allmsi.mis.model.vo.AttachmentVo;
import com.allmsi.mis.service.AttachmentService;
import com.allmsi.sys.util.FileUtil;
import com.allmsi.sys.util.StrUtil;
import com.allmsi.sys.util.UUIDUtil;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	@Value("${upload.file.path.value:null}")
	private String UPLOAD_FILE_PATH;

	@Value("${dowdload.url.value:null}")
	private String DOWDLOAD_URL;

	private final String FILE_PATH_DATE_FORMAT = "yyyyMM/dd";

	@Resource
	private AttachmentMapper attachmentDao;

	@Resource
	private AttachmentObjMapper attachmentObjDao;

	public AttachmentVo upload(MultipartFile file) {
		if (file == null) {
			return null;
		}
		String fileName = file.getOriginalFilename();// 文件原始名称(上传前的名称)
		String fileType = FileUtil.getExt(fileName);// 文件类型(后缀)
		String fileId = UUIDUtil.getUUID();
		String nFileName = fileId;// 新文件名称
		long fileSize = file.getSize();
		String sqlFilePath = "/" + new SimpleDateFormat(FILE_PATH_DATE_FORMAT).format(new Date());
		String filePath = UPLOAD_FILE_PATH + sqlFilePath;
		FileUtil.mkdir(filePath);// 创建目录
		File resultFile = new File(filePath + "/" + nFileName + fileType);// 创建目标文件
		AttachmentVo resultFileVo = new AttachmentVo();
		try {
			file.transferTo(resultFile);// 写入磁盘
		} catch (IllegalStateException | IOException e) {
			return null;
		}
		Attachment record = new Attachment();
		record.setId(fileId);
		record.setFileName(fileName);
		record.setnFileName(nFileName);
		record.setFileType(fileType);
		record.setFilePath(sqlFilePath);
		record.setFileSize(fileSize);
		record.setDel(0);
		attachmentDao.insertSelective(record);
		resultFileVo.setId(record.getId());
		resultFileVo.setName(record.getFileName());
		resultFileVo.setUrl(DOWDLOAD_URL + record.getId());
		resultFileVo.setLength(record.getFileSize());
		return resultFileVo;
	}

	@Override
	public AttachmentVo upload(MultipartFile file, String objectId, String objectType) {
		if (StrUtil.isEmpty(objectId)) {
			return null;
		}
		AttachmentVo filevo = upload(file);
		if (file == null || StrUtil.isEmpty(filevo.getId())) {
			return null;
		}

		AttachmentObj fileObject = new AttachmentObj();
		fileObject.setId(UUIDUtil.getUUID());
		fileObject.setFileId(filevo.getId());
		fileObject.setObjectId(objectId);
		fileObject.setObjectType(objectType);
		attachmentObjDao.insertSelective(fileObject);
		filevo.setType(objectType);
		return filevo;
	}

	@Override
	public Attachment selectById(String id) {
		if (StrUtil.isEmpty(id)) {
			return null;
		}
		return attachmentDao.selectByPrimaryKey(id);
	}

	@Override
	public boolean delete(String id) {
		if (StrUtil.isEmpty(id)) {
			return false;
		}
		Attachment fileInfo = attachmentDao.selectByPrimaryKey(id);
		if (fileInfo == null) {
			return false;
		}
		String path = UPLOAD_FILE_PATH + fileInfo.getFilePath() + "/" + fileInfo.getnFileName()
				+ fileInfo.getFileType();
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			file.delete();
		}
		attachmentDao.deleteByPrimaryKey(id);
		attachmentDao.deleteByFileId(id);
		return true;
	}

}
