package annotations.database;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLDecimal {
	  String name() default "";
	  int precision() default 18;
	  int scale() default 0;
	  Constraints constraints() default @Constraints;
}
