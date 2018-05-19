package corp.target.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import corp.target.data.ReviewRequest;
import corp.target.util.TargetReviewUtil;

/**
 * 
 * @author shivamkhare
 *
 */
@Service
public class TargetReviewServiceImpl implements TargetReviewService {

	private String objectionableFilename = "resources/objectionale_content.json";

	public String validateReview(ReviewRequest reviewRequest) {

		Map<String, Object> objectionableContent = TargetReviewUtil.getObjectionableContent(objectionableFilename);

		String review = reviewRequest.getMessage();

		ProductType product = reviewRequest.getProductType();

		List<String> objectionableWords = (ArrayList<String>) objectionableContent.get(product.name());
		boolean isObjectionable = false;
		if (objectionableWords != null) {
			for (String word : objectionableWords) {
				if (review.contains(word)) {
					isObjectionable = true;
					break;
				}
			}
		}
		return String.valueOf(!isObjectionable);
		/*
		 * System.out.println(review);
		 * 
		 * System.out.println(product.name()); System.out.println();
		 * System.out.println(); for (String key : objectionableContent.keySet()) {
		 * String d = ((ArrayList<String>) objectionableContent.get(key)).toString();
		 * System.out.println(key + " -->  " + d); } // TODO Auto-generated method stub
		 * return null;
		 */
	}

}
