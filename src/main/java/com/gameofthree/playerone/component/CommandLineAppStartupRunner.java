package com.gameofthree.playerone.component;

import com.gameofthree.playerone.constant.GameConstants;
import com.gameofthree.playerone.controller.PlayOneController;
import com.gameofthree.playerone.exception.RestApiCallException;
import com.gameofthree.playerone.model.ConsumedResult;
import com.gameofthree.playerone.service.PlayerOneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.Scanner;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(CommandLineAppStartupRunner.class);

    @Autowired
    PlayerOneService playerOneService;

    @Autowired
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please Select : G(Generate Number), M(Manuel Number) => ");
        String selection = input.nextLine();

        int number=0;
        if(selection.toUpperCase().equals("G")) {
            number = randomNumberGenerate(1, 100);
        } else if(selection.toUpperCase().equals("M")) {
            System.out.println("Please Type Number => ");
            number = input.nextInt();
        }else{
            System.out.println("Please Type Number Correctly => ");
        }
        try{
            logger.debug("Player One Calling Player Two...");

            StringBuilder urlStringBuilder = new StringBuilder();

            urlStringBuilder.append(GameConstants.URL);
            urlStringBuilder.append(number);
            urlStringBuilder.append(GameConstants.SLASH);
            urlStringBuilder.append(GameConstants.KEEP_MESSAGE);

            final String url =  urlStringBuilder.toString();
            ConsumedResult consumedResult = getRestTemplate().getForObject(
                    url, ConsumedResult.class);
        }catch (Exception e){
            throw new RestApiCallException("Player One Could not Call Player Two " + e);
        }

    }

    public static int randomNumberGenerate(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }
}
