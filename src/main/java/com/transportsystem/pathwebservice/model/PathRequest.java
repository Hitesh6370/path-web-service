package com.transportsystem.pathwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Path request.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PathRequest {

    private String source;
    private String destination;
}
