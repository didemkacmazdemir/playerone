package com.gameofthree.playerone.service;

import com.gameofthree.playerone.model.Result;

public interface IPlayerOneService {
    public Result playNumber(int number, String message);
    public void callPlayerTwo(int number, String message);
}
