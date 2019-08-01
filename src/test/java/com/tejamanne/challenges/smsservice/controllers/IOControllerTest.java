package com.tejamanne.challenges.smsservice.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tejamanne.challenges.smsservice.objects.SMS;
import com.tejamanne.challenges.smsservice.services.SmsService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IOControllerTest {
	
	@InjectMocks
	IOController ioController;
	
	@Mock
	SmsService smsService;
	
	private final String from="4924195509198";
	private final String to="441224980094";
	private final String text1="Hello";

	/**
	 * Inbound sms posting positive scenario
	 */
	@Test
	public void testInboundSMS() {
		Mockito.when(ioController.postInboundsms(from, to, text1)).thenReturn(new SMS("inbouns sms ok", ""));
		SMS result = ioController.postInboundsms(from, to, text1);
		assertNotNull(result);
		assertEquals("inbouns sms ok", result.getMessage());
	}
	
	/**
	 * Inbound sms posting negative scenario
	 * Invalid to param exception
	 */
	@Test
	public void testInboundSmsToParamException() {
		Mockito.when(ioController.postInboundsms(from, null, text1)).thenReturn(new SMS("", "to is invalid"));
		SMS result = ioController.postInboundsms(from, null, text1);
		assertNotNull("to is invalid", result.getError());
	}
	
	
	/**
	 * Outbound sms posting positive scenario
	 */
	@Test
	public void testOutboundSMS() {
		Mockito.when(ioController.postOutboundSms(from, to, text1)).thenReturn(new SMS("outbound sms ok", ""));
		SMS result = ioController.postOutboundSms(from, to, text1);
		assertNotNull(result);
		assertEquals("outbound sms ok", result.getMessage());
	}
	
	

}
