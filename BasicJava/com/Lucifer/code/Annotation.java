import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * @author : wangdi
 * @time : creat in 2019/3/26 00:08
 * 注解完成ORM框架
 */
//注解的作用范围
@Target({ElementType.METHOD,ElementType.TYPE})
//作用时间
@Retention(RetentionPolicy.RUNTIME)
@interface Table{
    String value();
}

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@interface Property{
    String name();
    int length() default 0;
}

@Table(value = "Student")
class Student{
    @Property(name = "id")
    private String studentId;
    @Property(name = "student_name")
    private String studentName;
    @Property(name = "student_age")
    private String studentAge;
}


public class Annotation {

    public static void main(String[] args) throws Exception{
        Class<?> forName = Class.forName("Student");
        //获取注解参数
        Table declaredAnnotations = forName.getDeclaredAnnotation(Table.class);
        //获取当前所有方法
        Field[] declaredFields = forName.getDeclaredFields();
        StringBuffer sf = new StringBuffer();
        sf.append("select ");
        for(int i =0;i<declaredFields.length;i++){
            Field field = declaredFields[i];
           Property property = field.getDeclaredAnnotation(Property.class);
            sf.append(property.name());
            if(i<declaredFields.length -1 ){
                sf.append(" ,");
            }
        }
        sf.append(" from "+ declaredAnnotations.value());
        System.out.println(sf.toString());
    }
}
