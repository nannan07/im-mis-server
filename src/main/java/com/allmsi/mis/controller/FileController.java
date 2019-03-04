package com.allmsi.mis.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.allmsi.mis.model.po.Attachment;
import com.allmsi.mis.model.vo.AttachmentVo;
import com.allmsi.mis.service.AttachmentService;
import com.allmsi.sys.model.protocol.ErrorProtocol;
import com.allmsi.sys.model.protocol.SuccessProtocol;
import com.allmsi.sys.util.StrUtil;

/**
 * 文件上传下载
 * @author sunnannan
 *
 */
@Controller
@RequestMapping("file")
public class FileController {

	@Value("${upload.file.path.value:null}")
	private String UPLOAD_FILE_PATH;

	@Resource
	private AttachmentService attachmentService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public Object upload(MultipartFile file, String objectId, String objectType) {
		AttachmentVo fileInfo = attachmentService.upload(file, objectId, objectType);
		if (fileInfo == null || StrUtil.isEmpty(fileInfo.getId())) {
			return new ErrorProtocol("上传失败");
		}
		return new SuccessProtocol("上传成功", fileInfo);
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	@ResponseBody
	public void download(String id, HttpServletResponse response, HttpServletRequest request) throws IOException {
		if (StrUtil.isEmpty(id)) {
			return;
		}
		Attachment fileInfo = attachmentService.selectById(id);
		if (fileInfo == null || StrUtil.isEmpty(fileInfo.getFilePath())) {
			return;
		}
		String path = fileInfo.getFilePath() + "/" + fileInfo.getnFileName() + fileInfo.getFileType();

		path = UPLOAD_FILE_PATH + path;
		File file = new File(path);
		PrintWriter out = null;
		InputStream fis = null;
		OutputStream toClient = null;
		try {
			if (file.exists()) {
				fis = new BufferedInputStream(new FileInputStream(file));
				response.reset();
				response.setContentType("application/x-download");
				response.addHeader("Content-Disposition",
						"attachment;filename=" + new String(fileInfo.getFileName().getBytes("gb2312"), "iso-8859-1"));
				response.addHeader("Content-Length", "" + file.length());
				toClient = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");
				byte[] buffer = new byte[1024 * 1024 * 4];
				int i = -1;
				while ((i = fis.read(buffer)) != -1) {
					toClient.write(buffer, 0, i);
				}
			} else {
				out = response.getWriter();
				out.print("<script>");
				out.print("alert(\"没有可下载文件！\")");
				out.print("</script>");
			}
		} catch (IOException ex) {
			out = response.getWriter();
			out.print("<script>");
			out.print("alert(\"没有可下载文件！\")");
			out.print("</script>");
		} finally {
			if (fis != null) {
				fis.close();
			}
			if (toClient != null) {
				toClient.flush();
				toClient.close();
			}
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(String id) {
		if (StrUtil.isEmpty(id)) {
			return new ErrorProtocol("没有选择要删除的文件");
		}
		return new SuccessProtocol(attachmentService.delete(id));
	}

}