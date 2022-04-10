package adbrix.collect.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AwsSqsConfig {

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    /**
     * AWS 자격 증명 Bean 등록
     */
    @Bean
    @Primary //Bean 등록 우선순위
    public AWSCredentialsProvider awsCredentialsProvider(){
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey,secretKey));
    }

    /**
     *AWS SQS Client Bean 등록
     */
    @Bean
    public AmazonSQS amazonSQS(){
        return AmazonSQSClient.builder()
                .withCredentials(awsCredentialsProvider())
                .withRegion(region)
                .build();
    }
}
