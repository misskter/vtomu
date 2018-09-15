/**
 * 
 */
package com.vtomu.security.validate.code.image;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

import com.vtomu.security.validate.code.ValidateCode;


/**
 * @author zhailiang
 *
 */
public class ImageCode extends ValidateCode {
	
	private BufferedImage image; 
	
	public ImageCode(BufferedImage image, String code, int expireIn){
		super(code, expireIn);
		this.image = image;
	}
	
/*	public ImageCode(BufferedImage image, String code, int expireTime){
		super(code, expireTime);
		this.image = image;
	}*/
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
