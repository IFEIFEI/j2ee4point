package cn.edu.xmu.artworkauction.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * @author XiaWenSheng
 * */
@Entity
@DiscriminatorValue("userAdmin")
public class UserAdmin extends Admin{

}
