package com.shenmajr.boot.sevices.imp;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shenmajr.boot.domain.Attachment;
import com.shenmajr.boot.domain.Star;
import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.repo.AttachmentRepo;

@Service
@ConfigurationProperties(prefix= "boot.app")
public class AttachmentService {
	
	private Logger logger =LoggerFactory.getLogger(getClass());

	@Autowired
	private AttachmentRepo attachmentRepo;
	
	private String attachdir = "";
	private Long maxFileSize;
	
	@PostConstruct
	public void init(){
		if (StringUtils.isEmpty(attachdir)) {
			attachdir = AttachmentService.class.getResource("/").getFile();
		}
		if (maxFileSize == null || maxFileSize == 0L) {
			maxFileSize = 2L;
		}
		if (logger.isInfoEnabled()) {
			logger.info(String.format("attachdir:%s", attachdir));
		}
	}
	
	public Attachment upload(MultipartFile myfile, Attachment attach) {
		String originalFilename = myfile.getOriginalFilename();
		String slashType = (originalFilename.lastIndexOf("\\") > 0) ? "\\" : "/";
		int startIndex=originalFilename.lastIndexOf(slashType);
		String newfilename =	 StringUtils.defaultIfEmpty(attach.getStar().getName(), "null");
		String filename = originalFilename.substring(startIndex + 1, originalFilename.length());
		String realPath = attachdir + "/" + newfilename + "/" + filename;
		
		try {
			String lowerName = filename.toLowerCase();
			if ((lowerName.endsWith(".jpg")
					|| lowerName.endsWith(".jpeg")
					|| lowerName.endsWith(".png")
					|| lowerName.endsWith(".gif")
					|| lowerName.endsWith(".bmp"))
					&& myfile.getSize() > maxFileSize * 1024 * 1024) {
				
				File tempFile = new File(attachdir + newfilename + "/temp/" + filename);
			
				FileUtils.copyInputStreamToFile(myfile.getInputStream(), tempFile);
				
				BufferedImage image = ImageIO.read(tempFile); //构建Image对象
				int width = image.getWidth(); // 获取原图的宽度
				int height = image.getHeight(); // 获取原图的高度
				
				BufferedImage img = new  BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D graphics = img.createGraphics();
				graphics.drawImage(img, 0, 0, width, height, null);
				
				String toPath = realPath;
				boolean isJPEG = lowerName.endsWith(".jpg") 
						|| lowerName.endsWith(".jpeg");
				if (isJPEG) {
					toPath= attachdir + newfilename + filename.replaceFirst("\\.\\w+$", ".jpg");
				}
				FileOutputStream out=null;
				File file=new File(toPath);
				try{
					out = new FileOutputStream(file); // 输出到文件流
					// 可以正常实现bmp、png、gif转jpg
					ImageIO.write(img,"JPEG" , out);
					if(!isJPEG){
						realPath=toPath;
					}
					tempFile.delete();
				}catch(Exception e){
					file.delete();
					tempFile.renameTo(new File(realPath));
					throw e;
				}finally{
					try {
						out.close();
					} catch (Exception e) {}
				}
			}else{
				File file=new File(realPath);
				// 这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
				// 此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
				FileUtils.copyInputStreamToFile(myfile.getInputStream(),file);
			}
			attach.set_id(newfilename);
			attach.setName(filename);
			attach.setUrl(realPath);
//			attach.setType("image/*")
			int typeIndex = filename.lastIndexOf(".");
			attach.setType(filename.substring(typeIndex, filename.length()));
			attach.setRecordStatus(Status.NORMAL);
			Attachment attachment = attachmentRepo.save(attach);
			return attachment;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean saveUploadFile(HttpServletRequest request , MultipartFile file){
		/**
		 * 首先判断文件是否为空
		 */
		if (!file.isEmpty()) {
			try {
				String filePath = request.getSession().getServletContext().getRealPath("/")
						+ "upload/" + file.getOriginalFilename();
				File saveDir = new File(filePath);
				if (!saveDir.getParentFile().exists()) {
					saveDir.getParentFile().mkdirs();
				}
				/**
				 * 转存文件
				 */
				file.transferTo(saveDir);
				return true;
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public List<Attachment> getAllByStar(String _id) {
		return attachmentRepo.findAllByStar(_id);
	}
	public List<Attachment> getByStar(Star star){
		return attachmentRepo.findByStar(star);
	}
	public String getAttachdir() {
		return attachdir;
	}
	public void setAttachdir(String attachdir) {
		this.attachdir = attachdir;
	}
	public long getMaxFileSize() {
		return maxFileSize;
	}
	public void setMaxFileSize(long maxFileSize) {
		this.maxFileSize = maxFileSize;
	}
}
