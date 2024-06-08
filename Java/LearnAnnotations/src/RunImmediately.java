/*
 * Author: Thanos Moschou
 * Description: This is a small program that helped me to learn more about annotations in Java.
 * Last Modification Date: 15/12/2023
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediately 
{
	int repeat() default 2;
}
