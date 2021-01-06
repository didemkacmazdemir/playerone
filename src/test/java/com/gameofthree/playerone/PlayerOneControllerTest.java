package com.gameofthree.playerone;

import com.gameofthree.playerone.controller.PlayOneController;
import com.gameofthree.playerone.model.Result;
import com.gameofthree.playerone.service.PlayerOneService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(PlayOneController.class)
public class PlayerOneControllerTest {
    @MockBean
    PlayerOneService playerOneService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void playerTest(){
        Result result = new Result();
        result.setNumber(19);
        result.setMessage("KEEP");

        Result result2 = new Result();
        result.setNumber(0);
        result.setMessage("DONE");
        when(playerOneService.playNumber(56,"KEEP")).thenReturn(result);

        Assert.assertEquals(result.getNumber(), 19);
        Assert.assertEquals(result.getMessage(), "KEEP");

    }
}
