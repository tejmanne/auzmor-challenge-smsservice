package com.tejamanne.challenges.smsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejamanne.challenges.smsservice.objects.SMS;
import com.tejamanne.challenges.smsservice.services.SmsService;
import com.tejamanne.challenges.smsservice.utils.SmsserviceConstants;

@RestController
@RequestMapping("/io")
public class IOController {

	@Autowired
	SmsService smsService;
	
	/**
	 * Handles both inbound and outbound sms requests
	 * @param ioType
	 * @param from
	 * @param to
	 * @param text
	 * @return SMS
	 */
	@RequestMapping(value = "/inbound/sms", method = RequestMethod.POST)
	@Cacheable(value="smsinbounds", keyGenerator="smsinboundsKeyGenerator")
	public SMS postInboundsms(@RequestParam(name = SmsserviceConstants.IN_PARAM_FROM, required = false) String from,
			@RequestParam(name = SmsserviceConstants.IN_PARAM_TO, required = false) String to,
			@RequestParam(name = SmsserviceConstants.IN_PARAM_TEXT, required = false) String text) {
		return postIOSms(SmsserviceConstants.SMS_IO_TYPE_INBOUND, from, to, text);
	}

	/**
	 * Handles both inbound and outbound sms requests
	 * @param ioType
	 * @param from
	 * @param to
	 * @param text
	 * @return SMS
	 */
	@RequestMapping(value = "/outbound/sms", method = RequestMethod.POST)
	@Cacheable(value="smsoutbounds", keyGenerator="smsoutboundsKeyGenerator")
	public SMS postOutboundSms(@RequestParam(name = SmsserviceConstants.IN_PARAM_FROM, required = false) String from,
			@RequestParam(name = SmsserviceConstants.IN_PARAM_TO, required = false) String to,
			@RequestParam(name = SmsserviceConstants.IN_PARAM_TEXT, required = false) String text) {
		return postIOSms(SmsserviceConstants.SMS_IO_TYPE_OUTBOUND, from, to, text);
	}
	
	public SMS postIOSms(String ioType, String from, String to, String text) {
		SMS sms = new SMS();
		sms.setMessage("");

		if (from == null) {
			sms.setError(SmsserviceConstants.IN_PARAM_FROM + SmsserviceConstants.IS_MISSING);
		} else if (to == null) {
			sms.setError(SmsserviceConstants.IN_PARAM_TO + SmsserviceConstants.IS_MISSING);
		} else if (text == null) {
			sms.setError(SmsserviceConstants.IN_PARAM_TEXT + SmsserviceConstants.IS_MISSING);
		} else if (!isToFromParamValid(from)) {
			sms.setError(SmsserviceConstants.IN_PARAM_FROM + SmsserviceConstants.IS_INVALID);
		} else if (!isToFromParamValid(to)) {
			sms.setError(SmsserviceConstants.IN_PARAM_TO + SmsserviceConstants.IS_INVALID);
		} else if (!(text.length() >= 1 && text.length() <= 120)) {
			sms.setError(SmsserviceConstants.IN_PARAM_TEXT + SmsserviceConstants.IS_INVALID);
		} else {
			if (ioType.equals(SmsserviceConstants.SMS_IO_TYPE_INBOUND)) {
				sms = smsService.getSmsInbounds(from, to, text);
			} else if (ioType.equals(SmsserviceConstants.SMS_IO_TYPE_OUTBOUND)) {
				sms = smsService.getSmsOutbounds(from, to, text);
			}
		}

		return sms;
	}

	/**
	 * Validates to and from parameter
	 * @param param
	 * @return true or false
	 */
	Boolean isToFromParamValid(String param) {
		return (param.length() >= 6 && param.length() <= 16);
	}

}
