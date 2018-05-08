package com.oscarchang.androidapp.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.oscarchang.androidapp.bean.ActorBean;
import com.oscarchang.androidapp.bean.MovieBean;
import com.oscarchang.androidapp.bean.Movies;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by SDT13976 on 2018/4/19.
 */
public class MovieTypeAdapter extends TypeAdapter {

    @Override
    public void write(JsonWriter out, Object value) throws IOException {
        Movies movies = (Movies)value;
        out.name("movies").beginArray();
        for (MovieBean movieBean:movies.getMovies()){
            out.beginObject();
            out.name("name").value(movieBean.getName());
            out.name("year").value(movieBean.getYear());
            out.name("actor").beginArray();
            for (ActorBean actor : movieBean.getActors()){
                out.beginObject();
                out.name("alpha").value(actor.getAlpha());
                out.name("beta").value(actor.getBeta());
                out.endObject();
            }
            out.endArray();
            out.name("director").value(movieBean.getDirector());
            out.endObject();
        }
        out.endArray();
    }

    @Override
    public Object read(JsonReader in) throws IOException {
        final Movies movies = new Movies();
        final ArrayList<MovieBean> movieBeans = new ArrayList<MovieBean>();
        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "movies":
                    final MovieBean movieBean = new MovieBean();
                    in.beginArray();
                    while (in.hasNext()) {
                        switch (in.nextName()) {
                            case "name":
                                movieBean.setName(in.nextString());
                                break;
                            case "year":
                                movieBean.setName(in.nextString());
                                break;
                            case "actor":
                                in.beginArray();
                                ArrayList<ActorBean> actorBeans = new ArrayList<ActorBean>();
                                while (in.hasNext()) {
                                    ActorBean actorBean = new ActorBean();
                                    switch (in.nextName()) {
                                        case "alpha":
                                            actorBean.setAlpha(in.nextString());
                                            break;
                                        case "beta":
                                            actorBean.setBeta(in.nextString());
                                            break;
                                    }
                                    movieBean.setActors(actorBeans);
                                }
                                in.endArray();
                                break;
                            case "director":
                                movieBean.setDirector(in.nextString());
                                break;
                        }
                        movieBeans.add(movieBean);
                    }
                    in.endArray();
                    break;
            }
        }
        in.endObject();
        return movieBeans;
    }
}
