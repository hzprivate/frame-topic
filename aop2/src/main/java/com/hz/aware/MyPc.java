package com.hz.aware;

import com.hz.annotiton.AutoSetValueOnRefresh;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author hz
 * @Description:
 * @create 2020-11-20
 */
@Configuration
public class MyPc implements ImportAware {
    private String ip;
    private String address;
    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        Map<String, Object> map = annotationMetadata.getAnnotationAttributes(AutoSetValueOnRefresh.class.getName());
        String ip = String.valueOf(map.get("ip"));
        String address = String.valueOf(map.get("address"));
        this.ip=ip;
        this.address=address;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MyPc{" +
                "ip='" + ip + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
