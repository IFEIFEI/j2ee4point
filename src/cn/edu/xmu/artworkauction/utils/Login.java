/**
 * 
 */
package cn.edu.xmu.artworkauction.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * @author XiaWenSheng
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
	ResultTypeEnum value() default ResultTypeEnum.page;
}
