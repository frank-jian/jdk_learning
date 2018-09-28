package basicType;

import java.util.List;

/**
 * @author jianweilin
 * @date 2018/6/29
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(System.getenv().get("PATH"));

//        Set<String> set = new HashSet<>();
//        set.add("1");
//        set.add("2");
//        set.add("3");
//        System.out.println(JSON.toJSON(set.toArray(new String[0])));;
//        String msg = JSON.toJSONString(new User(Arrays.asList(1L),"张三"));
//        System.out.println("msg : " + msg);
//        JSONArray jsonArray = JSON.parseObject(msg).getJSONArray("userIdsECHO ");
//
////        System.out.println("jsonArray" + JSON.toJSONString(jsonArray));
//        List<Long> userIds = JSON.parseObject(msg).getJSONArray("userIds").toJavaList(Long.class);
//        System.out.println("userIds => " + JSON.toJSONString(userIds));

}
}

class User{
    private List<Long> userIds;
    private String userName;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(List<Long> userIds, String userName) {
        this.userIds = userIds;
        this.userName = userName;
    }
}
