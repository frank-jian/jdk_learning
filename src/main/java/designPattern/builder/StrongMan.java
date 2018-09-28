package designPattern.builder;

import com.alibaba.fastjson.JSON;

/**
 * @author jianweilin
 * @date 2018/6/10
 */
public class StrongMan {
    private String name;
    private Integer age;
    private String hair;

    public StrongMan(String name, Integer age, String hair) {
        this.name = name;
        this.age = age;
        this.hair = hair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    static class Builder{
        private String name;
        private Integer age;
        private String hair;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withHair(String hair){
            this.hair = hair;
            return this;
        }

        public Builder withAge(Integer age){
            this.age = age;
            return this;
        }

        public StrongMan build(){
            return new StrongMan(name,age,hair);
        }
    }

    public static void main(String[] args) {
        StrongMan man = new StrongMan.Builder().withAge(10).withName("张三").withHair("红色").build();
        System.out.println(JSON.toJSONString(man));
    }

}
