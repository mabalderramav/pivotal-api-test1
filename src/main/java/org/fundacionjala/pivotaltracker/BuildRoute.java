package org.fundacionjala.pivotaltracker;

/**
 * Class to build the Route of the end point
 */
public class BuildRoute {

    public void BuildRoute(){

    }
    public static String  buildProjectRoute(String endpoint, int id_Project){
        String regex ="\\[([aA-zA]*\\.[aA-zZ]*)\\]";
        endpoint = endpoint.replaceAll(regex,Integer.toString(id_Project));
        return endpoint;
    }

}
