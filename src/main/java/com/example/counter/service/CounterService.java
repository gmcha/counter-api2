package com.example.counter.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private final StringRedisTemplate redisTemplate;
    private static final String COUNTER_KEY = "visit:count"; // 레디스 카운터 키 지정

    public CounterService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long increment() {
        return redisTemplate.opsForValue().increment(COUNTER_KEY); // 값 받아와서 정수로 바꾼 뒤, increment
    }

    public Long getCount() {
        String count = redisTemplate.opsForValue().get(COUNTER_KEY);
        return count == null ? 0L : Long.parseLong(count);
    }


}
