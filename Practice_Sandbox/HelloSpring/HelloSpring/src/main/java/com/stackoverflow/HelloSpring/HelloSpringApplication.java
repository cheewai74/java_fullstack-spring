package com.stackoverflow.HelloSpring;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.plugin.core.Plugin;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;
import org.springframework.stereotype.Component;

@SpringBootApplication @EnablePluginRegistries(WriterPlugin.class)
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(PluginRegistry <WriterPlugin, String> plugins){
		return args ->{
			for(var format: "csv,txt".split(","))
				plugins.getPluginFor(format).get().write("Hello, my first Spring");
		};
	}

}

@Component
class CsvWriter implements WriterPlugin{

	@Override
	public void write(String message) {
		System.out.println("writing CSV:" + message);
	}

	@Override
	public boolean supports(String s) {
		return s.equalsIgnoreCase("csv");
	}
}

@Component
class TxtWriter implements WriterPlugin{

	@Override
	public void write(String message) {
		System.out.println("writing text:" + message);
	}

	@Override
	public boolean supports(String s) {
		return s.equalsIgnoreCase("txt");
	}
}

interface WriterPlugin extends Plugin<String> {
	void write(String message);
}
