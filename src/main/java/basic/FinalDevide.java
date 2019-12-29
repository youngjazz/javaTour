package basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leon
 * @date 2019-04-08
 */
public class FinalDevide extends Base{

    final User user;

    public FinalDevide() {
        this.user = new User("leon",18);
    }

    public static void main(String[] args) {
        FinalDevide finalDevide = new FinalDevide();
        System.out.println(finalDevide.getUserName());
    }

    @Override
    public final String getUserName(){
        return user.getName();
    }
}


@Data
@AllArgsConstructor
class User {
    String name;
    int age;
}

abstract class Base{
    abstract String getUserName();
}