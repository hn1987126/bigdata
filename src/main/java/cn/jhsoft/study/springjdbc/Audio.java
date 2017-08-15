package cn.jhsoft.study.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenyi9 on 2017/8/15.
 */
public class Audio {

    private int id;

    private int count_id;

    private String url;

    private String code_url;

    public String count_id_md5;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount_id() {
        return count_id;
    }

    public void setCount_id(int count_id) {
        this.count_id = count_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode_url() {
        return code_url;
    }

    public void setCode_url(String code_url) {
        this.code_url = code_url;
    }

    public String getCount_id_md5() {
        return count_id_md5;
    }

    public void setCount_id_md5(String count_id_md5) {
        this.count_id_md5 = count_id_md5;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", count_id=" + count_id +
                ", url='" + url + '\'' +
                ", code_url='" + code_url + '\'' +
                ", count_id_md5='" + count_id_md5 + '\'' +
                '}';
    }
}
