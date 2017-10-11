package com.craftsman.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadResult {
	
	//是否成功
	private boolean success;
	//描述
	private String msg;
	//上传路径
	private String uploadPath;

}
