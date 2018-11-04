/**
 * 
 */
package com.cjl.web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 @author： fu    @time：2018年11月4日 下午4:02:36 
 @说明： 一份耕耘，一份收获
**/
@Controller
@RequestMapping("/")
public class FileUploadController {

	//通过Spring的autowired注解获取spring默认配置的request
		@Autowired
		private HttpServletRequest request;
		
		@RequestMapping("toUpload")
		public String toUpload() {
			return "fileDetail/upload";
			
		}
		/***
		 * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
		 * 
		 * @param file
		 * @return
		 */
		@RequestMapping(value="fileUpload", method = RequestMethod.POST)
		//required=false,可以上传两个文件
		public String fileUpload(@RequestParam(value="file",required=false) MultipartFile file,HttpServletRequest request) {
			// 判断文件是否为空
			if (!file.isEmpty()) {
				try {
					//使用时间戳定义不重复的图片名称
					String imgName=System.currentTimeMillis()+".png";
					// 拿到项目环境地址 
					String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
					File targetFile=new File(filePath,imgName);
						if (!targetFile.exists()) {
							targetFile.mkdirs();//创建文件夹
							
						}
					//getOriginalFilename()拿到原生名称，使用imgName代替了，避免重复，但是只能在单线程使用
					// 转存文件，把当前的文件拷贝到文件路径里面去
					file.transferTo(new File(filePath));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 重定向
			return "redirect:/list";
		}


		/***
		 * 读取上传文件中得所有文件并返回
		 * 
		 * @return
		 */
		@RequestMapping(value="list", method = RequestMethod.POST)
		public ModelAndView list() {
			String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
			ModelAndView mav = new ModelAndView("list");
			File uploadDest = new File(filePath);
			String[] fileNames = uploadDest.list();
			for (int i = 0; i < fileNames.length; i++) {
				//打印出文件名
				System.out.println(fileNames[i]);
			}
			return mav;
		}
}
