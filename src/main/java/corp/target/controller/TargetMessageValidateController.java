package corp.target.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import corp.target.data.ReviewRequest;
import corp.target.service.TargetReviewService;

/**
 * 
 * @author shivamkhare
 *
 */
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = { "corp.target" })
public class TargetMessageValidateController {

	@Autowired
	private TargetReviewService targetReviewService;

	@RequestMapping(value = "corp-target/heart-beat")
	public String heartBeat() {
		return "Heart is beating .. .. ..";
	}

	@RequestMapping(value = "corp-target/validate",  method = { RequestMethod.POST })
	public String validate(@RequestBody ReviewRequest reviewRequest) {
		String result = targetReviewService.validateReview(reviewRequest);
		
		System.out.println("RES -->" + result);
		return result;
	}
}
