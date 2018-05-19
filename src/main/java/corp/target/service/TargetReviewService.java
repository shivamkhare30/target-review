package corp.target.service;

import corp.target.constants.TargetReviewConstants;
import corp.target.data.ReviewRequest;

/**
 * 
 * @author shivamkhare
 *
 */
public interface TargetReviewService extends TargetReviewConstants {

	public String validateReview(ReviewRequest reviewRequest);
}
