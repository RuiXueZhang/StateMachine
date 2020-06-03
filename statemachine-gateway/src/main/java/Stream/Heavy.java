package cn.ruix.Stream;

public class Heavy {

    private String name;

    private Integer heavy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeavy() {
        return heavy;
    }

    public void setHeavy(Integer heavy) {
        this.heavy = heavy;
    }

    public Heavy(String name, Integer heavy) {
        this.name = name;
        this.heavy = heavy;
    }
}
