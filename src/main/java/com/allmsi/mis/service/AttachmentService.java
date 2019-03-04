package com.allmsi.mis.service;

import org.springframework.web.multipart.MultipartFile;

import com.allmsi.mis.model.po.Attachment;
import com.allmsi.mis.model.vo.AttachmentVo;

public interface AttachmentService {

	AttachmentVo upload(MultipartFile file, String objectId, String objectType);

	Attachment selectById(String id);

	boolean delete(String id);

}
