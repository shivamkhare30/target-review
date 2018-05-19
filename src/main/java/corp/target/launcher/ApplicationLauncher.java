package corp.target.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "corp.target" })
@SpringBootApplication
public class ApplicationLauncher {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationLauncher.class, args);
		// TargetReviewServiceImpl ts = new TargetReviewServiceImpl();

		/*
		 * ReviewRequest rr = new ReviewRequest(); rr.setMessage("Its awesome");
		 * rr.setProductType(ProductType.ELECTRONICS); ts.validateReview(rr);
		 */
	}
}
