package zulfiqar.com.assignment;

public class listdata
{
    private String name , age , createdate;

    public listdata() {
    }

    public listdata(String name, String age, String createdate) {
        this.name = name;
        this.age = age;
        this.createdate = createdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
}