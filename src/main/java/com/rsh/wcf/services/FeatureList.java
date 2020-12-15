package com.rsh.wcf.services;

import com.google.gson.*;
import com.rsh.wcf.pojo.Feature;

public class FeatureList {
    private static JsonArray features;

    private static final Object mutex = new Object();

    private static void init() {
        // this should be replaced with initialization from a data source
        features = new JsonArray();
        JsonObject feature = new JsonObject();
        feature.addProperty(Feature.PROP_TITLE, "I would like the ability to update products.");
        feature.addProperty(Feature.PROP_DESCRIPTION, "As a user, I would like to be given the ability to add, remove, and change products.");
        feature.addProperty(Feature.PROP_CLIENT, "Client A");
        feature.addProperty(Feature.PROP_PRIORITY, 1);
        feature.addProperty(Feature.PROP_TARGET_DATE, "01/01/2021");
        feature.addProperty(Feature.PROP_AREA, "Products");
        features.add(feature);

        feature = new JsonObject();
        feature.addProperty(Feature.PROP_TITLE, "I would like the ability to update users.");
        feature.addProperty(Feature.PROP_DESCRIPTION, "As a user, I would like to be given the ability to add, remove, and change users.");
        feature.addProperty(Feature.PROP_CLIENT, "Client B");
        feature.addProperty(Feature.PROP_PRIORITY, 2);
        feature.addProperty(Feature.PROP_TARGET_DATE, "02/01/2021");
        feature.addProperty(Feature.PROP_AREA, "Users");
        features.add(feature);

        feature.addProperty(Feature.PROP_TITLE, "I would like the ability to update departments.");
        feature.addProperty(Feature.PROP_DESCRIPTION, "As a user, I would like to be given the ability to add, remove, and change departments.");
        feature.addProperty(Feature.PROP_CLIENT, "Client C");
        feature.addProperty(Feature.PROP_PRIORITY, 3);
        feature.addProperty(Feature.PROP_TARGET_DATE, "03/01/2021");
        feature.addProperty(Feature.PROP_AREA, "Products");
        features.add(feature);
    }

    public static String getFeatures() {
        synchronized (mutex) {
            if( features == null ){
                init();
            }
        }
        return features.toString();
    }

    public static String updateFeatures( String newSettings ) throws JsonParseException {
        synchronized (mutex) {
            try {
                features = (JsonArray) JsonParser.parseString(newSettings);
                sortFeatures();
            } catch (JsonParseException e) {
                e.printStackTrace();
            }
        }
        return features.getAsString();
    }

    private static void sortFeatures() {
        synchronized (mutex) {
            for (int i = 0; i < features.size() - 1; i++) {
                for (int j = 1; j < features.size(); j++) {
                    JsonObject obj1 = features.get(i).getAsJsonObject();
                    JsonObject obj2 = features.get(j).getAsJsonObject();
                    if (obj1.get(Feature.PROP_PRIORITY).getAsInt() > obj2.get(Feature.PROP_PRIORITY).getAsInt()) {
                        features.set(i, obj2);
                        features.set(j, obj1);
                    }
                }
            }
        }
    }
}
