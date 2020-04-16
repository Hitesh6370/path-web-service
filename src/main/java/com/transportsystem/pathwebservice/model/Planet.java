package com.transportsystem.pathwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Planet.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Planet {

    private int id;
    private String planetNode;
    private String planetName;
}
