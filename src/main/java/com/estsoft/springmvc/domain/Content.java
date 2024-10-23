package com.estsoft.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String title;
    private String body;

    @Override
    public String toString() {
        return "#title:; " + title + ", #body: " + body;
    }
}
