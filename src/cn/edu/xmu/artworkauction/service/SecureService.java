/**
 * 
 */
package cn.edu.xmu.artworkauction.service;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;

/**
 * @author XiaWenSheng
 *
 */
public interface SecureService {
	public User userRegister(String email,String userName,String phoneNumber,String password);
	//艺术家进行注册
	public Artist artistRegister(String realname,String IDNumber,String userName,String email,String phoneNumber,String password,String country,String education,String description);
	public User userLoginByUserName(String userName,String password);
	public User userLoginByEmail(String email,String password);
}
