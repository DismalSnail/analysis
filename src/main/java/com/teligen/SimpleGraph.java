package com.teligen;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.graph.*;

import java.net.URI;
import java.net.URISyntaxException;

public  class SimpleGraph {
    public static void main(String[] args) throws URISyntaxException {
        Graph<URI, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
        URI google = new URI("http://www.google.com");
        URI wikipedia = new URI("http://www.wikipedia.org");
        URI jgrapht = new URI("http://www.jgrapht.org");


    }
}


