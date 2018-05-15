package com.hdpsolutions.docbaotest.ebus;


import com.hdpsolutions.docbaotest.dto.PaperDto;

public class HomeEvent {

    public PaperDto paperDto;
    public int positionCate;

    public HomeEvent() {}

    public HomeEvent(int positionCate, PaperDto paperDto) {
        this.positionCate = positionCate;
        this.paperDto = paperDto;
    }
}
