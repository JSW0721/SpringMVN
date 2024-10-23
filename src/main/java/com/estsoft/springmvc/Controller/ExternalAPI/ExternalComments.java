package com.estsoft.springmvc.Controller.ExternalAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExternalComments {
    private Long postId;
    private String body;
}
