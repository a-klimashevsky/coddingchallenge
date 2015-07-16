package com.example.imagefeatcher.web;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by Alex Klimashevsky on 16.07.2015.
 */
public interface Api {
    @GET("/wirestorm/assets/response.json")
    List<Candidate> listCandidates();
}
