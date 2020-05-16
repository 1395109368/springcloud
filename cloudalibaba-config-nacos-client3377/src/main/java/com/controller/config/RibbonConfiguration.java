package com.controller.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.client.config.IClientConfigKey;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/5/3
 * @Description: com.controller.config
 * @version: 1.0
 */
@Component
public class RibbonConfiguration implements IClientConfig {

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }

    @Override
    public String getClientName() {
        return null;
    }

    @Override
    public String getNameSpace() {
        return null;
    }

    @Override
    public void loadProperties(String clientName) {

    }

    @Override
    public void loadDefaultValues() {

    }

    @Override
    public Map<String, Object> getProperties() {
        return null;
    }

    @Override
    public void setProperty(IClientConfigKey key, Object value) {

    }

    @Override
    public Object getProperty(IClientConfigKey key) {
        return null;
    }

    @Override
    public Object getProperty(IClientConfigKey key, Object defaultVal) {
        return null;
    }

    @Override
    public boolean containsProperty(IClientConfigKey key) {
        return false;
    }

    @Override
    public String resolveDeploymentContextbasedVipAddresses() {
        return null;
    }

    @Override
    public int getPropertyAsInteger(IClientConfigKey key, int defaultValue) {
        return 0;
    }

    @Override
    public String getPropertyAsString(IClientConfigKey key, String defaultValue) {
        return null;
    }

    @Override
    public boolean getPropertyAsBoolean(IClientConfigKey key, boolean defaultValue) {
        return false;
    }

    @Override
    public <T> T get(IClientConfigKey<T> key) {
        return null;
    }

    @Override
    public <T> T get(IClientConfigKey<T> key, T defaultValue) {
        return null;
    }

    @Override
    public <T> IClientConfig set(IClientConfigKey<T> key, T value) {
        return null;
    }
}
