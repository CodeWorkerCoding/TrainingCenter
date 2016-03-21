package com.shenmajr.boot.schedule;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.shenmajr.boot.utils.CommonUtils;

@Component
@Configurable
@EnableScheduling
public class CommonSechedule {

	private Logger logger = LoggerFactory.getLogger(CommonSechedule.class);
	/**
	 * spring 定时任务。每隔一分钟执行一次
	 */
	@Scheduled(cron = "0 0/1 * * * ?")
	public void sayGeet(){
		logger.info(CommonUtils.formate(new Date(), "yyyy-MM-dd HH:mm:ss") + "Start the schedule Task");
		System.out.println("\n\nHelloWorld\n\n");
		System.out.println("Allen");
	}
}
