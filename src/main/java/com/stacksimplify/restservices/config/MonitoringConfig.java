package com.stacksimplify.restservices.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import io.micrometer.appoptics.AppOpticsConfig;
import io.micrometer.appoptics.AppOpticsMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MonitoringConfig {

	AppOpticsConfig appopticsConfig = new AppOpticsConfig() {
		@Override
		public String apiToken() {
			return "MY_TOKEN";
		}
		
		@Override
		@Nullable
		public String get(String k) {
			return null;
		}
	};
	MeterRegistry registry = new AppOpticsMeterRegistry(appopticsConfig,Clock.SYSTEM);
}
