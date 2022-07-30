package cn.qy.store.entity;

import java.util.Objects;

/**
 * @description:
 * @author: QiuYang
 * @time: 2022/7/29
 */
public class Cart extends BaseEntity{
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cid, cart.cid) &&
                Objects.equals(uid, cart.uid) &&
                Objects.equals(pid, cart.pid) &&
                Objects.equals(price, cart.price) &&
                Objects.equals(num, cart.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, uid, pid, price, num);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                ", num=" + num +
                "} " + super.toString();
    }
}
