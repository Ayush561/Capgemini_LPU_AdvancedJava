package OneToMany_ManyToOne_BiDirectional_Implementation;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    int sid;

    String name;
    String branch;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

    public College getCollege() {
        return college;
    }
    public void setCollege(College college) {
        this.college = college;
    }

    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + ", name=" + name + ", branch=" + branch + "]";
    }
}
