package me.marques.anderson;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@EnableAutoConfiguration
public class Sample {

    HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();

    @RequestMapping("/ids")
    @ResponseBody
    String home(){
        IMap<String, String> ids = hazelcastInstance.getMap("ids");
        ids.put(UUID.randomUUID().toString(),"teste");

        return ids.size() + "";
    }

    public static void main(String[] args) {
        SpringApplication.run(Sample.class, args);
    }
}
