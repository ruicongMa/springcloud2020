/**
 * @author Mark
 * @date 2021/9/15 15:09
 */
public class User extends AbstractUser {
    @Override
    public void print() {

    }

    public static void main(String[] args) {
        User user = new User();
        user.state = 2;
        System.out.println(user.state);

        User user1 = new User();
        System.out.println(user1.state);
    }
}
