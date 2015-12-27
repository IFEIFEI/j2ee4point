/**
 * 
 */
package cn.edu.xmu.artworkauction.service;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.Address;
import cn.edu.xmu.artworkauction.entity.Artwork;
/**
 * @author Y
 *
 */

public interface ArtistService {
	//对用户信息进行更新
	public Artist updateArtistInfo(Artist artist,String userName,String email,String phoneNumber,String education,String description,String imageURL);
	public Artist updateArtistAddress(Artist artist,Address address);
	public Artist addArtwork(Artist artist,Artwork artwork);
	public boolean deleteOneArtwork(String artworkId);
}
