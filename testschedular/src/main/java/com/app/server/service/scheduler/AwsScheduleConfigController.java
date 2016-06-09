package com.app.server.service.scheduler;
import com.app.shared.scheduler.ArtJobDetails;

import com.app.shared.scheduler.ArtScheduleConfig;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.athena.server.pluggable.utils.bean.FindByBean;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;


/****
 * 
 * @author puja
 *
 */
@RestController
@RequestMapping("/ScheduleConfig")
public class AwsScheduleConfigController {
	@Autowired
	private RuntimeLogInfoHelper loginInfoHelper;

	@Autowired
	private ArtScheduleConfigService scheduleConfigService;

	@RequestMapping(value = "/save", consumes = "application/json", method = RequestMethod.POST)
	public HttpEntity<ResponseBean> save(@RequestBody ArtScheduleConfig entity, HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
		try {
			scheduleConfigService.save(entity);
			responseBean.add("success", true);
			responseBean.add("message", "Successfully Created");
		} catch (Exception e) {
			responseBean.add("success", false);
			responseBean.add("message", e.getMessage());
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}

	@RequestMapping(value = "/update", consumes = "application/json", method = RequestMethod.PUT)
	public HttpEntity<ResponseBean> update(@RequestBody ArtScheduleConfig entity, HttpServletRequest request, HttpServletResponse response) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
		try {
			scheduleConfigService.update(entity);
			responseBean.add("success", true);
			responseBean.add("message", "Successfully updated ");
		} catch (Exception e) {
			responseBean.add("success", false);
			responseBean.add("message", e.getMessage());
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}


	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public HttpEntity<ResponseBean> findById(@RequestBody FindByBean findByBean) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;

		try {
			ArtScheduleConfig entity = scheduleConfigService.findById((String) findByBean.getFindKey());
			responseBean.add("success", true);
			responseBean.add("message", "Successfully retrived ");
			responseBean.add("data", entity);
		} catch (Exception e) {
			responseBean.add("success", false);
			responseBean.add("message", " Error in retriveing entity " + e.getMessage());
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}
	
	@RequestMapping(value = "/findJobs", method = RequestMethod.GET)
	public HttpEntity<ResponseBean>  findJobs(HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
		try {
			List<ArtJobDetails> entity = scheduleConfigService.findAllJobs();
//			JSONObject json=new JSONObject(entity);
			responseBean.add("success", true);
			responseBean.add("message", "Successfully retrived ");
			responseBean.add("data", entity);
		} catch (Exception e) {
			responseBean.add("success", false);
			responseBean.add("message", " Error in retriveing entity " + e.getMessage());
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}
	
	@RequestMapping(value = "/getTreeStore", consumes = "application/json", method = RequestMethod.GET)
	public HttpEntity<ResponseBean> getTreeStore(HttpServletRequest request) {
		ResponseBean responseBean = new ResponseBean();
		org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.OK;
		try {
			responseBean.add("success", true);
			responseBean.add("message", "Successfully retrived ");
			responseBean.add("data",  scheduleConfigService.getTreeStores().toString());
		}catch (Exception e) {
			responseBean.add("success", false);
			responseBean.add("message", " Error in retriveing entity" + e.getMessage());
		}
		return new org.springframework.http.ResponseEntity<ResponseBean>(responseBean, httpStatus);
	}
	
}
