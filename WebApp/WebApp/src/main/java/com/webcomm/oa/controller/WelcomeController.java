package com.webcomm.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webcomm.oa.data.CaseMonitorLevelEnum;
import com.webcomm.oa.data.CaseTypeEnum;
import com.webcomm.oa.domain.CaseReq;
import com.webcomm.oa.domain.Employee;
import com.webcomm.oa.service.CaseReqService;
import com.webcomm.oa.service.EmpService;
import com.webcomm.oa.service.UnitService;

@Controller
public class WelcomeController {
	@Autowired
	EmpService empService;
	@Autowired
	UnitService unitService;
	@Autowired
	CaseReqService caseReqService;
	@RequestMapping({"/index"})
	public String index(@RequestParam (name = "id", required = false) String empId, 
						Model model) {		
		/*
		 * Get All MonitorEnum and transfer to Map
		 */
		Map<String, String>monitor = new HashMap<>();
		for(CaseMonitorLevelEnum monitorEnum : CaseMonitorLevelEnum.values()) {
			monitor.put(monitorEnum.name(), monitorEnum.getMonitorLevel());
		}
		model.addAttribute("monitorMap", monitor);
		
		/*
		 * Get All TypeEnum and transfer to Map
		 */
		Map<String, String>type = new HashMap<>();
		for(CaseTypeEnum typeEnum : CaseTypeEnum.values()) {
			type.put(typeEnum.name(), typeEnum.getType());
		}
		model.addAttribute("typeMap", type);
		
		/*
		 * Get all Unit
		 */
		model.addAttribute("unitList", unitService.getAll());
		
		/*
		 * index request的時候回傳一個CaseReq讓form表單使用
		 */
		model.addAttribute("caseReq", new CaseReq());
		
		return "index";
//測試SERVICE
//		System.out.println(unitService.getOne("FDC1100").getName());
//		System.out.println(caseReqService.getOne("CASE001").getMonitorLevel().getMonitorLevel());
//		System.out.println(caseReqService.getOne("CASE001").getType().getType());
//		for(CaseReq casePage : caseReqService.getPagedCase(1, 3)) {
//			System.out.println(casePage.getCaseNo());
//		}
//分頁功能		
//		Page casePage = caseReqService.PagesCase();
//		System.out.println(casePage.getNumber());
//		System.out.println(casePage.getTotalPages());

		
	}
	/*
	 * 查全部Case
	 */
	@RequestMapping("/getAllCase")
	public String getAllEmp(Model model) {
		model.addAttribute("allCase", caseReqService.getPagedCase(0, 20));
		model.addAttribute("caseReq", new CaseReq());
		
		// spring-devtools
		return "index";
	}
	/*
	 * get method = post form
	 */
	@PostMapping("/index/search")
	public String getCaseFromForm(@ModelAttribute CaseReq bean, Model model) {
		List<CaseReq>searchResult = caseReqService.getCaseByVar(bean);
		model.addAttribute("allCase", searchResult);
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(path = {"/index/jsonSearch"}, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@CrossOrigin("http://localhost:8081")
	public List<CaseReq> result(@RequestBody CaseReq bean){
		System.out.println("進JSON");
		System.out.println(bean.getCaseNo());
		return caseReqService.getCaseByVar(bean);
//		return caseReqService.getCaseByVar(bean).get(0);
		
	}
//	@RequestMapping(path = {"index/jsonSearch"})
//	@ResponseBody
//	public Map<String, String> findUserInfo(){
//		System.out.println("hihi map!!!!");
//		Map<String, String> map = new HashMap<>();
//		map.put("id001", "hello");
//		map.put("id002", "world");
//		map.put("id003", "!!!!");
//		return map;
//	}
}
