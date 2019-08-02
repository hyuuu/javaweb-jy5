package test;

/**
 * @ClassName: Users
 * @author: heyuu
 * @create: 2019-07-25 18:18:04
 * @version: JDK 1.8
 * @description:
 */
public class Users {
    private Integer id;
    private String username;
    private String password;
    private String tel;

    public Users() {}

    public Users(Integer id, String username, String password, String tel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
