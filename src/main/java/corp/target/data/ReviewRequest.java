package corp.target.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import corp.target.constants.TargetReviewConstants;

/**
 * 
 * @author shivamkhare
 *
 */
public class ReviewRequest implements TargetReviewConstants {

	@JsonProperty("productType")
	private ProductType productType;

	@JsonProperty("message")
	private String message;

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
