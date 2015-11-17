package com.oris.common.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.oris.base.BaseController;
import com.oris.enums.LinksEnum;
import com.oris.enums.StatusEnum;
import com.oris.mis.model.Event;
import com.oris.mis.model.Videos;
/*import com.oris.mis.model.Product;*/
import com.oris.mis.model.Solution;
import com.oris.mis.service.MISService;
import com.oris.util.Config;
import com.oris.util.InventoryUtility;
import com.oris.util.Page;


@Controller
public class HomeController extends BaseController {
	protected static Logger logger = Logger.getLogger(HomeController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	@ExceptionHandler
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public String notFoundEceptionHandler(ModelMap map) {
		return getHome(map);
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String getHome(ModelMap model) {
		
		//top 3 list of events
		
		Event event = new Event();
		event.setOrderBy("e.createdDate");
		event.setSortBy("desc");
		event.setStatus(StatusEnum.ACTIVE.getId());
		event.setStartLimit(0);
		event.setEndLimit(5);
		Page page = misService.viewEvents(event);
		model.addAttribute("eventPage", page);
				
		Videos obj = misService.getVideo();
		if(!InventoryUtility.isNull(obj)) {
			model.addAttribute("video", obj);
			model.addAttribute("videoLink1", Config.getProperties("home.video.url")+obj.getLink1().substring(obj.getLink1().lastIndexOf("/") + 1));
			model.addAttribute("videoLink2", Config.getProperties("home.video.url")+obj.getLink2().substring(obj.getLink2().lastIndexOf("/") + 1));
			model.addAttribute("videoLink3", Config.getProperties("home.video.url")+obj.getLink3().substring(obj.getLink3().lastIndexOf("/") + 1));
		}
		
		
		Solution solution = new Solution();
		solution.setOrderBy("s.createdDate");
		solution.setSortBy("desc");
		solution.setStartLimit(0);
		solution.setEndLimit(5);
		page = misService.viewSolutions(solution);
		model.addAttribute("solutionPage", page);
		
		model.addAttribute("activeMenu", LinksEnum.HOME.getId());
		return "homePage";
	}	
}