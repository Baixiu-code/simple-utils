package com.craftsman.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.craftsman.model.UploadResult;

public class FileUploadUtil {

	// 图片格式后缀定义
	public static List<String> IMAGE_SUFFIX_LIST = new ArrayList<String>();

	static {
		IMAGE_SUFFIX_LIST.add(".gif");
		IMAGE_SUFFIX_LIST.add(".jpg");
		IMAGE_SUFFIX_LIST.add(".jpeg");
		IMAGE_SUFFIX_LIST.add(".png");
		IMAGE_SUFFIX_LIST.add(".bmp");
	}

	/**
	 * 图片上传
	 * 
	 * @param module
	 * @param imgPath
	 * @param imgFile
	 * @return
	 */
	public static UploadResult uploadImg(String module, String imgPath, MultipartFile imgFile) {
		return upload(module, imgPath, imgFile, IMAGE_SUFFIX_LIST);
	}

	/**
	 * 文件上传
	 * 
	 * @param module
	 *            模块名称
	 * @param path
	 *            文件完整路径
	 * @param file
	 *            文件对象
	 * @return
	 */
	public static UploadResult upload(String module, String path, MultipartFile file, List<String> suffixList) {
		UploadResult result = new UploadResult();
		if (file == null) {
			result.setSuccess(true);
			result.setUploadPath(path);
			return result;
		}
		String originalName = file.getOriginalFilename();
		if (originalName.lastIndexOf(".") == -1) {
			result.setSuccess(false);
			result.setMsg("文件缺少后缀");
			return result;
		}

		String suffix = originalName.substring(originalName.lastIndexOf(".")).toLowerCase();
		if (suffixList != null && !suffixList.contains(suffix)) {
			result.setSuccess(false);
			result.setMsg("文件后缀格式不正确");
			return result;
		}

		if (StringUtils.isEmpty(path) || !suffix.equals(path.substring(path.lastIndexOf(".")).toLowerCase())) {
			path = "/" + module + "/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/";
			File filePath = new File(SystemConfig.getValue("file.upload.path") + path);
			if (!filePath.exists()) {
				filePath.mkdirs();
			}
			path = path + UUID.randomUUID().toString().replaceAll("-", "") + suffix;
		}
		try {
			file.transferTo(new File(SystemConfig.getValue("file.upload.path") + path));
			result.setUploadPath(path);
			result.setSuccess(true);
		} catch (IllegalStateException e) {
			result.setSuccess(false);
			result.setMsg("上传异常");
			e.printStackTrace();
		} catch (IOException e) {
			result.setSuccess(false);
			result.setMsg("上传异常");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 上传头像
	 * 
	 * @param img
	 * @param phone
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void upload(@RequestParam("img") String img, @RequestParam("phone") String phone, HttpSession session) throws IOException {
		String headPath = SystemConfig.getValue("file.upload.path");
		File headFile = new File(headPath);
		//将转换的64位加密转换为字节流
		byte[] result = Base64.decodeBase64(img.getBytes("UTF-8"));
		//使用uuid生成文件名
		String imgName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
		// 创建文件夹
		if (!headFile.exists()) {
			headFile.mkdirs();
		}
		// 生成文件
		File f = new File(headPath + phone);

		// 创建文件
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		OutputStream out = new FileOutputStream(headPath + phone + imgName);
		out.write(result);
		out.flush();
		out.close();

	}
}
