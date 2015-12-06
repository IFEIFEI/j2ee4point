/**
 * 
 */
package cn.edu.xmu.artworkauction.dao;

import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;

/**
 * @author XiaWenSheng
 *
 */
public interface ArtistDAO {
	public Artist toBeArtist(User user,String IDNumber);
}
