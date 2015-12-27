/**
 * 
 */
package cn.edu.xmu.artworkauction.dao;

import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.entity.Address;
import cn.edu.xmu.artworkauction.entity.Artwork;

/**
 * @author XiaWenSheng
 *
 */
public interface ArtistDAO {
	public Artist toBeArtist(String realname,String IDNumber,String userName,String email,String phoneNumber,String password,String country,String education,String description);
	public Artist artistUpdate(Artist artist,String userName,String email,String phoneNumber,String education,String description,String imageURL);
	public Artist artistUpdateAddress(Artist artist,Address address);
	public Artist addArtwork(Artist artist,Artwork artwork);
	public boolean checkIDNumberUnique(String IDNumber);
	public boolean checkUserNameUnique(String userName);
	public boolean checkEmailUnique(String email);
	public boolean checkShopNumber(Artist artist);
	public void addArtist(Artist artist);
	public void saveArtist(Artist artist);
	public void deleteArtist(Artist artist);
	public void updateArtist(Artist artist);
	public Artist getArtistById(Integer artistId);
	public void addartwork(Artwork artwork);
	public void saveArtwork(Artwork artwork);
	public void deleteArtwork(Artwork artwork);
	public void updateArtwork(Artwork artwork);
}
